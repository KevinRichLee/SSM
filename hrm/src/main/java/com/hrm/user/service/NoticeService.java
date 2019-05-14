package com.hrm.user.service;

import com.hrm.user.beans.Notice;

import java.util.List;
import java.util.Map;

public interface NoticeService {
    Integer selectCount(Notice notice);

    List<Notice> selectByCondition(Map map);

    void removeNotice(int[] ids);

    Notice selectNoticeById(Integer id);

    Notice updateSelect(Integer id);

    void updateNotice(Notice notice);

    void addNotice(Notice notice);
}
