package zfd.bean;

public class ExcelBean {
	
	private String tiaoma;
	private String name;
	private Integer currentKucun;
	private String author;
	private String publishing;
	private Double price;
	private Double jinPrice;
	private Integer xiaoshouNum;
	private Double benifit;
	public ExcelBean() {
		super();
	}
	public ExcelBean(String tiaoma, String name, Integer currentKucun, String author, String publishing, Double price,
			Double jinPrice, Integer xiaoshouNum) {
		super();
		this.tiaoma = tiaoma;
		this.name = name;
		this.currentKucun = currentKucun;
		this.author = author;
		this.publishing = publishing;
		this.price = price;
		this.jinPrice = jinPrice;
		this.xiaoshouNum = xiaoshouNum;
		this.benifit = (price - jinPrice) * xiaoshouNum;
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
	public Integer getCurrentKucun() {
		return currentKucun;
	}
	public void setCurrentKucun(Integer currentKucun) {
		this.currentKucun = currentKucun;
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
	public Double getJinPrice() {
		return jinPrice;
	}
	public void setJinPrice(Double jinPrice) {
		this.jinPrice = jinPrice;
	}
	public Integer getXiaoshouNum() {
		return xiaoshouNum;
	}
	public void setXiaoshouNum(Integer xiaoshouNum) {
		this.xiaoshouNum = xiaoshouNum;
	}
	public Double getBenifit() {
		return benifit;
	}
	@Override
	public String toString() {
		return "ExcelBean [tiaoma=" + tiaoma + ", name=" + name + ", currentKucun=" + currentKucun + ", author="
				+ author + ", publishing=" + publishing + ", price=" + price + ", jinPrice=" + jinPrice
				+ ", xiaoshouNum=" + xiaoshouNum + ", benifit=" + benifit + "]";
	}
	
	
	
	

}
