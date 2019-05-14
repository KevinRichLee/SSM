package cn.edu.aynu.user.service;

import cn.edu.aynu.user.dao.BillDao;
import cn.edu.aynu.user.entities.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * company: www.abc.com
 * Author: KevinLee
 * Create Data: 2019/3/21
 */
@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillDao billDao;
    @Override
    public List<Bill> get(Bill bill) {
        return billDao.get(bill);
    }

    @Override
    public List<Bill> getId(Integer bid) {
        return billDao.getId(bid);
    }
}
