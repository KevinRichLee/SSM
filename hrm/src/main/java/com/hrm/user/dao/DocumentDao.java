package com.hrm.user.dao;

import com.hrm.user.beans.Document;

import java.util.List;
import java.util.Map;

public interface DocumentDao {
    Integer selectCount(Document document);

    List<Document> selectByCondition(Map map);

    int addDocument(Document document);

    void deleteDocument(int[] ids);

    String selectByFileName(int i);

    Document selectDocument(Integer id);

    int updateDocument(Document document);
}
