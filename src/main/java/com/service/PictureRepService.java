package com.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.*;
import com.repository.*;
import com.exceptions.*;

@Service
public class PictureRepService {
	
	@Autowired
	IPictureRepository pictureRepository;
	
	@Autowired
	IShopRepository shopRepository;
	
	

	public Picture createPicture(int id,Picture picture) throws ResourceNotFound, CapacityReached {
		// TODO Auto-generated method stub
		
		Shop shop = shopRepository
				.findById(id)
				.orElseThrow(() -> new ResourceNotFound("There is no shop with this id"));
		
		if(shop.getPictures().size() >= shop.getCapacity()) {
			throw new CapacityReached("The capacity of this shop has been reached");
		} else {
			//shop.getPictures().add(picture);
			picture.setShop(shop);
			shop.setPictures(picture);
			pictureRepository.save(picture);
			
		}
		
	return picture;
	}

	public List<Picture> getPictures() {
		// TODO Auto-generated method stub
		return pictureRepository.findAll();
	}

	public List<Picture> getPicturesByShop(int id) throws ResourceNotFound {
		Shop shop = shopRepository
				.findById(id)
				.orElseThrow(() -> new ResourceNotFound("There is no shop with this id"));
		return shop.getPictures();
	}

	public void deletePicturesByID(int id) throws ResourceNotFound {
		
		Shop shop = shopRepository
				.findById(id)
				.orElseThrow(() -> new ResourceNotFound("There is no shop with this id"));
		
		pictureRepository.deleteAll(shop.getPictures());
		shop.getPictures().clear();
		
		// TODO Auto-generated method stub
		
	}


	
	

}
