package Biz;


import entity.Page;

public interface DvdBiz {
	public Page getPageshow(int currentPage,String name);
	
	//添加DVD
	public int addDvd(String name);
	//删除DVD
	public int delDvd(int id);
	//修改DVD
	public int updateDvd(int id,String name);
	//借出DVD
	public int lendDvd(int id);
	//归还DVD
	public int returnDvd(int id);
}
