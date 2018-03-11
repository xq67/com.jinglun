package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.DvdInfo;

public interface DvdDao {
	//��������������
	public int calCountdate(@Param("name")String name);
	//��ȡ��ǰҳ�������
	public List<DvdInfo> calDate(@Param("name")String name,
			@Param("currentPage")int currentPage,
			@Param("pageSize")int pageSize);
	//���DVD
	public int addDvd(@Param("name")String name);
	//ɾ��DVD
	public int delDvd(@Param("id")int id);
	//�޸�DVD
	public int updateDvd(@Param("id")int id,@Param("name")String name);
	//���DVD
	public int lendDvd(@Param("id")int id);
	//�黹DVD
	public int returnDvd(@Param("id")int id);
}
