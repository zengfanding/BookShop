package zfd.action;

import java.util.Date;
import java.util.List;


import zfd.bean.BookJinhuo;
import zfd.service.JinshuService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class JinshuActin extends ActionSupport implements ModelDriven<BookJinhuo>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4426815624593943029L;
	private BookJinhuo bookJinhuo = new BookJinhuo();

	@Override
	public BookJinhuo getModel() {
		return bookJinhuo;
	}
//#################################################
	
	private JinshuService jinshuService;
	public void setJinshuService(JinshuService jinshuService) {
		this.jinshuService = jinshuService;
	}
//###############################################
	
	
	
	private int nowPage;
	private int totalPages;
	private int pageId;
	private String type;
	
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
	public int getPageId() {
		return pageId;
	}
	
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
//###################################################

	
	public String findAll(){
		
		List<BookJinhuo> list = jinshuService.findAll();
		
		int n = list.size();
		//System.out.println(n);
		int totalPages;
		if(n % 5 == 0){
			totalPages = n / 5;
		}else{
			totalPages = n / 5 + 1 ;
		}
		
		
		
		if(n > 5){
			for(int i = n-1 ; i >= 5;i--){
				list.remove(i);
			}
		}
		
		ActionContext.getContext().put("allJinshuList", list);
		ActionContext.getContext().getValueStack().set("nowPage", 1);
		ActionContext.getContext().getValueStack().set("totalPages", totalPages);
		return "find";
	}
	
	public String find(){
		
		if("byButton".equals(type)){
			
			List<BookJinhuo> list  =  jinshuService.find(bookJinhuo);
			
			int n = list.size();
			int totalPages;
			if(n % 5 == 0){
				totalPages = n / 5;
			}else{
				totalPages = n / 5 + 1 ;
			}
			if(n > 5){
				for(int i = n-1 ; i >= 5;i--){
					list.remove(i);
				}
			}
	
			ActionContext.getContext().put("allJinshuList", list);
			ActionContext.getContext().getValueStack().set("nowPage", 1);
			ActionContext.getContext().getValueStack().set("totalPages", totalPages);	
		}else{
			
			System.out.println(pageId);
			List<BookJinhuo> list  =  jinshuService.find(bookJinhuo,pageId,5);
			ActionContext.getContext().put("allJinshuList", list);
			ActionContext.getContext().getValueStack().set("nowPage", pageId);
			ActionContext.getContext().getValueStack().set("totalPages", totalPages);	
			
		}
		
		
		return "findpart";
	}
	
	
	public String handle(){
		//System.out.println(bookJinhuo);
		
		
		return "handle";
	}
	
	public String saveJinshu(){
		
		//System.out.println(bookJinhuo);
		
		bookJinhuo.setCaiGouDate(new Date());
		
		bookJinhuo.getBookInfo().setNum(bookJinhuo.getCaiGouNum()+bookJinhuo.getBookInfo().getNum());
		System.out.println(bookJinhuo);
		
		jinshuService.saveOrUpdateBookJinhuo(bookJinhuo);
		
		
		return "savejinshu";
		
	}
	
	
}

