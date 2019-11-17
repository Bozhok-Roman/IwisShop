package com.iwis.dao.repo;

import com.iwis.dao.entity.Goods;
import com.iwis.dao.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GoodsRepo extends JpaRepository<Goods,Long> {
//    @Query("SELECT Goods from Goods LEFT OUTER JOIN shop_goods ON Goods.Id=shop_goods.goods_id and shop_goods.shop_id = :id")
    List<Goods> findAllByShopsContains(@Param("id") Long id);


}
