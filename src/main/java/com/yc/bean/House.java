package com.yc.bean;

import java.io.Serializable;
import java.util.Date;

public class House implements Serializable{
	
	private Integer id;
	private User user;
	private HouseType type;
	private Street street;
	private String title;
	private String description;
	private Double price;
	private Date pubdate;
	private Integer floorage;
	private String contact;
	
	
	public House() {
		super();
	}
	public House(Integer id, User user, HouseType type, Street street,
			String title, String description, Double price, Date pubdate,
			Integer floorage, String contact) {
		super();
		this.id = id;
		this.user = user;
		this.type = type;
		this.street = street;
		this.title = title;
		this.description = description;
		this.price = price;
		this.pubdate = pubdate;
		this.floorage = floorage;
		this.contact = contact;
	}
	public House(User user, HouseType type, Street street, String title,
			Double price) {
		super();
		this.user = user;
		this.type = type;
		this.street = street;
		this.title = title;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public HouseType getType() {
		return type;
	}
	public void setType(HouseType type) {
		this.type = type;
	}
	public Street getStreet() {
		return street;
	}
	public void setStreet(Street street) {
		this.street = street;
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
	public Date getPubdate() {
		return pubdate;
	}
	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}
	public Integer getFloorage() {
		return floorage;
	}
	public void setFloorage(Integer floorage) {
		this.floorage = floorage;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "House [id=" + id + ", user=" + user + ", type=" + type
				+ ", street=" + street + ", title=" + title + ", description="
				+ description + ", price=" + price + ", pubdate=" + pubdate
				+ ", floorage=" + floorage + ", contact=" + contact + "]";
	}
	
	
	
}
