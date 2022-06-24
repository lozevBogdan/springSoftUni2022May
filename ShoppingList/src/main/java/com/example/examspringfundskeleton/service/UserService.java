package com.example.examspringfundskeleton.service;

import com.example.examspringfundskeleton.currUser.CurrentUser;
import com.example.examspringfundskeleton.dtos.UserLoginDto;
import com.example.examspringfundskeleton.dtos.UserRegisterDto;
import com.example.examspringfundskeleton.entity.UserEntity;
import com.example.examspringfundskeleton.repositories.UserRepository;
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

    public boolean checkForExistingUsername(String username) {
        return this.userRepository.findByUsername(username).isPresent();
    }

    public UserEntity register(UserRegisterDto userRegisterDto) {

        UserEntity newUser = this.modelMapper.map(userRegisterDto,UserEntity.class);

      return this.userRepository.save(newUser);

    }

    public boolean checkForExistingUserByUsenameAndPassword(String username, String password) {
        return this.userRepository.findByUsernameAndPassword(username,password).isPresent();
    }

    public UserEntity login(UserLoginDto userLoginDto) {

        UserEntity user = this.userRepository.findByUsername(userLoginDto.getUsername()).get();

        this.currentUser.setUsername(user.getUsername()).setId(user.getId());


        return user;
    }

    public void logout() {
        this.currentUser.
                setUsername(null)
                .setId(null);

    }


}
