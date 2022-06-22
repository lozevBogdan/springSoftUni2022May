package com.example.coffieshopexmaprep.service;

import com.example.coffieshopexmaprep.dto.UserRegistrationDto;
import com.example.coffieshopexmaprep.entity.UserEntity;
import com.example.coffieshopexmaprep.repositories.UserRepository;
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

    public void registerUser(UserRegistrationDto userRegistrationDto) {

        UserEntity user = this.modelMapper.map(userRegistrationDto,UserEntity.class);

        this.userRepository.save(user);

    }
}
