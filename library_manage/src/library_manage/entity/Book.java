package library_manage.entity;

import net.sf.json.JSONObject;

public class Book{
	
	private int id;
	private String name;
	private String author;
	private String des;
	private String book_path;
	private String img_path;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getBook_path() {
		return book_path;
	}
	public void setBook_path(String book_path) {
		this.book_path = book_path;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", des=" + des + ", book_path=" + book_path
				+ ", img_path=" + img_path + "]";
	}
	
	
}