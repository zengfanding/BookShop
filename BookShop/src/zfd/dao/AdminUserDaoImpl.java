package zfd.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import zfd.bean.AdminUser;

public class AdminUserDaoImpl extends HibernateDaoSupport implements AdminUserDao {

	@Override
	public AdminUser findWithLogin(String username, String password) {
		List<AdminUser> list = this.getHibernateTemplate().find("from AdminUser where username=? and password = ?", username,password);;
		
		if(list == null || list.size() == 0){
			return null;
		}else{
			return list.get(0);
		}
	}

	@Override
	public void saveOrUpdateAdminUser(AdminUser user) {
		
		this.getHibernateTemplate().saveOrUpdate(user);
		
	}

}
