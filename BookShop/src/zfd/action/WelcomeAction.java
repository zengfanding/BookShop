package zfd.action;

import java.security.Provider.Service;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import zfd.bean.BookInfo;
import zfd.bean.BookXiaoshou;
import zfd.service.BookService;
import zfd.service.BookServiceImpl;
import zfd.utils.StringUtils;

public class WelcomeAction extends ActionSupport implements ModelDriven<BookInfo>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7087593000967863769L;
	private BookInfo bookInfo = new BookInfo();
	
	private String buynum;
	
	public void setBuynum(String buynum) {
		this.buynum = buynum;
	}
	public String getBuynum() {
		return buynum;
	}
	
	@Override
	public BookInfo getModel() {
		return bookInfo;
	}
	
	private BookService bookService ;
	
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	public BookService getBookService() {
		return bookService;
	}
	
	public String startShopping() {
		List<BookInfo> list = bookService.findAll();
		
		ActionContext.getContext().put("allBooks", list);
		return "start";
	
	}
	
	public String getDetails(){
		
		
		BookInfo  book = bookService.findByTiaoma(bookInfo.getTiaoma());
		System.out.println(book);
		ActionContext.getContext().put("detailBook", book);
		return "details";
	}
	
	public String buy(){
		
		
		BookXiaoshou sale = new BookXiaoshou(bookInfo, StringUtils.getUnique32BitNum(),Integer.parseInt(buynum) , new Date());
		bookService.saveSale(sale);
		
		return "buy";
	}
	
	
}
