package Biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Biz.DvdBiz;
import dao.DvdDao;
import entity.DvdInfo;
import entity.Page;
@Transactional
@Service("dvdBiz")
public class DvdBizImpl implements DvdBiz {
	static Logger log=Logger.getLogger(DvdBizImpl.class);
	@Resource
	DvdDao dvdDao;

	public Page getPageshow(int currentPage, String name) {
		Page page =new Page();
		// 设置当前页
		
		page.setCurrnetPage(currentPage);
		// 设置数据总条数
		page.setCountData(dvdDao.calCountdate(name));
		// 设置数据的总页码
		int num = (page.getCountData() % page.getPageSize() == 0) ? page.getCountData() / page.getPageSize()
				: page.getCountData() / page.getPageSize() + 1;

		page.setCountPage(num);
		// 设置每页的数据
		int numxx=(page.getCurrnetPage()-1)*page.getPageSize();
		List<DvdInfo> list = dvdDao.calDate(name,numxx, page.getPageSize());
		page.setList(list);
		return page;
	}

	public int addDvd(String name) {
		// TODO Auto-generated method stub
		return dvdDao.addDvd(name);
	}

	public int delDvd(int id) {
		// TODO Auto-generated method stub
		return dvdDao.delDvd(id);
	}

	public int updateDvd(int id, String name) {
		// TODO Auto-generated method stub
		return dvdDao.updateDvd(id, name);
	}

	public int lendDvd(int id) {
		// TODO Auto-generated method stub
		return dvdDao.lendDvd(id);
	}

	public int returnDvd(int id) {
		// TODO Auto-generated method stub
		return dvdDao.returnDvd(id);
	}
}
