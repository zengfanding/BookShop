package zfd.service;

import zfd.bean.AdminUser;

public interface AdminUserService {
	
	/**
	 * 根据用户名和密码查找用户
	 * @param username 用户名
	 * @param password 密码
	 * @return 查找到的用户，未找到返回null
	 */
	public AdminUser findWithLogin(String username,String password);
	
	/**
	 * 保存或更新用户
	 * @param user 要保存或更新的用户，有id值更新，无id值保存
	 */
	public void saveOrUpdateAdminUser(AdminUser user) ;
}
