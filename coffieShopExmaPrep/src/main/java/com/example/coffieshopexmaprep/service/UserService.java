package com.example.coffieshopexmaprep.service;

import com.example.coffieshopexmaprep.currentUser.CurrentUser;
import com.example.coffieshopexmaprep.dto.UserLoginDto;
import com.example.coffieshopexmaprep.dto.UserRegistrationDto;
import com.example.coffieshopexmaprep.entity.UserEntity;
import com.example.coffieshopexmaprep.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public void registerUser(UserRegistrationDto userRegistrationDto) {

        UserEntity user = this.modelMapper.map(userRegistrationDto,UserEntity.class);

        this.userRepository.save(user);

    }

    public boolean loginUser(UserLoginDto userLoginDto){

        Optional<UserEntity> byUsernameAndPassword = this.userRepository.
                findByUsernameAndPassword(userLoginDto.getUsername(),
                        userLoginDto.getPassword());

        if (byUsernameAndPassword.isEmpty()){
            return false;
        }

        this.currentUser.
                setUsername(byUsernameAndPassword.get().getUsername()).
                setId(byUsernameAndPassword.get().getId());

        return true;

    }

    public void logout(){
        this.currentUser.setId(null).setUsername(null);
    }

    public boolean checkUsernameIsFree(String username) {
        return
                (this.userRepository.findByUsername(username) == null);
    }

    public UserEntity findCurrentUserById(Long id) {
        return this.userRepository.findById(id).get();
    }

    public List<UserEntity> getAll() {
       return this.userRepository.findAll();
    }
}
