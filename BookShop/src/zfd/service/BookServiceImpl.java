package zfd.service;

import java.util.List;

import zfd.bean.BookInfo;
import zfd.bean.BookJinhuo;
import zfd.bean.BookXiaoshou;
import zfd.dao.BookDao;

public class BookServiceImpl implements BookService{

	private BookDao bookDao;
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
		
		
		
	}
	
	
	
	@Override
	public void saveOrUpdateBook(BookInfo bookInfo) {

		bookDao.saveOrUpdateBook(bookInfo);
		
	}



	@Override
	public BookInfo findByTiaoma(String tiaoma) {
		return bookDao.findByTiaoma(tiaoma);
	}



	@Override
	public List<BookInfo> findAll() {
		 
		
		return bookDao.findAll();
	}



	@Override
	public List<BookInfo> find(BookInfo bookInfo , int start , int rongliang) {
		return bookDao.find(bookInfo,start,rongliang);
	}



	@Override
	public void deleteBookByBookId(BookInfo bookInfo) {
		
		bookDao.deleteBookByBookId(bookInfo);
		
	}



	@Override
	public List<BookInfo> find(BookInfo bookInfo) {
		return bookDao.find(bookInfo);
	}



	@Override
	public void saveOrUpdateJinhuo(BookJinhuo bookJinhuo) {
		bookDao.saveOrUpdateJinhuo(bookJinhuo);
		
	}



	@Override
	public List<BookInfo> findBookWithEmergency(int start , int rongliang) {
		return bookDao.findBookWithEmergency(start,rongliang);
	}



	@Override
	public List<BookInfo> findBookWithEmergency() {
		return bookDao.findBookWithEmergency();
	}



	@Override
	public void saveSale(BookXiaoshou sale) {
		bookDao.saveSale(sale);
		BookInfo b = sale.getBookInfo();
		b.setNum(b.getNum() - sale.getXiaoshouNum());;
		bookDao.saveOrUpdateBook(b);
		
		
	}

}
