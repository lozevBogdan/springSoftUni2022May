package com.example.coffieshopexmaprep.web;

import com.example.coffieshopexmaprep.currentUser.CurrentUser;
import com.example.coffieshopexmaprep.dto.OrderViewDto;
import com.example.coffieshopexmaprep.entity.UserEntity;
import com.example.coffieshopexmaprep.service.OrderService;
import com.example.coffieshopexmaprep.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final OrderService orderService;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, OrderService orderService, ModelMapper modelMapper, UserService userService) {
        this.currentUser = currentUser;
        this.orderService = orderService;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }



    @GetMapping("/")
    public String indexPage(){

        if (currentUser.getId() == null){
            return "index";
        }
        //todo logic for loged in user
        return "redirect:home";
    }
    @GetMapping("/home")
    public String homePage(Model model){

        if (currentUser.getId() == null){
            return "redirect:/";
        }

        if (!model.containsAttribute("sortedOrderViewsDto")){
            model.addAttribute("sortedOrderViewsDto",new LinkedList<OrderViewDto>());
        }

        if (!model.containsAttribute("sum")){
            model.addAttribute("sum","");
        }

        List<OrderViewDto> sortedOrderViewsDto = this.orderService.
                getAllOrders().
                stream().
                map(o -> modelMapper.map(o, OrderViewDto.class)).sorted((a, b) -> {
                    return b.getPrice().compareTo(a.getPrice());
                }).collect(Collectors.toList());

       int sum = 0;

        for (OrderViewDto o : sortedOrderViewsDto) {
            sum += o.getCategory().getNeededTime();
        }

      List<UserEntity> employees =
              this.userService.getAll();
        employees.sort((a, b)->b.getOrders().size() - a.getOrders().size());

        model.addAttribute("sum",sum);
        model.addAttribute("sortedOrderViewsDto", sortedOrderViewsDto);
        model.addAttribute("employees", employees);


        return "home";
    }


}
