package zfd.service;

import java.util.List;

import zfd.bean.BookXiaoshou;

public interface XiaoshouService {
	
	public List<BookXiaoshou> findAll();
	
	public List<BookXiaoshou> find(BookXiaoshou xs,int startIndex,int rongliang);
	
	public List<BookXiaoshou> find(BookXiaoshou xs);

}
