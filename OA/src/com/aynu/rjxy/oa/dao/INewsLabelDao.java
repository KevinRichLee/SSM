package com.aynu.rjxy.oa.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.aynu.rjxy.common.beans.NewsLabel;


public interface INewsLabelDao {

	//查询所有一级栏目详情
	List<NewsLabel> selectAllParents();
    //获取所有栏目数量
	int selectAllCount(@Param("id") int id);
    //查询当前页面所包含的栏目详情
	List<NewsLabel> selectCurPageNewsLabel(Map<String, Integer> map);
	int deleteNewsLabelById(Integer id);
	void updateNewsLabel(NewsLabel newsLabel);
	NewsLabel selectNewsLabelById(Integer id);
	void insertNewsLabel(NewsLabel newsLabel);
	List<NewsLabel> selectAllChildren();
	

	
}
