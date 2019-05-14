package com.hrm.user.controller;

import com.hrm.user.beans.Dept;
import com.hrm.user.beans.Employee;
import com.hrm.user.beans.Job;
import com.hrm.user.service.EmployeeService;
import com.hrm.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/selectByCondition.do")
    public String selectByCondition(@RequestParam(defaultValue = "1") Integer pageIndex,Employee employee, Model model){
        System.out.println(employee);
        PageModel pageModel = new PageModel();
        pageModel.setPageIndex(pageIndex);
        Integer recordCount = employeeService.selectCount(employee);
        System.out.println("recordCount="+recordCount);
        pageModel.setRecordCount(recordCount);
        Map map = new HashMap();
        map.put("employee",employee);
        map.put("pageModel",pageModel);
        List<Employee> employees = employeeService.selectByCondition(map);
        System.out.println(222);
        List<Dept> depts = employeeService.selectAllDept();
        List<Job> jobs = employeeService.selectAllJob();
        model.addAttribute("depts",depts);
        model.addAttribute("jobs",jobs);
        model.addAttribute("employees",employees);
        model.addAttribute("pageModel",pageModel);
        model.addAttribute("employee",employee);
        return "/jsp/employee/employee.jsp";
    }
    //删除员工信息
    @RequestMapping("/removeEmployee.do")
    public String removeEmployee(int[] ids){
        employeeService.removeEmployee(ids);
        return "selectByCondition.do";
    }
    //添加员工第一步查询下拉列表信息
    @RequestMapping("/addSelect.do")
    public String addSelect(Model model){
        List<Dept> depts = employeeService.selectAllDept();
        List<Job> jobs = employeeService.selectAllJob();
        model.addAttribute("depts",depts);
        model.addAttribute("jobs",jobs);
//        for(Employee e:employees){
//            System.out.println(e);
//        }
        model.addAttribute("depts",depts);
        model.addAttribute("jobs",jobs);
        return "/jsp/employee/showAddEmployee.jsp";
    }
    @RequestMapping("/addEmployee.do")
    public String addEmployee(Employee employee){
        System.out.println(employee);
        employeeService.addEmployee(employee);
        return "redirect:selectByCondition.do";
    }
    //修改前数据回显
    @RequestMapping("/updateSelectEmployee.do")
    public String updateSelectEmployee(Integer id,Model model){
        Employee employee = employeeService.updateSelectEmployee(id);
        System.out.println(employee);
        List<Dept> depts = employeeService.selectAllDept();
        List<Job> jobs = employeeService.selectAllJob();
        model.addAttribute("depts",depts);
        model.addAttribute("jobs",jobs);
        model.addAttribute("employee",employee);
        return "/jsp/employee/showUpdateEmployee.jsp";
    }
    //修改员工信息
    @RequestMapping("/updateEmployee.do")
    public String updateEmployee(Employee employee){
        System.out.println(employee);
        employeeService.updateEmployee(employee);
        return "selectByCondition.do";
    }

}
