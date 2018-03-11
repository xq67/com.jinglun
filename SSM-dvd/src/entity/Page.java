package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page implements Serializable{
	private int currnetPage=1;  //当前页
	private int countPage;	    //总页数
	private int pageSize=8;		//默认条数
	private int countData;      //数据总条数
	private List<DvdInfo>list=new ArrayList<DvdInfo>();   //页面数据
	private String serachName;    //模糊查询的名字
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
