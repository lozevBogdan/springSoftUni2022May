package com.example.coffieshopexmaprep.service;

import com.example.coffieshopexmaprep.currentUser.CurrentUser;
import com.example.coffieshopexmaprep.dto.OrderDto;
import com.example.coffieshopexmaprep.entity.OrderEntity;
import com.example.coffieshopexmaprep.entity.UserEntity;
import com.example.coffieshopexmaprep.repositories.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    private final ModelMapper modelMapper;

    public OrderService(OrderRepository orderRepository, CurrentUser currentUser, UserService userService, CategoryService categoryService, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    public void addOrder(OrderDto orderDto) {

        OrderEntity newOrder = this.modelMapper.map(orderDto,OrderEntity.class);

        UserEntity currentUserById = this.userService.findCurrentUserById(currentUser.getId());

        newOrder.setEmployee(currentUserById);
        newOrder.setCategory(this.categoryService.getByCategoryEnum(orderDto.getCategory()));

        this.orderRepository.save(newOrder);


    }

    public List<OrderEntity> getAllOrders() {
        return this.orderRepository.findAll();
    }

    public void deleteOrderWithId(Long id) {
        this.orderRepository.deleteById(id);
    }
}
