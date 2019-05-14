package cn.edu.aynu.user.dao;

import cn.edu.aynu.user.entities.Bill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * company: www.abc.com
 * Author: KevinLee
 * Create Data: 2019/3/21
 */
@Mapper
public interface BillDao {
    List<Bill> get(Bill bill);

    List<Bill> getId(Integer bid);
}
