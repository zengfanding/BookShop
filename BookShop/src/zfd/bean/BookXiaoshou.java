package zfd.bean;

import java.util.Date;

/**
 * BookXiaoshou entity. @author MyEclipse Persistence Tools
 */

public class BookXiaoshou implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6087480854923405862L;
	private String xiaoshouId;
	private BookInfo bookInfo;
	private String xiaoshouMa;
	private Integer xiaoshouNum;
	private Date xiaoshouDate;

	// Constructors

	/** default constructor */
	public BookXiaoshou() {
	}

	/** full constructor */
	public BookXiaoshou(BookInfo bookInfo, String xiaoshouMa,
			Integer xiaoshouNum, Date xiaoshouDate) {
		this.bookInfo = bookInfo;
		this.xiaoshouMa = xiaoshouMa;
		this.xiaoshouNum = xiaoshouNum;
		this.xiaoshouDate = xiaoshouDate;
	}

	// Property accessors

	public String getXiaoshouId() {
		return this.xiaoshouId;
	}

	public void setXiaoshouId(String xiaoshouId) {
		this.xiaoshouId = xiaoshouId;
	}

	public BookInfo getBookInfo() {
		return this.bookInfo;
	}

	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}

	public String getXiaoshouMa() {
		return this.xiaoshouMa;
	}

	public void setXiaoshouMa(String xiaoshouMa) {
		this.xiaoshouMa = xiaoshouMa;
	}

	public Integer getXiaoshouNum() {
		return this.xiaoshouNum;
	}

	public void setXiaoshouNum(Integer xiaoshouNum) {
		this.xiaoshouNum = xiaoshouNum;
	}

	public Date getXiaoshouDate() {
		return this.xiaoshouDate;
	}

	public void setXiaoshouDate(Date xiaoshouDate) {
		this.xiaoshouDate = xiaoshouDate;
	}

	@Override
	public String toString() {
		return "BookXiaoshou [xiaoshouId=" + xiaoshouId + ", bookInfo=" + bookInfo + ", xiaoshouMa=" + xiaoshouMa
				+ ", xiaoshouNum=" + xiaoshouNum + ", xiaoshouDate=" + xiaoshouDate + "]";
	}

	
	
}