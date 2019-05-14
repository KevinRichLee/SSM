package com.hrm.user.service;

import com.hrm.user.beans.Document;
import com.hrm.user.dao.DocumentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentDao documentDao;
    @Override
    public Integer selectCount(Document document) {
        return documentDao.selectCount(document);
    }

    @Override
    public List<Document> selectByCondition(Map map) {
        return documentDao.selectByCondition(map);
    }

    @Override
    public int addDocument(Document document) {
        return documentDao.addDocument(document);
    }

    @Override
    public void removeDocument(int[] ids) {
        documentDao.deleteDocument(ids);
    }

    @Override
    public String selectByFileName(int id) {
        return documentDao.selectByFileName(id);
    }

    @Override
    public Document selectDocument(Integer id) {
        return documentDao.selectDocument(id);
    }

    @Override
    public int updateDocument(Document document) {
        return documentDao.updateDocument(document);
    }
}
