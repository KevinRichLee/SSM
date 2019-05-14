package com.hrm.user.service;

import com.hrm.user.beans.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface JobService {
    List<Job> selectAllJob(Map map);

    Integer selectCount(Job job);

    void removeJob(int[] ids);

    void addJob(Job job);

    Job selectJobById(Integer id);

    void modifyJob(Job job);
}
