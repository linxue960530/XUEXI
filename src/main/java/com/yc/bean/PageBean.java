package com.yc.bean;

import java.io.Serializable;
import java.util.List;

public class PageBean<T> implements Serializable {

	private static final long serialVersionUID = 432734846662739826L;

	private Integer pages;//当前为第几页
	private Integer pagesize;//每页几条
	private Long totalPage;//共有多少页
	private Long total;//总共有多少条
	private List<T> list;//记录集合
    private Integer code;
    
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	/*public Integer getPrePage() {
		return (pages<=1?1:pages-1);
	}
	
	public Integer getNextPage() {
		return (pages<totalPage?pages+1:pages);
	}*/

	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "PageBean [pages=" + pages + ", pagesize=" + pagesize
				+ ", totalPage=" + totalPage + ", total=" + total + ", list="
				+ list + "]";
	}

}
