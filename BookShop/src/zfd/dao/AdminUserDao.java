package zfd.dao;

import zfd.bean.AdminUser;

public interface AdminUserDao {
	
	public AdminUser findWithLogin(String username,String password);
	
	public void saveOrUpdateAdminUser(AdminUser user);

}
