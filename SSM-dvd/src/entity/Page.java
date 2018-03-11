package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page implements Serializable{
	private int currnetPage=1;  //��ǰҳ
	private int countPage;	    //��ҳ��
	private int pageSize=8;		//Ĭ������
	private int countData;      //����������
	private List<DvdInfo>list=new ArrayList<DvdInfo>();   //ҳ������
	private String serachName;    //ģ����ѯ������
	public String getSerachName() {
		return serachName;
	}
	public void setSerachName(String serachName) {
		this.serachName = serachName;
	}
	public int getCurrnetPage() {
		return currnetPage;
	}
	public void setCurrnetPage(int currnetPage) {
		this.currnetPage = currnetPage;
	}
	public int getCountPage() {
		return countPage;
	}
	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCountData() {
		return countData;
	}
	public void setCountData(int countData) {
		this.countData = countData;
	}
	public List<DvdInfo> getList() {
		return list;
	}
	public void setList(List<DvdInfo> list) {
		this.list = list;
	}
	
	
}
