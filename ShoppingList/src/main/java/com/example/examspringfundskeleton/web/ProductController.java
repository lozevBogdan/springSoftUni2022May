package com.example.examspringfundskeleton.web;

import com.example.examspringfundskeleton.currUser.CurrentUser;
import com.example.examspringfundskeleton.dtos.ProductAddDto;
import com.example.examspringfundskeleton.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final CurrentUser currentUser;

    public ProductController(ProductService productService, CurrentUser currentUser) {
        this.productService = productService;

        this.currentUser = currentUser;
    }

    @ModelAttribute
    public ProductAddDto productAddDto(){
        return new ProductAddDto();
    }

    @GetMapping("/add")
    public String add(){

        if(!currentUser.isLogged()){
            return "redirect:/users/login";
        }

        return "product-add";
    }


    @PostMapping("/add")
    public String add(@Valid ProductAddDto productAddDto ,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        if(!currentUser.isLogged()){
            return "redirect:/users/login";
        }



        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productAddDto", productAddDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.productAddDto",
                    bindingResult);

            return "redirect:add";
        }

        this.productService.addInDb(productAddDto);

        return "redirect:/";
    }

    @GetMapping("/buy/{id}")
        public String buyProduct(@PathVariable Long id){

        if(!currentUser.isLogged()){
            return "redirect:/users/login";
        }

            this.productService.buyProductWithId(id);

            return "redirect:/";

        }

    @GetMapping("/buy/all")
    public String buyProduct(){

        if(!currentUser.isLogged()){
            return "redirect:/users/login";
        }

        this.productService.buyAllProducts();

        return "redirect:/";

    }





}
