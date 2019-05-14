package com.aynu.rjxy.oa.INewsLabelService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aynu.rjxy.common.beans.NewsLabel;
import com.aynu.rjxy.oa.dao.INewsLabelDao;
import com.aynu.rjxy.oa.vo.Page;

public class INewsLabelServiceImpl implements INewsLabelService {

	INewsLabelDao dao;
	
	public void setDao(INewsLabelDao dao) {
		this.dao = dao;
	}

	public List<NewsLabel> findAllParents() {
		// TODO Auto-generated method stub
		return dao.selectAllParents();
	}

	public Page<NewsLabel> findCurrentPage(int pagenum,int id) {
		Page<NewsLabel> page = new Page<NewsLabel>();
		//初始化当前页
		page.setPagenum(pagenum);
		//初始化totalRows
		int totalRows = dao.selectAllCount(id);
		page.setTotalRows(totalRows);
		//初始化当前页所包含的栏目具体信息datas
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("pageStartIndex",page.getPageStartIndex() );
		map.put("pageSize", page.getPageSize());
		map.put("id", id);
		List<NewsLabel> datas = dao.selectCurPageNewsLabel(map);
		page.setDatas(datas);
		return page;
	}

	public int removeNewsLabelById(Integer id) {
		 return dao.deleteNewsLabelById(id);
	}

	public void modifyNewsLabel(NewsLabel newsLabel) {
		dao.updateNewsLabel(newsLabel);
	}

	public NewsLabel findNewsLabelById(Integer id) {
		return dao.selectNewsLabelById(id);
	}

	public void addNewsLabel(NewsLabel newsLabel) {
		dao.insertNewsLabel(newsLabel);
	}

	

	public List<NewsLabel> findCurrentPage(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return dao.selectCurPageNewsLabel(map);
	}

	
}
