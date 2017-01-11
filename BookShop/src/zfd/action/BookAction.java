package zfd.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import zfd.bean.BookInfo;
import zfd.bean.BookJinhuo;
import zfd.service.BookService;
import zfd.utils.StringUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BookAction extends ActionSupport implements ModelDriven<BookInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BookInfo bookInfo = new BookInfo();
	

	@Override
	public BookInfo getModel() {
		
		
		
		return bookInfo;
	}

	// ########################################

	private File image;
	@SuppressWarnings("unused")
	private String imageContentType;
	private String imageFileName;

	public void setImage(File image) {
		this.image = image;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	// #########################################

	private BookService bookService;

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	// #######################################
	private int nowPage;
	private int totalPages;
	private int pageId;
	private String type;
	private String isadd;
	
	public void setIsadd(String isadd) {
		this.isadd = isadd;
	}
	
	public String getIsadd() {
		return isadd;
	}

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

	// #######################################

	private double jinPrice;
	private int caiGouNum;

	public void setJinPrice(double jinPrice) {
		this.jinPrice = jinPrice;
	}

	public double getJinPrice() {
		return jinPrice;
	}

	public void setCaiGouNum(int caiGouNum) {
		this.caiGouNum = caiGouNum;
	}

	public int getCaiGouNum() {
		return caiGouNum;
	}

	// ###########################################

	public String saveOrEditBook() {

		try {

			if (bookInfo.getBookid().equals("") && bookInfo.getImg().equals("")) {
				bookInfo.setBookid(null);
				bookInfo.setImg(null);
			}

			if ((org.apache.commons.lang3.StringUtils.isNotBlank(bookInfo.getBookid())
					&& org.apache.commons.lang3.StringUtils.isNotBlank(imageFileName))
					|| org.apache.commons.lang3.StringUtils.isBlank(bookInfo.getBookid())) {

				String parentDir = ServletActionContext.getServletContext().getRealPath("/bookImgs"); 
				String fileName = StringUtils.getUUID();
				String extendName = imageFileName.substring(imageFileName.lastIndexOf(".")); 
																								
				String trueName = fileName + extendName; 
				File file = new File(parentDir, trueName);
				FileUtils.copyFile(image, file);
				this.bookInfo.setImg(trueName);
			}
			System.out.println(isadd);
			if("add".equals(isadd)){
				bookInfo.setNum(0);
			}
			this.bookService.saveOrUpdateBook(bookInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "saveOrEditBook";
	}

	public String findAll() {

		List<BookInfo> allBookList = bookService.findAll();

		int n = allBookList.size();
		// System.out.println(n);
		int totalPages;
		if (n % 5 == 0) {
			totalPages = n / 5;
		} else {
			totalPages = n / 5 + 1;
		}

		if (n > 5) {
			for (int i = n - 1; i >= 5; i--) {
				allBookList.remove(i);
			}
		}

		ActionContext.getContext().put("allBookList", allBookList);

		ActionContext.getContext().getValueStack().set("totalPages", totalPages);
		ActionContext.getContext().getValueStack().set("nowPage", 1);

		return "findAll";
	}

	public String find() {

		List<BookInfo> list;
		if ("byButton".equals(type)) {
			// System.out.println("byButton");
			list = bookService.find(bookInfo);

			int n = list.size();
			// System.out.println(n);

			int tpages = n % 5 == 0 ? n / 5 : n / 5 + 1;

			if (n > 5) {
				for (int i = n - 1; i >= 5; i--) {
					list.remove(i);
				}
			}

			ActionContext.getContext().put("allBookList", list);
			ActionContext.getContext().getValueStack().set("nowPage", 1);
			ActionContext.getContext().getValueStack().set("totalPages", tpages);
		} else {
			list = bookService.find(bookInfo, pageId, 5);
			ActionContext.getContext().put("allBookList", list);
			// System.out.println(pageId);
			ActionContext.getContext().getValueStack().set("nowPage", pageId);
			ActionContext.getContext().getValueStack().set("totalPages", totalPages);
			// System.out.println("================"+pageId);
			// System.out.println("==========================="+type);

		}

		return "find";

	}

	public String edit() {

		return "edit";
	}

	public String delete() {

		bookService.deleteBookByBookId(bookInfo);

		return "delete";

	}

	public String getAjaxBookinfo() {

		BookInfo bInfo = bookService.findByTiaoma(bookInfo.getTiaoma());

		System.out.println(bInfo);

		ActionContext.getContext().getValueStack().set("ajaxBookInfo", bInfo);

		return "getAjax";
	}

	@SuppressWarnings("unused")
	public String findToKucun() {

		if ("byEmergency".equals(type)) {
			List<BookInfo> list = bookService.findBookWithEmergency(pageId, 5);
			ActionContext.getContext().put("allBookList", list);
			// System.out.println(pageId);
			ActionContext.getContext().getValueStack().set("nowPage", pageId);
			ActionContext.getContext().getValueStack().set("totalPages", totalPages);
			ActionContext.getContext().getValueStack().set("emergency", "1");
		} else {
			String str = this.find();
		}

		return "findtokucun";
	}

	@SuppressWarnings("unused")
	public String findAllToKucun() {

		String str = this.findAll();
		return "findalltokucun";
	}

	public String AddJinshu() {

		return "addjinshu";
	}

	public String saveJinshudan() {
		BookJinhuo jinhuo = new BookJinhuo();
		jinhuo.setBookInfo(bookInfo);
		jinhuo.setCaiGouNum(caiGouNum);
		jinhuo.setJinPrice(jinPrice);
		jinhuo.setJinshuMa(StringUtils.getUnique32BitNum());
		bookService.saveOrUpdateJinhuo(jinhuo);
		return "savejinshudan";
	}

	public String findBookWithEmergency() {

		List<BookInfo> allBookList = bookService.findBookWithEmergency();

		int n = allBookList.size();
		// System.out.println(n);
		int totalPages;
		if (n % 5 == 0) {
			totalPages = n / 5;
		} else {
			totalPages = n / 5 + 1;
		}

		if (n > 5) {
			for (int i = n - 1; i >= 5; i--) {
				allBookList.remove(i);
			}
		}

		ActionContext.getContext().put("allBookList", allBookList);

		ActionContext.getContext().getValueStack().set("totalPages", totalPages);
		ActionContext.getContext().getValueStack().set("nowPage", 1);

		ActionContext.getContext().getValueStack().set("emergency", "1");

		return "findBookWithEmergency";
	}

}
