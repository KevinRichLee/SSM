package cn.edu.aynu.user.service;

import cn.edu.aynu.user.entities.Bill;

import java.util.List;

/**
 * company: www.abc.com
 * Author: KevinLee
 * Create Data: 2019/3/21
 */
public interface BillService {
    List<Bill> get(Bill bill);

    List<Bill> getId(Integer bid);
}
