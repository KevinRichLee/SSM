package com.aynu.rjxy.oa.INewsLabelService;


import java.util.List;
import java.util.Map;

import com.aynu.rjxy.common.beans.NewsLabel;
import com.aynu.rjxy.oa.vo.Page;


public interface INewsLabelService {


	List<NewsLabel> findAllParents();

	

    int removeNewsLabelById(Integer id);

	void modifyNewsLabel(NewsLabel newsLabel);

	NewsLabel findNewsLabelById(Integer id);

	void addNewsLabel(NewsLabel newsLabel);



	Page<NewsLabel> findCurrentPage(int pagenum, int id);

	
}
