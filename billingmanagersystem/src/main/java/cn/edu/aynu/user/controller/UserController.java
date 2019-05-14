package cn.edu.aynu.user.controller;

import cn.edu.aynu.user.dao.UserDao;
import cn.edu.aynu.user.entities.User;
import cn.edu.aynu.user.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * company: www.abc.com
 * Author: KevinLee
 * Create Data: 2019/3/14
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String login(){

        return "main/login";
    }
    //用户登录验证
    @PostMapping("login")
    public String checkLogin(User user, HttpSession session,Model model){
        User loginUser = userService.login(user);
        if(loginUser!=null){
            session.setAttribute("user",loginUser);
            return "main/index";
        }
        model.addAttribute("errorLogin","用户名密码不正确");
        return "main/login";
    }
    //用户退出
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "main/login";
    }
    //用户查询
    @GetMapping("/user")
    public String getUser(Model model,User user){
        List<User> users =  userService.getUser(user);
        for(User u:users){
            System.out.println(u);
        }
        model.addAttribute("users",users);
        model.addAttribute("user",user);
        return "user/list";
    }
    @GetMapping("/view/{id}")
    public String viewUser(@PathVariable("id") Integer id,Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "user/view";
    }
    //修改前数据回显
    @GetMapping("/update/{id}")
    public String updateId(@PathVariable("id") Integer id,Model model){
        User user = userService.getUpdateId(id);
        model.addAttribute("user",user);
        return "user/update";
    }
    @PutMapping("/update")
    public String update(User user){
        userService.update(user);
        return "redirect:/user";
    }
    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id")Integer id){
        userService.delete(id);
        return "redirect:/user";
    }
    //添加用户信息
    @PostMapping("/add")
    public String add(User user){
        userService.add(user);
        return "redirect:/user";
    }
    @GetMapping("/addPage")
    public String addPage(){
        return "user/add";
    }
    @GetMapping("/password")
    public String password(){

        return "main/password";
    }
}
