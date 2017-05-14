package library_manage.entity;

import net.sf.json.JSONObject;

public class Book{
	
	private int id;
	private String name;
	private String author;
	private String des;
	private String book_path;
	private String img_path;
	private String press;
	private int state;
	private int typeId;
	
	
	public static String updateSql(Book book){
		String sql = null;
		sql="update book set name ="+book.getName()+","
				+ "author = "+book.getAuthor()+","
				+ "des = "+book.getDes()+","
				+ "book_path ="+book.getBook_path()+","
				+ "img_path ="+book.getImg_path()+","
				+ "press ="+book.getPress()+","
				+ "typeId ="+book.getTypeId()+","
				+ "state ="+book.getName()+" where id = "+book.getId()+"";
		return sql;
	}
	
	
	

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

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
	
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", des=" + des + ", book_path=" + book_path
				+ ", img_path=" + img_path + ", press=" + press + ", state=" + state + "]";
	}
	
	
}