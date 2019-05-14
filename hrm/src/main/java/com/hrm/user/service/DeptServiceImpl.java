package com.hrm.user.service;

import com.hrm.user.beans.Dept;
import com.hrm.user.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * company: www.abc.com
 * Author: KevinLee
 * Create Data: 2019/3/16
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;
    @Override
    public List<Dept> selectAllDept(Map map) {
        return deptDao.selectAllDept(map);

    }


    @Override
    public Integer selectCount(Dept dept) {
        return deptDao.selectCount(dept);
    }

    @Override
    public List<Dept> getAll() {
        return deptDao.getAll();
    }

    @Override
    public void removeDept(int[] ids) {
        deptDao.deleteById(ids);
    }

    @Override
    public void addDept(Dept dept) {
        deptDao.insertDept(dept);
    }

    @Override
    public void modifyDept(Dept dept) {
        deptDao.updateDept(dept);
    }

    @Override
    public Dept selectDeptById(Integer id) {
        return deptDao.selectDeptById(id);
    }
}
