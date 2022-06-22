package com.example.coffieshopexmaprep.web;

import com.example.coffieshopexmaprep.dto.OrderDto;
import com.example.coffieshopexmaprep.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    private final OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ModelAttribute
    public OrderDto orderDto(){
        return new OrderDto();
    }

    @GetMapping("/add")
    public String add(){
        return "order-add";
    }

    @PostMapping("/add")
    public String addOrder(@Valid OrderDto orderDto, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("orderDto", orderDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.orderDto", bindingResult);
            System.out.println(orderDto);
            return "redirect:/orders/add";
        }


        this.orderService.addOrder(orderDto);

        return "redirect:/home";
    }

    @GetMapping("/ready/{id}")
    public String ready(@PathVariable Long id){

        this.orderService.deleteOrderWithId(id);

        return "redirect:/home";

    }



}
