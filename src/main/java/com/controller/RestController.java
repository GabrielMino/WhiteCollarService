package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.domain.*;
import com.exceptions.CapacityReached;
import com.exceptions.ResourceNotFound;
import com.service.*;

@Controller
public class RestController {
	
	@Autowired
	PictureRepService pictureService;
	@Autowired
	ShopRepService shopService;
	
	//Crear tienda: le diremos el nombre y la capacidad (POST/shops/).
	@PostMapping("/shops/")
	public ResponseEntity<Shop> createShop(@RequestBody Shop shop) {

		shopService.createShop(shop);
				
		return ResponseEntity.ok(shop);
	}
	
	
	//Lista todas las tiendas con todas sus caracteristicas
	@GetMapping("/")
	public ResponseEntity<List<Shop>> getShops() {
		return ResponseEntity.ok(shopService.getShops());
	}
	
	
	//Listar tiendas: devuelve la lista de tiendas con su nombre y capacidad (GET /shops/).
	@GetMapping("/shops/")
	public ResponseEntity<List> getShopsList(){

		return ResponseEntity.ok(shopService.getShopsList());}
		
	//Añadir cuadro: le daremos el nombre del cuadro, el del autor, el precio y la tienda (POST /shops/{ID}/pictures)
	@PostMapping("/shops/{ID}/pictures/")
	public ResponseEntity<Picture> createPicture(@PathVariable(name="ID") int id,@RequestBody Picture picture) throws ResourceNotFound, CapacityReached{
		
	return ResponseEntity.ok(pictureService.createPicture(id,picture));}
		
	
	@GetMapping("/shops/pictures/")

    public ResponseEntity<List<Picture>> getPictures() {
        return ResponseEntity.ok(pictureService.getPictures());
    }

	//Listar los cuadros de la tienda (GET /shops/{ID}/pictures).
	
	@GetMapping("/shops/{ID}/pictures/")

    public ResponseEntity<List<Picture>> getPicturesByShop(@PathVariable(name="ID") int id) throws ResourceNotFound {
        return ResponseEntity.ok(pictureService.getPicturesByShop(id));
    }
		
	//Incendiar cuadros: por si viene la policía, se pueden eliminar todos los cuadros de la tienda sin dejar rastro (DELETE /shops/{ID}/pictures).
		
	@DeleteMapping("/shops/{ID}/pictures")
	
	public ResponseEntity<Picture> deletePicturesById(@PathVariable(name="ID") int id) throws ResourceNotFound{
		
		pictureService.deletePicturesByID(id);
		
		return null;	
		
	}
}
	


