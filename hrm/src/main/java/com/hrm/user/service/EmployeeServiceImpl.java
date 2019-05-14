package com.hrm.user.service;

import com.hrm.user.beans.Dept;
import com.hrm.user.beans.Employee;
import com.hrm.user.beans.Job;
import com.hrm.user.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Integer selectCount(Employee employee) {
        return employeeDao.selectCount(employee);
    }

    @Override
    public List<Employee> selectByCondition(Map map) {
        return employeeDao.selectByCondition(map);
    }

    @Override
    public void removeEmployee(int[] ids) {
        employeeDao.deleteEmplee(ids);
    }

    @Override
    public List<Employee> addSelect() {
        return employeeDao.addSelect();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public Employee updateSelectEmployee(Integer id) {
        return employeeDao.updateSelectEmployee(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    @Override
    public List<Dept> selectAllDept() {
        return employeeDao.selectAllDept();
    }

    @Override
    public List<Job> selectAllJob() {
        return employeeDao.selectAllJob();
    }

}
