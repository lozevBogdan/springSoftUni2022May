package com.example.battleShips.service;

import com.example.battleShips.dtos.UserRegisterDto;
import com.example.battleShips.entity.UserEntity;
import com.example.battleShips.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
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

}
