package com.iwis.dao.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min=8)
    private String shopName;
    @Size(min=20)
    private String address;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "ShopGoods",
            joinColumns = { @JoinColumn(name = "shop_id") },
            inverseJoinColumns = { @JoinColumn(name = "goods_id") }
    )
    private Set<Goods> goods;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Goods> getGoods() {
        return goods;
    }

    public void setGoods(Set<Goods> goods) {
        this.goods = goods;
    }
}
