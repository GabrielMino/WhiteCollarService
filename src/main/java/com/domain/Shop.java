package com.domain;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "shop")
public class Shop {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name="capacity",nullable=false)
	private int capacity;
	
	@Column(name="name",nullable=false, length=30)
    private String name;
	

    @OneToMany(mappedBy = "shop")
    private List<Picture> pictures = new ArrayList<Picture>();
    
    
    public Shop() {}
    
    public Shop(String name, Integer capacity) {
		this.name = name;
		this.capacity = capacity;
	}
    

	public Shop(int id, int capacity, String name) {
		this.id = id;
		this.capacity = capacity;
		this.name = name;
	}

	//
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
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(Picture picture) {
		pictures.add(picture);
	}



}
