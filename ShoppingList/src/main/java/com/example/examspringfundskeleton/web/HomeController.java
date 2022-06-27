package com.example.examspringfundskeleton.web;

import com.example.examspringfundskeleton.currUser.CurrentUser;
import com.example.examspringfundskeleton.entity.CategoryNameEnum;
import com.example.examspringfundskeleton.entity.ProductEntity;
import com.example.examspringfundskeleton.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ProductService productService;

    public HomeController(CurrentUser currentUser, ProductService productService) {
        this.currentUser = currentUser;
        this.productService = productService;
    }

    @GetMapping("/")
    public String indexPage(){

        if (currentUser.isLogged()){
            return "redirect:/home";
        }

            return "index";
        }

    @GetMapping("/home")
    public String homePage(Model model){

        if (!currentUser.isLogged()){
            return "redirect:/";
        }

        List<ProductEntity> allProducts = this.productService.getAllProducts();

        List<ProductEntity> foods = allProducts.
                stream().
                filter(p->p.getCategory().
                        getName().equals(CategoryNameEnum.Food)).collect(Collectors.toList());


        List<ProductEntity> drinks = allProducts.
                stream().
                filter(p->p.getCategory().
                        getName().equals(CategoryNameEnum.Drink)).collect(Collectors.toList());

        List<ProductEntity> households = allProducts.
                stream().
                filter(p->p.getCategory().
                        getName().equals(CategoryNameEnum.Household)).collect(Collectors.toList());

        List<ProductEntity> other = allProducts.
                stream().
                filter(p->p.getCategory().
                        getName().equals(CategoryNameEnum.Other)).collect(Collectors.toList());

        BigDecimal totalPrice = new BigDecimal(0);

        for (ProductEntity product : allProducts) {
           totalPrice = totalPrice.add(product.getPrice());
        }


        model.addAttribute("foods",foods);
        model.addAttribute("drinks",drinks);
        model.addAttribute("households",households);
        model.addAttribute("other",other);
        model.addAttribute("totalPrice",totalPrice);



        return "home";
    }


}


