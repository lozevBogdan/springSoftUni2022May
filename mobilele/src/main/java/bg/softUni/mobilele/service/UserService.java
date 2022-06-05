package bg.softUni.mobilele.service;

import bg.softUni.mobilele.model.dto.UserLoginDto;
import bg.softUni.mobilele.model.entity.UserEntity;
import bg.softUni.mobilele.repository.UserRepository;
import bg.softUni.mobilele.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    private CurrentUser currentUser;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, CurrentUser currentUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }


    public boolean login(UserLoginDto userLoginDto){

        Optional<UserEntity> userOpt =
                userRepository.findByEmail(userLoginDto.getUsername());

        if(userOpt.isEmpty()){
            LOGGER.info("User with name [{}] not found",userLoginDto.getUsername());
            return false;
        }

        String rawPassword = userLoginDto.getPassword();
        String encodedPassword = userOpt.get().getPassword();

        boolean success =
                passwordEncoder.matches(rawPassword,encodedPassword);

        if(success){
            login(userOpt.get());
        }else {
            logout();
        }
        return success;

    }

    private void login(UserEntity userEntity){
        currentUser
                .setLoggedIn(true)
                .setName(userEntity.getFirstName() + " " +  userEntity.getLastName());

    }

    public void logout(){
        currentUser.clear();
    }


}
