package bg.softUni.mobilele.service;

import bg.softUni.mobilele.model.dto.UserLoginDto;
import bg.softUni.mobilele.model.entity.UserEntity;
import bg.softUni.mobilele.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public boolean login(UserLoginDto userLoginDto){

        Optional<UserEntity> userOpt =
                userRepository.findByEmail(userLoginDto.getUsername());

        if(userOpt.isEmpty()){
            LOGGER.info("User with name [{}] not found",userLoginDto.getUsername());
            return false;
        }




        return true;

    }


}
