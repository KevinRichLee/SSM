package com.hrm.user.controller;

import com.hrm.user.beans.Document;
import com.hrm.user.beans.User;
import com.hrm.user.service.DocumentService;
import com.hrm.utils.PageModel;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("document")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @RequestMapping("/selectByCondition.do")
    public String selectByCondition(@RequestParam(defaultValue = "1") Integer pageIndex, Document document, Model model) {
        PageModel pageModel = new PageModel();
        pageModel.setPageIndex(pageIndex);
        Integer recordCount = documentService.selectCount(document);
        pageModel.setRecordCount(recordCount);
        Map map = new HashMap();
        map.put("pageModel", pageModel);
        map.put("document", document);
        List<Document> documents = documentService.selectByCondition(map);
        model.addAttribute("pageModel", pageModel);
        model.addAttribute("documents", documents);
        model.addAttribute("document", document);
        return "/jsp/document/document.jsp";
    }

    @PostMapping("/addDocument.do")
    public String addDocument(Document document, HttpSession session, Model model) throws IOException {
        String path = "E:/upload";
        File upload = new File(path);
        if (!upload.exists()) {
            upload.mkdirs();
        }
        String fileName = UUID.randomUUID() + document.getFile().getOriginalFilename();
        document.getFile().transferTo(new File(path, fileName));
        document.setFilename(fileName);
        User user = (User) session.getAttribute("loginUser");
        document.setUser(user);
        document.setUser_id(user.getID());
        System.out.println(document);
        int rows = documentService.addDocument(document);
        if (rows > 0) {
            model.addAttribute("document", document);
            return "/document/selectByCondition.do";
        } else {
            model.addAttribute("file", "文件上传失败!");
            return "/jsp/uploadError.jsp";
        }
    }

    @GetMapping("/removeDocument.do")
    public String removeDocument(int[] ids) {
        for (int id : ids) {
            String filename = documentService.selectByFileName(id);
            String path = "E:/upload";
            File file = new File(path, filename);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
        documentService.removeDocument(ids);
        return "/document/selectByCondition.do";
    }
    @RequestMapping("updateDocument.do")
    public String updateDocument(String flag,Document document,Model model,HttpSession session) throws IOException {
        if(flag==null){
            document = documentService.selectDocument(document.getId());
            model.addAttribute("document",document);
            return "/jsp/document/showUpdateDocument.jsp";
        }
        //修改文件信息
        User loginUser = (User) session.getAttribute("loginUser");
        document.setUser_id(loginUser.getID());
        document.setUser(loginUser);
        model.addAttribute("document",document);
        System.out.println("操作用户的id"+document.getUser_id());
        //判断前端传来的有文件没
        if(!document.getFile().isEmpty()){
            //将原来的文件删除，先找到原来文件路径
            String path = "E:/upload";
            Document targetDocument = documentService.selectDocument(document.getId());
            //获取数据库中的filename
            String filename = targetDocument.getFilename();
            File file = new File(path,filename);
            if(file.exists()){
                file.delete();
            }
            String newFile = UUID.randomUUID()+"-"+document.getFile().getOriginalFilename();
            document.getFile().transferTo(new File(path,newFile));
            document.setFilename(newFile);
        }
        int row = documentService.updateDocument(document);
        if(row>0){
            return "/document/selectByCondition.do";
        }
        model.addAttribute("updateError","修改失败");
        return "/jsp/updateError.jsp";
    }
    @GetMapping("downLoad.do")
    public ResponseEntity<byte[]> downLoad(Integer id) throws IOException {
        Document target = documentService.selectDocument(id);
        String path = "E:/upload";
        String filename = target.getFilename();
        File file = new File(path, filename);
        if(!file.exists()){
            return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
        }
        HttpHeaders headers = new HttpHeaders();
        filename = new String(filename.getBytes("UTF-8"),"iso8859-1");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", filename);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);
    }
}
