package zfd.dao;

import java.util.List;

import zfd.bean.BookInfo;
import zfd.bean.BookJinhuo;

public interface JinshuDao {
	
	public List<BookJinhuo> findAll();
	
	public List<BookJinhuo> find(BookJinhuo bookJinhuo);
	
	public List<BookJinhuo> find(BookJinhuo bookJinhuo , int start ,int ronglinag);
	
	public BookInfo findBookInfoByTiaoMa(BookInfo bookInfo);
	
	public void saveOrUpdateBookJinhuo(BookJinhuo bookJinhuo);

	public List<BookJinhuo> findByBookIdWithAscOrder(BookInfo book);

}
