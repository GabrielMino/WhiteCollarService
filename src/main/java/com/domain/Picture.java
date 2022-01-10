package com.domain;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "pictures")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","shop"})
public class Picture {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name="author",nullable=true,length=30)
	private String author;
	
	@Column(name="name",nullable=false,length=30)
    private String name;
	
	@Column(name="price",nullable=false,length=10)
	private int price;
	
	@Column(name="date",nullable=false,length=10)
	@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date date;
	
    
    @ManyToOne()
    @JoinColumn(name = "shop_id")
    private Shop shop;
    
    
 
    public Picture() {}
    public Picture(String name, Shop shop) {
		this.name = name;
		this.shop = shop;
	}
    
	public Picture(String author, String name, int price, java.util.Date date) {
		
		this.author = author;
		this.name = name;
		this.price = price;
		this.date = date;
	}
    

	public Picture(String author, String name, int price, java.util.Date date, Shop shop) {
		super();
		this.author = author;
		this.name = name;
		this.price = price;
		this.date = date;
		this.shop = shop;
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

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}


	

}
