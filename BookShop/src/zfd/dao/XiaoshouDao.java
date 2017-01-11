package zfd.dao;

import java.util.List;

import zfd.bean.BookInfo;
import zfd.bean.BookXiaoshou;

public interface XiaoshouDao {
	
	public List<BookXiaoshou> findAll();
	
	public List<BookXiaoshou> find(BookXiaoshou xs,int startIndex,int rongliang);
	
	public List<BookXiaoshou> find(BookXiaoshou xs);

	public List<BookXiaoshou> findByBookIdWithAscOrder(BookInfo book);

}
