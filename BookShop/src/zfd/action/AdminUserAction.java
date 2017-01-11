package zfd.action;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.mysql.fabric.xmlrpc.base.Array;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import zfd.bean.AdminUser;
import zfd.bean.BookInfo;
import zfd.bean.BookJinhuo;
import zfd.bean.BookXiaoshou;
import zfd.service.AdminUserService;
import zfd.service.BookService;
import zfd.utils.DateFormatUtil;
import zfd.utils.ExportExcelUtils;

public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser>{
	
	

	private AdminUser adminUser = new AdminUser();
	
	@Override
	public AdminUser getModel() {
		return adminUser;
	}
	
	private InputStream target;
	
	public InputStream getTarget() {
		return target;
	}
	
	private String filename;
	public String getFilename() {
		return filename;
	}
	private String quan;
	public void setQuan(String quan) {
		this.quan = quan;
	}
	
	private AdminUserService adminUserService;
	
	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
	
	private BookService bookService;
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	private String excel;
	
	
	
	public String getExcel() {
		return excel;
	}

	public void setExcel(String excel) {
		this.excel = excel;
	}

	public String login(){
		
		String username = adminUser.getUsername();
		String password = adminUser.getPassword();
		AdminUser adminUser = adminUserService.findWithLogin(username, password);
		if(adminUser == null){
			ActionContext.getContext().getValueStack().set("adminloginerror", "用户名密码不匹配!");
			return "loginerror";
		}
		adminUser.setLastLoginDate(new Date());
		adminUserService.saveOrUpdateAdminUser(adminUser);
		
		ActionContext.getContext().getSession().put("loginAdminUser", adminUser);
		return "login";
	}
	
	public String relogin(){
		
		ServletActionContext.getRequest().getSession().invalidate();
		return "relogin";
		
	}
	
	public String add(){
		
		Map<String,Integer> quanxians = new HashMap<String , Integer>();
		quanxians.put("书籍管理",1);
		quanxians.put("库存管理",2);
		quanxians.put("进书管理",4);
		quanxians.put("销售管理",8);
		int trueQuanxian = 0;
		String[] strs = quan.split(",");
		for(int i = 0 ; i < strs.length ; i++){
			
			for (Map.Entry<String, Integer> e : quanxians.entrySet()) {
				if(strs[i].trim().equals(e.getKey())){
					trueQuanxian+=e.getValue();
					quanxians.remove(e.getKey());
					break;
				}
			}
		}
		
		adminUser.setQuanxian(trueQuanxian);
		adminUserService.saveOrUpdateAdminUser(adminUser);
		return "add";
	}
	
	
	public String toExportPage(){
		
		AdminUser adminUser = (AdminUser) ActionContext.getContext().getSession().get("loginAdminUser");
		int quanxian = adminUser.getQuanxian();
		
		List<String> list = new ArrayList<String>();
		
		if((quanxian & 1) == 1 || (quanxian & 2) == 2){
			list.add("书籍信息");
			list.add("库存信息");
		}
		
		if((quanxian & 4) == 4){
			list.add("进书信息");
		}
		if((quanxian & 8) == 8){
			list.add("销售信息");
		}
		if((quanxian & 16) == 16){
			list.add("统计销售信息");
		}
		
		ActionContext.getContext().getValueStack().set("excelList", list);
		
		
		
		
		return "toExportPage";
	}
	
	public String exportExcel() throws IOException{
		
		String[] split = excel.split(",");
		
		List<BookInfo> bookList = null;
		
		if(split != null && split.length > 0 && split[0].trim().length() > 0){
			bookList = bookService.findAll();
		}
		HSSFWorkbook workbook = new HSSFWorkbook();
		for (String string : split) {
			
			string = string.trim();
			if("书籍信息".equals(string)){
				
				ExportExcelUtils.exportExcelBook(bookList,workbook);
				
				
			}
			if("库存信息".equals(string)){
				ExportExcelUtils.exportExcelKucun(bookList,workbook);
			}
			if("进书信息".equals(string)){
				
				ExportExcelUtils.exportExcelJinshu(bookList,workbook);
				
				
			}
			if("销售信息".equals(string)){
				
				ExportExcelUtils.exportExcelXiaoshou(bookList,workbook);
				
			}
			if("统计销售信息".equals(string)){
				ExportExcelUtils.exportExcelTongji(bookList,workbook);
			}
		}
		
		String path = 	ServletActionContext.getServletContext().getRealPath("/downloads");
		this.filename = System.nanoTime()+".xls";
		FileOutputStream fileOutputStream = new FileOutputStream(path+"/"+filename);
		workbook.write(fileOutputStream);
		 
		fileOutputStream.close();
		this.target = ServletActionContext.getServletContext().getResourceAsStream("/downloads/"+filename);
		return "exportExcel";
	}
	
	


	

}
