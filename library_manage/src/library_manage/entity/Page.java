package library_manage.entity;

public class Page{
	private int page;     //��ǰҳ��
	private int pageNum;  //ҳ������
	
	public Page(){};
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	@Override
	public String toString() {
		return "Page [page=" + page + ", pageNum=" + pageNum + "]";
	}
	
	
}