package com.hrm.user.service;

import com.hrm.user.beans.Document;

import java.util.List;
import java.util.Map;

public interface DocumentService {
    Integer selectCount(Document document);

    List<Document> selectByCondition(Map map);

    int addDocument(Document document);

    void removeDocument(int[] ids);

    String selectByFileName(int id);

    Document selectDocument(Integer id);

    int updateDocument(Document document);
}
