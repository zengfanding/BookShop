package zfd.service;

import zfd.bean.AdminUser;
import zfd.dao.AdminUserDao;

public class AdminUserServiceImpl implements AdminUserService{
	
	private AdminUserDao adminUserDao;
	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	@Override
	public AdminUser findWithLogin(String username, String password) {
		return adminUserDao.findWithLogin(username, password);
	}

	@Override
	public void saveOrUpdateAdminUser(AdminUser user) {
		
		adminUserDao.saveOrUpdateAdminUser(user);
		
	}

}
