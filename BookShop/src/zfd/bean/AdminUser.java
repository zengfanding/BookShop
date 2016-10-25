package zfd.bean;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AdminUser entity. @author MyEclipse Persistence Tools
 */

public class AdminUser implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4786720510365282462L;
	private String id;
	private String username;
	private String password;
	private String truename;
	private Integer quanxian;
	private Date lastLoginDate;

	// Constructors

	/** default constructor */
	public AdminUser() {
	}

	/** minimal constructor */
	public AdminUser(String username, String password, String truename, Integer quanxian) {
		this.username = username;
		this.password = password;
		this.truename = truename;
		this.quanxian = quanxian;
	}

	/** full constructor */
	public AdminUser(String username, String password, String truename, Integer quanxian, Timestamp lastLoginDate) {
		this.username = username;
		this.password = password;
		this.truename = truename;
		this.quanxian = quanxian;
		this.lastLoginDate = lastLoginDate;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTruename() {
		return this.truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public Integer getQuanxian() {
		return this.quanxian;
	}

	public void setQuanxian(Integer quanxian) {
		this.quanxian = quanxian;
	}

	public Date getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	@Override
	public String toString() {
		return "AdminUser [id=" + id + ", username=" + username + ", password=" + password + ", truename=" + truename
				+ ", quanxian=" + quanxian + ", lastLoginDate=" + lastLoginDate + "]";
	}
	
	

}