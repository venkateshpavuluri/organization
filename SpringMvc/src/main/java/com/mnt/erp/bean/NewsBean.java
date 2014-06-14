package com.mnt.erp.bean;

public class NewsBean {
    private int newsId;
    private String news;
    private String newsDate;
    private int aid;
    private String xmlLabel;
    private String operations;
    private String basicSearchId;

    public int getNewsId() {
	return newsId;
    }

    public void setNewsId(int newsId) {
	this.newsId = newsId;
    }

    public String getNews() {
	return news;
    }

    public void setNews(String news) {
	this.news = news;
    }

    public String getNewsDate() {
	return newsDate;
    }

    public void setNewsDate(String newsDate) {
	this.newsDate = newsDate;
    }

    public int getAid() {
	return aid;
    }

    public void setAid(int aid) {
	this.aid = aid;
    }

    public String getXmlLabel() {
	return xmlLabel;
    }

    public void setXmlLabel(String xmlLabel) {
	this.xmlLabel = xmlLabel;
    }

    public String getOperations() {
	return operations;
    }

    public void setOperations(String operations) {
	this.operations = operations;
    }

    public String getBasicSearchId() {
	return basicSearchId;
    }

    public void setBasicSearchId(String basicSearchId) {
	this.basicSearchId = basicSearchId;
    }
}