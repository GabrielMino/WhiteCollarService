package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.domain.Picture;
import com.domain.Shop;
import com.exceptions.CapacityReached;
import com.exceptions.ResourceNotFound;
import com.repository.*;
import com.service.*;




@SpringBootTest(classes=ServiceMockitoTest.class)
public class ServiceMockitoTest {
	
	@Mock
	IShopRepository shopRepository;
	
	@Mock
	IPictureRepository pictureRepository;
	
	@InjectMocks
	ShopRepService shopService;
	
	@InjectMocks
	PictureRepService pictureService;
	
	public List<Shop> shops;
	
	@Test
	@Order(1)
	public void test_getShops() {
		
		List<Shop> shops = new ArrayList<Shop>();
		shops.add(new Shop("Shop1",2));
		shops.add(new Shop("Shop2",5));
		
		when(shopRepository.findAll()).thenReturn(shops);//Mocking
		
		assertEquals(2,shopService.getShops().size());
	}
	
	
	
	@Test
	@Order(2)
	
	public void test_createShop() {
		
		Shop shop = new Shop("Shop1",2);
		
		when(shopRepository.save(shop)).thenReturn(shop);//Mocking
		assertEquals(shop,shopService.createShop(shop));
	}
	
	@Test
	@Order(3)
	public void test_createPicture() throws ResourceNotFound, CapacityReached {
		
	Shop shop = new Shop("Shop1",3);
	int id = 1;
	shop.setId(1);
	Date date = new Date();
	Picture picture = new Picture("Da Vinci", "La Virgen de las rocas",200,date);
	picture.setShop(shop);
	
	when(shopRepository.findById(id)).thenReturn(Optional.of(shop));//Mocking
	when(pictureRepository.save(picture)).thenReturn(picture);//Mocking
	
	assertEquals(picture,pictureService.createPicture(id,picture));
	}
	
	
	@Test
	@Order(4)
	public void test_getPicturesByShop() throws ResourceNotFound {
		

		
		Shop shop = new Shop("Shop1",3);
		int id = 1;
		shop.setId(1);
		Date date = new Date();
		Picture picture = new Picture("Da Vinci", "La Virgen de las rocas",200,date);
		picture.setShop(shop);
		shop.setPictures(picture);
		
		when(shopRepository.findById(id)).thenReturn(Optional.of(shop));//Mocking
		
		assertEquals(shop.getPictures(),pictureService.getPicturesByShop(id));
	}
	
	@Test
	@Order(5)
	public void test_deletePicturesByID() throws ResourceNotFound {
		
		Shop shop = new Shop("Shop1",3);
		int id = 1;
		shop.setId(1);
		Date date = new Date();
		Picture picture1 = new Picture("Da Vinci", "La Virgen de las rocas",200,date);
		Picture picture2 = new Picture("Picasso","Guernica",300,date);
		picture1.setShop(shop);
		picture2.setShop(shop);
		shop.setPictures(picture1);
		shop.setPictures(picture2);
		
		when(shopRepository.findById(id)).thenReturn(Optional.of(shop));//Mocking
		pictureService.deletePicturesByID(1);
		verify(pictureRepository,times(1)).deleteAll(shop.getPictures());
	}
	
	@Test
	@Order(6)
	public void test_getShopsList() {
		
		List<Shop> shops = new ArrayList<Shop>();
		shops.add(new Shop("Shop1",2));
		shops.add(new Shop("Shop2",5));
		
		when(shopRepository.findAll()).thenReturn(shops);//Mocking
		
		assertEquals(2,shopService.getShops().size());
	}
	

}
