package zfd.service;

import java.util.List;

import zfd.bean.BookJinhuo;

public interface JinshuService {
	
	public List<BookJinhuo> findAll();
	
	public List<BookJinhuo> find(BookJinhuo bookJinhuo);
	
	public List<BookJinhuo> find(BookJinhuo bookJinhuo , int start ,int ronglinag);

	public void saveOrUpdateBookJinhuo(BookJinhuo bookJinhuo);

}
