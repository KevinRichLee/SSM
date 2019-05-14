package com.hrm.user.controller;

import com.hrm.user.beans.User;
import com.hrm.user.service.UserService;
import com.hrm.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    //登录
    @RequestMapping("/login.do")
    public String loginByUser(User user, HttpSession session, Model model){
        User loginUser = userService.loginByUser(user);
        model.addAttribute("errorlogin","用户名或密码错误");
        session.setAttribute("loginUser",loginUser);
        if(loginUser!=null){
            System.out.println(111);
            return "/jsp/main.jsp";
        }else{
            return "redirect:/index.jsp";
        }

    }
    //检验用户名是否重复
    @RequestMapping("/checkLoginname.do")
    @ResponseBody
    public String checkLoginname(String loginname){
        String data = userService.selectloginname(loginname);
        return data;
    }
    //退出登录
    @RequestMapping("/logout.do")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/index.jsp";
    }
    //根据ID查用户信息
    @RequestMapping("/selectUserById.do")
    public String selectUserById(Integer id,Model model){
        System.out.println(id);
        User user = userService.selectUserById(id);
        System.out.println(user);
        model.addAttribute("user",user);
        return "/jsp/user/showUpdateUser.jsp";
    }
    //查询所用用户信息
    @RequestMapping("/selectAll.do")
    public String selectAll(@RequestParam(defaultValue = "1") Integer pageIndex, User user, HttpSession session, Model model){
        System.out.println("select进来了");
        System.out.println(user);
        PageModel pageModel = new PageModel();
        pageModel.setPageIndex(pageIndex);
        Map map = new HashMap();
        map.put("pageModel",pageModel);
        map.put("user",user);
        List<User> userAll = userService.selectAll(map);
        for (User u:userAll){
            System.out.println("user="+u);
        }
        session.setAttribute("userAll",userAll);
        String username = user.getUsername();
        String status = user.getStatus();
        Integer total = userService.selectTotal(user);
        pageModel.setRecordCount(total);
        model.addAttribute("username",username);
        model.addAttribute("status",status);
        model.addAttribute("pageModel",pageModel);


        for(User u:userAll){

            System.out.println(u);
        }
        return "/jsp/user/user.jsp";
    }
//    添加用户信息
    @RequestMapping("/addUser.do")
    public String addUser(User user){

        userService.addUser(user);
        return "selectAll.do";
    }
//    删除用户信息
    @RequestMapping("/deleteUser.do")
    public String deleteUser(int[] ids){
        System.out.println("jinlaile ");
        userService.deleteUser(ids);
        return "selectAll.do";
    }
//    修改用户信息
    @RequestMapping("/modifyUser.do")
    public String modifyUser(User user){
        System.out.println("修改的"+user);
        userService.modifyUser(user);
        return "selectAll.do";
    }
}
