package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.dto.UserRegistrationDto;
import bg.softuni.pathfinder.model.RoleEntity;
import bg.softuni.pathfinder.model.UserEntity;
import bg.softuni.pathfinder.model.enums.RoleEnum;
import bg.softuni.pathfinder.repository.RoleRepository;
import bg.softuni.pathfinder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public AuthService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void register(UserRegistrationDto userRegistrationDto) {

        if (!userRegistrationDto.getPassword().equals(userRegistrationDto.getConfirmPassword())) {
            throw new RuntimeException("password.match");
        }

        Optional<UserEntity> byEmail = userRepository.findByEmail(userRegistrationDto.getEmail());

        if (byEmail.isPresent()) {
            throw new RuntimeException("email.used");
        }

        UserEntity newUser = new UserEntity(
                userRegistrationDto.getUsername(),
                userRegistrationDto.getPassword(),
                userRegistrationDto.getAge(),
                userRegistrationDto.getEmail(),
                userRegistrationDto.getFullname());

        RoleEntity userRole = roleRepository.findByRole(RoleEnum.USER).get();
        newUser.getRoles().add(userRole);

        userRepository.save(newUser);


    }

}
