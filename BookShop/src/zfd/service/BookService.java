package zfd.service;

import java.util.List;

import zfd.bean.BookInfo;
import zfd.bean.BookJinhuo;
import zfd.bean.BookXiaoshou;

public interface BookService {

	
	public void saveOrUpdateBook(BookInfo bookInfo);
	
	public BookInfo findByTiaoma(String tiaoma);
	
	public List<BookInfo>	findAll();
	
	public List<BookInfo> find(BookInfo bookInfo , int start,int rongliang);
	
	public void deleteBookByBookId(BookInfo bookInfo);
	
	public List<BookInfo> find(BookInfo bookInfo );
	
	public void saveOrUpdateJinhuo(BookJinhuo bookJinhuo);
	
	public List<BookInfo> findBookWithEmergency(int start,int rongliang);
	
	public List<BookInfo> findBookWithEmergency();
	
	public void saveSale(BookXiaoshou sale);
}
