package com.hrm.user.controller;

import com.hrm.user.beans.Notice;
import com.hrm.user.beans.User;
import com.hrm.user.service.NoticeService;
import com.hrm.utils.PageModel;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    @RequestMapping("/selectByCondition.do")
    public String selectByCondition(@RequestParam(defaultValue = ("1")) Integer pageIndex, Notice notice, Model model){
        PageModel pageModel = new PageModel();
        pageModel.setPageIndex(pageIndex);
        Integer recordCount = noticeService.selectCount(notice);
        pageModel.setRecordCount(recordCount);
        Map map = new HashMap();
        map.put("pageModel",pageModel);
        map.put("notice",notice);
        List<Notice>  notices = noticeService.selectByCondition(map);
        model.addAttribute("notices",notices);
        model.addAttribute("notice",notice);
        model.addAttribute("pageModel",pageModel);
        return "/jsp/notice/notice.jsp";
    }
    //删除公告
    @RequestMapping("/removeNotice.do")
    public String removeNotice(int[] ids){
        noticeService.removeNotice(ids);
        return "selectByCondition.do";
    }
    @RequestMapping("/previewNotice.do")
    public String previewNotice(Integer id,Model model){
        Notice notice = noticeService.selectNoticeById(id);
        model.addAttribute("notice",notice);
        return "/jsp/notice/previewNotice.jsp";
    }
    //修改查询数据回显
    @RequestMapping("/updateSelect.do")
    public String updateSelect(Integer id,Model model){
        Notice notice = noticeService.updateSelect(id);
        model.addAttribute("notice",notice);
        return "/jsp/notice/showUpdateNotice.jsp";
    }
    //修改公告信息
    @RequestMapping("/updateNotice.do")
    public String updateNotice(Notice notice){
        noticeService.updateNotice(notice);
        return "selectByCondition.do";
    }
    //添加公告信息
    @RequestMapping("/addNotice.do")
    public String addNotice(Notice notice){
        noticeService.addNotice(notice);
        return "selectByCondition.do";
    }
}
