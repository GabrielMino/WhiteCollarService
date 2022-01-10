package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.*;

@Repository
public interface IPictureRepository extends JpaRepository<Picture,Integer> {

}
