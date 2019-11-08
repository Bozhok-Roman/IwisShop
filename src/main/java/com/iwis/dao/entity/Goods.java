package com.iwis.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min=5)
    private String goodsName;
    @Size(min=10)
    private String description;

    private Number price;

    @ManyToMany
    private Set<Shop> shops;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }

    public Set<Shop> getShops() {
        return shops;
    }

    public void setShops(Set<Shop> shops) {
        this.shops = shops;
    }
}
