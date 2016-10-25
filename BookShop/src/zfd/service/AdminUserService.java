package zfd.service;

import zfd.bean.AdminUser;

public interface AdminUserService {
	public AdminUser findWithLogin(String username,String password);
	
	public void saveOrUpdateAdminUser(AdminUser user) ;
}
