package com.hrm.user.controller;


import com.hrm.user.beans.Job;
import com.hrm.user.service.JobService;
import com.hrm.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService jobService;
    @RequestMapping("/selectAllJob.do")
    public String selectAllJob(@RequestParam(defaultValue = "1") Integer pageIndex, HttpSession session, Job job, Model model){
        PageModel pageModel = new PageModel();
        pageModel.setPageIndex(pageIndex);
        Integer recordCount = jobService.selectCount(job);
        pageModel.setRecordCount(recordCount);
        Map map = new HashMap();
        map.put("job",job);
        map.put("pageModel",pageModel);
        List<Job> jobs = jobService.selectAllJob(map);
        session.setAttribute("jobs",jobs);
        model.addAttribute("pageModel",pageModel);
        model.addAttribute("job",job);
        return "/jsp/job/job.jsp";
    }
    //删除职位
    @RequestMapping("/removeJob.do")
    @ResponseBody
    public String removeJob(int[] ids){
        try {
            System.out.println(ids[0]);
            jobService.removeJob(ids);
        }catch (DataIntegrityViolationException e){

        }finally {
            return "false,Sorry,you can't delete them.They're binding with foreign key";
        }
    }
    @RequestMapping("/addJob.do")
    public String addJob(Job job,Model model){
        System.out.println(job);
        jobService.addJob(job);
        model.addAttribute("job",job);
        return "selectAllJob.do";
    }
    @RequestMapping("/selectJobById.do")
    public String selectJobById(Integer id, Model model){
        Job job = jobService.selectJobById(id);
        model.addAttribute("job",job);
        return "/jsp/job/showUpdateJob.jsp";
    }
    @RequestMapping("/updateJob.do")
    public String modifyJob(Job job){
        jobService.modifyJob(job);
        return "selectAllJob.do";
    }
}
