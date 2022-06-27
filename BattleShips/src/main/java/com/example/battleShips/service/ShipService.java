package com.example.battleShips.service;

import com.example.battleShips.currUser.CurrentUser;
import com.example.battleShips.dtos.ShipAddDto;
import com.example.battleShips.dtos.ShipsViewDto;
import com.example.battleShips.entity.CategoryEntity;
import com.example.battleShips.entity.ShipEntity;
import com.example.battleShips.entity.UserEntity;
import com.example.battleShips.repositories.ShipRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipService {

    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;
    private final CurrentUser currentUser;


    public ShipService(ShipRepository shipRepository, ModelMapper modelMapper, UserService userService,
                       CategoryService categoryService, CurrentUser currentUser) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
        this.currentUser = currentUser;
    }

    public boolean checkForExistingName(String name) {
        return this.shipRepository.findByName(name).isPresent();
    }

    public ShipEntity addToDb(ShipAddDto shipAddDto) {

        ShipEntity newShip = this.modelMapper.map(shipAddDto,ShipEntity.class);
        UserEntity currentUserEntity = this.userService.findByIdCurrentUser();

        newShip.setUser(currentUserEntity);

        CategoryEntity categoryByCategoryEnum =
                this.categoryService.findCategoryByCategoryEnum(shipAddDto.getCategory());

        newShip.setCategory(categoryByCategoryEnum);

        this.shipRepository.save(newShip);


        return  this.shipRepository.save(newShip);
    }

    public List<ShipsViewDto> getAllShips() {
       return this.shipRepository.findAll().stream().
               map(s->modelMapper.map(s,ShipsViewDto.class
        )).collect(Collectors.toList());

    }

    public List<ShipsViewDto> getAllShipsOfOtherUsers() {

      return this.shipRepository.findAll().
                stream().filter(s->s.getUser().
                        getId() != currentUser.getId()).
              map(s->modelMapper.
                      map(s,ShipsViewDto.class)).
              collect(Collectors.toList());
    }

    public List<ShipsViewDto> getAllShipsOfCurrentUser() {
        return this.shipRepository.findAll().
                stream().filter(s->s.getUser().
                        getId() == currentUser.getId()).
                map(s->modelMapper.
                        map(s,ShipsViewDto.class)).
                collect(Collectors.toList());
    }
    }

