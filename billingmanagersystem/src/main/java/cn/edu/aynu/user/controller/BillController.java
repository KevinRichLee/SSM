package cn.edu.aynu.user.controller;

import cn.edu.aynu.user.entities.Bill;
import cn.edu.aynu.user.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * company: www.abc.com
 * Author: KevinLee
 * Create Data: 2019/3/21
 */
@Controller
public class BillController {
    @Autowired
    private BillService billService;
    @GetMapping("/bill")
    public String get(Bill bill, Model model){
        System.out.println();
        List<Bill> bills = billService.get(bill);
        model.addAttribute("bills",bills);
        model.addAttribute("bill",bill);
        return "bill/list";
    }
    @PostMapping("/bill/bid")
    @ResponseBody
    public String billName(Integer bid){
        System.out.println(bid);
        List<Bill> billList = billService.getId(bid);
        return "billList";
    }
}
