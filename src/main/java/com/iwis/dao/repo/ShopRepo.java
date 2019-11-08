package com.iwis.dao.repo;

import com.iwis.dao.entity.Goods;
import com.iwis.dao.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ShopRepo extends JpaRepository<Shop,Long> {
    Shop findAllById(Long id);
}

