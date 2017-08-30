package cn.xiaohu.customer.utils;

import java.util.List;

public class PageBean<T> {
	private int currentPage=1;//��ǰҳ��Ĭ����ʾ��һҳ
	private int pageCount=10;//ÿҳ��ʾ����������ѯ���ص���������Ĭ��ÿҳ��ʾ10��
	private int totalCount=1;//�ܼ�¼��
	private int totalPage=1;//��ҳ��=���ܼ�¼��-1��/ÿҳ��ʾ������+1
	private List<T> pageData;//��ҳ��ѯ��������
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		totalPage=(totalPage-1)/pageCount+1;
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getPageData() {
		return pageData;
	}
	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}

}
