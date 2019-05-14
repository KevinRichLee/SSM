package com.hrm.user.service;

import com.hrm.user.beans.Notice;
import com.hrm.user.dao.NoticeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;
    @Override
    public Integer selectCount(Notice notice) {
        return noticeDao.selectCount(notice);
    }

    @Override
    public List<Notice> selectByCondition(Map map) {
        return noticeDao.selectByCondition(map);
    }

    @Override
    public void removeNotice(int[] ids) {
        noticeDao.deleteNotice(ids);
    }

    @Override
    public Notice selectNoticeById(Integer id) {
        return noticeDao.selectNoticeById(id);
    }

    @Override
    public Notice updateSelect(Integer id) {
        return noticeDao.updateSelect(id);
    }

    @Override
    public void updateNotice(Notice notice) {
        noticeDao.updateNotice(notice);
    }

    @Override
    public void addNotice(Notice notice) {
        noticeDao.addNotice(notice);
    }
}
