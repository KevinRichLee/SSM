package cn.edu.aynu.user.controller;

import cn.edu.aynu.user.entities.Provider;
import cn.edu.aynu.user.service.ProviderService;
import cn.edu.aynu.user.service.ProviderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * company: www.abc.com
 * Author: KevinLee
 * Create Data: 2019/3/15
 */
@Controller
public class ProviderController {
    @Autowired
    private ProviderService providerService;
    // 供应商管理
    @GetMapping("getAll")
    public String getProvider(String providerName,Model model){
        List<Provider> providers = providerService.selectProvider(providerName);
        for(Provider p:providers){
            System.out.println(p);
        }
        model.addAttribute("providers",providers);
        model.addAttribute("providerName",providerName);
        return "provider/list";
    }
    @GetMapping("provider/{pid}")
    public String providerView(@PathVariable("pid") Integer pid, Model model){
        Provider provider = providerService.selectProviderPid(pid);
        model.addAttribute("provider",provider);
        return "provider/view";
    }
    @GetMapping("provider/update/{pid}")
    public String providerUpdateEcho(@PathVariable("pid") Integer pid,Model model){
        Provider provider = providerService.selectProviderEcho(pid);
        model.addAttribute("provider",provider);
        return "provider/update";
    }
    @GetMapping("provider/listAll")
    public String providerList(Model model){
        providerService.findProviderByPage(1,4);
        List<Provider> providers = providerService.selectAllProviders();
        model.addAttribute("providers",providers);
        return "provider/list";
    }
    @PostMapping("provider/update")
    public String updateProvider(Provider provider){
        providerService.updateProvider(provider);
        System.out.println(provider);
        return "redirect:/provider/listAll";
    }
    @GetMapping("/provider/addPage")
    public String addPage(){
        return "provider/add";
    }
    @PostMapping("provider/add")
    public String addProvider(Provider provider){
        System.out.println(provider);
        providerService.addProvider(provider);
        return "redirect:/provider/listAll";
    }
    @DeleteMapping("provider/delete/{pid}")
    public String deleteProvider(@PathVariable("pid") Integer pid){
        providerService.deleteProvider(pid);
        System.out.println(111);
        return "redirect:/provider/listAll";
    }

    //账单管理
    @GetMapping("bill/list")
    public String billList(){
        return "bill/list";
    }
    //密码修改
    @GetMapping("main/password")
    public String mainPassword(){
        return "main/password";
    }

}
