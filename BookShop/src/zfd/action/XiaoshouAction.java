package zfd.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import zfd.bean.BookJinhuo;
import zfd.bean.BookXiaoshou;
import zfd.service.XiaoshouService;

import java.util.List;

public class XiaoshouAction extends ActionSupport implements ModelDriven<BookXiaoshou>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1742639669157169990L;

	BookXiaoshou bookXiaoshou = new BookXiaoshou();
	
	private int pageId;
	private int totalPages;
	private String type;
	private int nowPage;
	
	public int getNowPage() {
		return nowPage;
	}
	
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public int getPageId() {
		return pageId;
	}
	
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	@Override
	public BookXiaoshou getModel() {
		return bookXiaoshou;
	}
	
	private XiaoshouService xiaoshouService;
	
	public void setXiaoshouService(XiaoshouService xiaoshouService) {
		this.xiaoshouService = xiaoshouService;
	}
	public XiaoshouService getXiaoshouService() {
		return xiaoshouService;
	}
	
	public String findAll(){
		List<BookXiaoshou> list = xiaoshouService.findAll();
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

		ActionContext.getContext().put("allList", list);
		ActionContext.getContext().getValueStack().set("nowPage", 1);
		ActionContext.getContext().getValueStack().set("totalPages", totalPages);
		
		
		return "findAll";
		
	}
	
	public String find(){
		
		System.out.println(bookXiaoshou.getXiaoshouMa());
		System.out.println(bookXiaoshou.getBookInfo().getTiaoma());
		System.out.println(type);
		System.out.println("-------------------------------------------------");
		if("byButton".equals(type)){
			List<BookXiaoshou> list = xiaoshouService.find(bookXiaoshou);
			
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
	
			ActionContext.getContext().put("allList", list);
			ActionContext.getContext().getValueStack().set("nowPage", 1);
			ActionContext.getContext().getValueStack().set("totalPages", totalPages);	
			
		}else{
			System.out.println(pageId);
			List<BookXiaoshou> list  =  xiaoshouService.find(bookXiaoshou,pageId,5);
			ActionContext.getContext().put("allList", list);
			ActionContext.getContext().getValueStack().set("nowPage", pageId);
			ActionContext.getContext().getValueStack().set("totalPages", totalPages);	
			
		}
		
		
		
		return "find";
	}

}
