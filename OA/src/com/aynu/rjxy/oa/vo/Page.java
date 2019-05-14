package com.aynu.rjxy.oa.vo;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {

	
	private int pagenum;
	private int pageStartIndex;
	private int pageSize;
	private int totalRows;
	private int totalPages;
	private List<T> datas;	
	public Page() {
		this.pagenum=1;
		this.pageSize=3;
		datas = new ArrayList<T>();
	}
	public Page(int pagenum, int pageSize) {
		this();//调用本类的无参构造
		if(pagenum<=0) {
			pagenum=1;
		}
		if(pageSize<=0) {
			pageSize=3;
		}
		this.pagenum = pagenum;
		this.pageSize = pageSize;
	}
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getPageStartIndex() {
		pageStartIndex = (pagenum-1)*pageSize;
		return pageStartIndex;
	}
	public void setPageStartIndex(int pageStartIndex) {
		this.pageStartIndex = pageStartIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getTotalPages() {
		if(totalRows % pageSize==0) {
			totalPages = totalRows/pageSize;			
		}else {
			totalPages = totalRows/pageSize+1;
		}
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	@Override
	public String toString() {
		return "Page [pagenum=" + pagenum + ", pageStartIndex=" + pageStartIndex + ", pageSize=" + pageSize
				+ ", totalRows=" + totalRows + ", totalPages=" + totalPages + ", datas=" + datas + "]";
	}
}
