package com.xyd.webtask.entity;

public class Goods {
	
	private long id;
	private String img;
    private String title;
    private String description;
    private Double price;
 
    public Goods(long id, String img, String title, String description, Double price) {
    	this.id = id;
    	this.img = img;
        this.title = title;
        this.description = description;
        this.price = price;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
 
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    } 

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
}