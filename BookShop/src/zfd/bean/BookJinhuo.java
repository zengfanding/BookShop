package zfd.bean;

import java.util.Date;

/**
 * BookJinhuo entity. @author zfd
 */

public class BookJinhuo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8955763561851506526L;
	private String jinhuoId;
	private BookInfo bookInfo;
	private String jinshuMa;
	private Double jinPrice;
	private Integer caiGouNum;
	private Date caiGouDate;

	// Constructors

	/** default constructor */
	public BookJinhuo() {
	}

	/** full constructor */
	public BookJinhuo(BookInfo bookInfo, String jinshuMa, Double jinPrice,
			Integer caiGouNum, Date caiGouDate) {
		this.bookInfo = bookInfo;
		this.jinshuMa = jinshuMa;
		this.jinPrice = jinPrice;
		this.caiGouNum = caiGouNum;
		this.caiGouDate = caiGouDate;
	}

	// Property accessors

	public String getJinhuoId() {
		return this.jinhuoId;
	}

	public void setJinhuoId(String jinhuoId) {
		this.jinhuoId = jinhuoId;
	}

	public BookInfo getBookInfo() {
		return this.bookInfo;
	}

	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}

	public String getJinshuMa() {
		return this.jinshuMa;
	}

	public void setJinshuMa(String jinshuMa) {
		this.jinshuMa = jinshuMa;
	}

	public Double getJinPrice() {
		return this.jinPrice;
	}

	public void setJinPrice(Double jinPrice) {
		this.jinPrice = jinPrice;
	}

	public Integer getCaiGouNum() {
		return this.caiGouNum;
	}

	public void setCaiGouNum(Integer caiGouNum) {
		this.caiGouNum = caiGouNum;
	}

	public Date getCaiGouDate() {
		return this.caiGouDate;
	}

	public void setCaiGouDate(Date caiGouDate) {
		this.caiGouDate = caiGouDate;
	}

	@Override
	public String toString() {
		return "BookJinhuo [jinhuoId=" + jinhuoId + ", bookInfo=" + bookInfo
				+ ", jinshuMa=" + jinshuMa + ", jinPrice=" + jinPrice
				+ ", caiGouNum=" + caiGouNum + ", caiGouDate=" + caiGouDate
				+ "]";
	}
	
	

}