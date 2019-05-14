package com.aynu.rjxy.common.beans;

import java.io.Serializable;
import java.util.Set;

public class NewsLabel implements Serializable{

	private Integer id;
	private String label_name;
	private String label_content;
	
	//关联属性 把当前类看成一方(父栏目),则该关联属性为多方(子栏目)
	private Set<NewsLabel> child;
	//关联属性 把当前类看成多方(子栏目),则该关联属性为一方(父栏目)
	private NewsLabel parent;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLabel_name() {
		return label_name;
	}
	public void setLabel_name(String label_name) {
		this.label_name = label_name;
	}
	public String getLabel_content() {
		return label_content;
	}
	public void setLabel_content(String label_content) {
		this.label_content = label_content;
	}
	public Set<NewsLabel> getChild() {
		return child;
	}
	public void setChild(Set<NewsLabel> child) {
		this.child = child;
	}
	public NewsLabel getParent() {
		return parent;
	}
	public void setParent(NewsLabel parent) {
		this.parent = parent;
	}
	@Override
	public String toString() {
		return "NewsLabel [id=" + id + ", label_name=" + label_name + ", label_content=" + label_content + ", child="
				+ child + ", parent=" + parent + "]";
	}
}
