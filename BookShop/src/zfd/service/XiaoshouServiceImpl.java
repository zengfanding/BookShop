package zfd.service;

import java.util.List;

import zfd.bean.BookXiaoshou;
import zfd.dao.XiaoshouDao;
import zfd.dao.XiaoshouDaoImpl;

public class XiaoshouServiceImpl implements XiaoshouService{
	
	private XiaoshouDao xiaoshouDao = new XiaoshouDaoImpl();
	
	
	public void setXiaoshouDao(XiaoshouDao xiaoashouDao) {
		this.xiaoshouDao = xiaoashouDao;
	}

	@Override
	public List<BookXiaoshou> findAll() {
		return xiaoshouDao.findAll();
	}

	@Override
	public List<BookXiaoshou> find(BookXiaoshou xs, int startIndex, int rongliang) {
		return xiaoshouDao.find(xs, startIndex, rongliang);
	}

	@Override
	public List<BookXiaoshou> find(BookXiaoshou xs) {
		return xiaoshouDao.find(xs);
	}

}
