package Biz;


import entity.Page;

public interface DvdBiz {
	public Page getPageshow(int currentPage,String name);
	
	//���DVD
	public int addDvd(String name);
	//ɾ��DVD
	public int delDvd(int id);
	//�޸�DVD
	public int updateDvd(int id,String name);
	//���DVD
	public int lendDvd(int id);
	//�黹DVD
	public int returnDvd(int id);
}
