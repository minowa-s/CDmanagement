package dto;

public class Cd {
	private String title;
	private String composer;
	private String onsale;
	private int isbn;
	
	public Cd(String title,String composer, String onsale, int isbn) {
	super();
	this.title = title;
	this.composer = composer;
	this.onsale = onsale;
	this.isbn = isbn;
}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public String getOnsale() {
		return onsale;
	}

	public void setOnsale(String onsale) {
		this.onsale = onsale;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
}
	
