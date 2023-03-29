package Logic;

import java.sql.Blob;

public class Photo {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Blob getLogo() {
		return logo;
	}
	public void setFile(Blob logo) {
		this.logo = logo;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getBase64Image() {
		return base64Image;
	}
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
	
	public Photo(int id, String title, String tag, Blob logo, String base64Image) {
		super();
		this.id = id;
		this.title = title;
		this.tag = tag;
		this.logo = logo;
		this.base64Image = base64Image;
	}

	public int id;
	public String title;
	public String tag;
	public Blob logo;
	public String base64Image;

}
