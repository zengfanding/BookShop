package zfd.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import zfd.bean.AdminUser;
import zfd.service.AdminUserService;

public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser>{
	
	

	private AdminUser adminUser = new AdminUser();
	@Override
	public AdminUser getModel() {
		return adminUser;
	}
	
	private String quan;
	public void setQuan(String quan) {
		this.quan = quan;
	}
	
	private AdminUserService adminUserService;
	
	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
	
	
	public String login(){
		
		String username = adminUser.getUsername();
		String password = adminUser.getPassword();
		AdminUser adminUser = adminUserService.findWithLogin(username, password);
		//System.out.println(adminUser);
		
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
	

	

}
