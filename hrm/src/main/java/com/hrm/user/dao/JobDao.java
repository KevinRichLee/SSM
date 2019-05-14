package com.hrm.user.dao;

import com.hrm.user.beans.Job;

import java.util.List;
import java.util.Map;

public interface JobDao {
    List<Job> selectAllJob(Map map);

    Integer selectCount(Job job);

    void removeJob(int[] ids);

    void addJob(Job job);

    Job selectJobById(Integer id);

    void updateJob(Job job);
}
