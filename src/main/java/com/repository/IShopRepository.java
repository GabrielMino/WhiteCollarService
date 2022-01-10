package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.Shop;

@Repository
public interface IShopRepository extends JpaRepository<Shop,Integer> {

}
