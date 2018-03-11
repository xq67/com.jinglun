package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.DvdInfo;

public interface DvdDao {
	//计算数据总条数
	public int calCountdate(@Param("name")String name);
	//获取当前页面的数据
	public List<DvdInfo> calDate(@Param("name")String name,
			@Param("currentPage")int currentPage,
			@Param("pageSize")int pageSize);
	//添加DVD
	public int addDvd(@Param("name")String name);
	//删除DVD
	public int delDvd(@Param("id")int id);
	//修改DVD
	public int updateDvd(@Param("id")int id,@Param("name")String name);
	//借出DVD
	public int lendDvd(@Param("id")int id);
	//归还DVD
	public int returnDvd(@Param("id")int id);
}
