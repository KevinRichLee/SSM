package com.hrm.user.dao;

import com.hrm.user.beans.Dept;
import com.hrm.user.beans.Employee;
import com.hrm.user.beans.Job;

import java.util.List;
import java.util.Map;

public interface EmployeeDao {
    Integer selectCount(Employee employee);

    List<Employee> selectByCondition(Map map);

    void deleteEmplee(int[] ids);

    List<Employee> addSelect();

    void addEmployee(Employee employee);

    Employee updateSelectEmployee(Integer id);

    void updateEmployee(Employee employee);

    List<Dept> selectAllDept();

    List<Job> selectAllJob();
}
