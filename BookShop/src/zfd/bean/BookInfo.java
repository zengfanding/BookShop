package zfd.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * BookInfo entity. @author MyEclipse Persistence Tools
 */

public class BookInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5205860039866160184L;
	private String bookid;
	private String tiaoma;
	private String name;
	private Integer num;
	private String author;
	private String publishing;
	private Double price;
	private String img;
	private Set<BookJinhuo> bookJinhuos = new HashSet<BookJinhuo>();
	private Set<BookXiaoshou> bookXiaoshous = new HashSet<BookXiaoshou>();
	
	
	public BookInfo() {
	}


	public BookInfo(String bookid, String tiaoma, String name, Integer num,
			String author, String publishing, Double price, String img,
			Set<BookJinhuo> bookJinhuos, Set<BookXiaoshou> bookXiaoshous) {
		super();
		this.bookid = bookid;
		this.tiaoma = tiaoma;
		this.name = name;
		this.num = num;
		this.author = author;
		this.publishing = publishing;
		this.price = price;
		this.img = img;
		this.bookJinhuos = bookJinhuos;
		this.bookXiaoshous = bookXiaoshous;
	}


	public String getBookid() {
		return bookid;
	}


	public void setBookid(String bookid) {
		this.bookid = bookid;
	}


	public String getTiaoma() {
		return tiaoma;
	}


	public void setTiaoma(String tiaoma) {
		this.tiaoma = tiaoma;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getNum() {
		return num;
	}


	public void setNum(Integer num) {
		this.num = num;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getPublishing() {
		return publishing;
	}


	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public Set<BookJinhuo> getBookJinhuos() {
		return bookJinhuos;
	}


	public void setBookJinhuos(Set<BookJinhuo> bookJinhuos) {
		this.bookJinhuos = bookJinhuos;
	}


	public Set<BookXiaoshou> getBookXiaoshous() {
		return bookXiaoshous;
	}


	public void setBookXiaoshous(Set<BookXiaoshou> bookXiaoshous) {
		this.bookXiaoshous = bookXiaoshous;
	}


	





	
	

}