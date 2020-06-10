package bean;

public class BookInfo {
	String bookid;
	String bookname;
	String author;
	String company;
	String lore;
	public String getBookid() {
		return bookid;
	}
	public BookInfo(String lore, String bookid) {
		super();
		this.bookid = bookid;
		this.lore = lore;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getLore() {
		return lore;
	}
	public void setLore(String lore) {
		this.lore = lore;
	}
	public BookInfo(String bookid, String bookname, String author, String company, String lore) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.author = author;
		this.company = company;
		this.lore = lore;
	}
}