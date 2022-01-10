package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.*;
import com.domain.*;
import java.util.*;

@Service
public class ShopRepService {
	
	@Autowired
	IShopRepository shopRepository;

	public List<Shop> getShops() {
		
		// TODO Auto-generated method stub
		return shopRepository.findAll();
	}


	public List<String> getShopsList() {
		// TODO Auto-generated method stub
		List<String> result = new ArrayList<>();
		for (Shop e:shopRepository.findAll()) {
			result.add("Name:"+e.getName()+", and capacity "+e.getCapacity());}
		return result;
	}


	public Shop createShop(Shop shop) {
		shopRepository.save(shop);
		return shop;
}
}
