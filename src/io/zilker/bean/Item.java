package io.zilker.bean;


public class Item implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	String title, category, imageLink,link,pubDate;
	NewsChannel newsChannel;

	public Item() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public NewsChannel getNewsChannel() {
		return newsChannel;
	}

	public void setNewsChannel(NewsChannel newsChannel) {
		this.newsChannel = newsChannel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	
	
	

	
}
