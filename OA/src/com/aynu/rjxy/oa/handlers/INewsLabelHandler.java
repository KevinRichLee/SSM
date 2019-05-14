package com.aynu.rjxy.oa.handlers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aynu.rjxy.common.beans.NewsLabel;
import com.aynu.rjxy.oa.INewsLabelService.INewsLabelService;
import com.aynu.rjxy.oa.vo.Page;

@Controller
@RequestMapping("/test")
public class INewsLabelHandler {
	
	@Resource(name="newsLabelService")
	private INewsLabelService service;

	public void setService(INewsLabelService service) {
		this.service = service;
	}

	@RequestMapping("/queryNewsLabel.do")
	public String newLabelHandler(@RequestParam(defaultValue="1")int pagenum,HttpSession session,@RequestParam(defaultValue="0")int id) {
		//查询所有一级栏目
		//System.out.println(pagenum);
		System.out.println("id="+id);
		session.setAttribute("id", id);
		//List<NewsLabel> child = service.findAllChildren();
		//session.setAttribute("child", child);
		List<NewsLabel> parents = service.findAllParents();
		//将查询到的信息放在session域里
		session.setAttribute("parents", parents);
		
		//查询当前页面信息
		Page<NewsLabel> page = service.findCurrentPage(pagenum,id);
		session.setAttribute("page", page);
		//System.out.println(page);
		return "/html/news/newsLabelManager.jsp";
	}
	
	@RequestMapping("/deleteNewsLabel.do")
	public String newLabelHandler2(Integer id,Model model) {
       try {
    	   int rows = service.removeNewsLabelById(id);
    	   if(rows>0) {
    		   model.addAttribute("message", "删除成功");
    	   }else {
    		   model.addAttribute("message", "删除失败");
    	   }    	   
       }catch(DataIntegrityViolationException e){
    	   model.addAttribute("message", "该栏目存在子栏目无法删除");
       }
		
        //System.out.println(id);
        
		return "queryNewsLabel.do?id=0";
	}
	@RequestMapping("/modifyNewsLabel.do")
	public String newLabelHandler3(NewsLabel newslabel,HttpSession session) {
		newslabel = service.findNewsLabelById(newslabel.getId());
		session.setAttribute("newslabel", newslabel);
		return "/html/news/modifyNewsLabel.jsp";
	}
	
	@RequestMapping("/modifyNewsLabel1.do")
	public String newLabelHandler4(String label_name,String label_content,Integer parent_id) {
		
		NewsLabel newsLabel = new NewsLabel();
		newsLabel.setLabel_name(label_name);
		newsLabel.setLabel_content(label_content);
		newsLabel.setId(parent_id);
		service.modifyNewsLabel(newsLabel);
		System.out.println(label_name+","+label_content+","+parent_id);
		
		return "queryNewsLabel.do";
	}
	@RequestMapping("/addNewsLabel.do")
	public String newLabelHandler5(NewsLabel newsLabel) {
		System.out.println("newsLabel="+newsLabel);
		service.addNewsLabel(newsLabel);
		
		return "queryNewsLabel.do";
	}
}
