package com.hrm.user.service;

import com.hrm.user.beans.Job;
import com.hrm.user.dao.JobDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobDao jobDao;
    @Override
    public List<Job> selectAllJob(Map map) {
        return jobDao.selectAllJob(map);
    }

    @Override
    public Integer selectCount(Job job) {
        return jobDao.selectCount(job);
    }

    @Override
    @Transactional
    public void removeJob(int[] ids) {
        jobDao.removeJob(ids);
    }

    @Override
    public void addJob(Job job) {
        jobDao.addJob(job);
    }

    @Override
    public Job selectJobById(Integer id) {
        return jobDao.selectJobById(id);
    }

    @Override
    public void modifyJob(Job job) {
        jobDao.updateJob(job);
    }
}
