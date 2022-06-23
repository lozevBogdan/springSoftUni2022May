package com.example.battleShips.service;

import com.example.battleShips.currUser.CurrentUser;
import com.example.battleShips.dtos.UserLoginDto;
import com.example.battleShips.dtos.UserRegisterDto;
import com.example.battleShips.entity.UserEntity;
import com.example.battleShips.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    public UserEntity register(UserRegisterDto userRegisterDto) {

        UserEntity user = this.modelMapper.map(userRegisterDto,UserEntity.class);

       return this.userRepository.save(user);

    }

    public boolean checkFreeEmail(String email){

        return this.userRepository.findByEmail(email).isEmpty();

    }

    public boolean checkFreeUsername(String username){

        return this.userRepository.findByUsername(username).isEmpty();

    }

    public boolean checkFreeUsernameAndEmail(String username, String email) {

        return (this.checkFreeUsername(username) && checkFreeEmail(email));
    }

    public boolean checkPasswords(String password, String confirmPassword){

        return (password.equals(confirmPassword));
    }


    public Optional<UserEntity> checkForExistingUsernameWithPassword(String username, String password) {

        Optional<UserEntity> byUsernameAndPassword =
                this.userRepository.findByUsernameAndPassword(username, password);

        return byUsernameAndPassword;
    }

    public void loginUser(UserLoginDto userLoginDto){

        UserEntity newUser = this.userRepository.findByUsernameAndPassword(userLoginDto.getUsername(),
                userLoginDto.getPassword()).get();

        this.currentUser.setUsername(newUser.getUsername()).setId(newUser.getId());


    }
}
