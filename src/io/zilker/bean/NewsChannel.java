package io.zilker.bean;

public class NewsChannel implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private String channelName,newsTitle,newsLink;

	public NewsChannel() {
		super();
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsLink() {
		return newsLink;
	}

	public void setNewsLink(String newsLink) {
		this.newsLink = newsLink;
	}
	
	

}
