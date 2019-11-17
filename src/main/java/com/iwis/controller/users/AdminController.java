package com.iwis.controller.users;

import com.iwis.dao.entity.Goods;
import com.iwis.dao.entity.Shop;
import com.iwis.dao.repo.GoodsRepo;
import com.iwis.dao.repo.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Controller("/admin")

public class AdminController {
    @Autowired
    private ShopRepo shopRepo;

    @Autowired
    private GoodsRepo goodsRepo;

    @GetMapping("/admin_page")
    public String adminPage(){

        return "admin_page";
    }

    @PostMapping("/add_shop")
    public String addShop(Shop shop){
        shopRepo.save(shop);
        return "redirect:/admin_page";
    }
    @PostMapping("/choose_shop")
    public String chooseShop (Model model, Shop shop){
        List<Goods> allByShopsContains = goodsRepo.findAllByShopsContains(shop.getId());
        if (allByShopsContains.isEmpty()){
            model.addAttribute("message","Shop is empty");
            return "user_page";
        }
        return "redirect:/add_goods?id ="+shop.getId();
    }
    @PostMapping("/add_goods_for_admin")
    public String addGoods(@RequestParam(name = "id") Long id, Goods goods){

        Shop allById = shopRepo.findAllById(id);
        Set<Goods> goodsSet =
                allById.getGoods();
        goodsSet.add(goods);
        shopRepo.save(allById);

        return "redirect:/admin_page";


    }

}
