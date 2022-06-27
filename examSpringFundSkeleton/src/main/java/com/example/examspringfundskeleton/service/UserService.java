package com.example.examspringfundskeleton.service;

import com.example.examspringfundskeleton.currUser.CurrentUser;
import com.example.examspringfundskeleton.dtos.SongsViewDto;
import com.example.examspringfundskeleton.dtos.UserLoginDto;
import com.example.examspringfundskeleton.dtos.UserRegisterDto;
import com.example.examspringfundskeleton.entity.SongEntity;
import com.example.examspringfundskeleton.entity.UserEntity;
import com.example.examspringfundskeleton.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, CurrentUser currentUser, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    public boolean existingUsername(String username){
        return this.userRepository.findByUsername(username).isPresent();
    }

    public boolean existingEmail(String email){
        return this.userRepository.findByEmail(email).isPresent();
    }

    public boolean existingCredentialsInDb(String username,String password){
        return this.userRepository.findByUsernameAndPassword(username,password).isPresent();
    }

    public void loginUser(UserLoginDto userLoginDto){
        UserEntity user =
                this.userRepository.
                        findByUsername(userLoginDto.getUsername()).
                        get();

        this.currentUser.setId(user.getId()).setUsername(userLoginDto.getUsername());
    }

    public UserEntity registerUser(UserRegisterDto userRegisterDto){

        UserEntity newUser = modelMapper.map(userRegisterDto,UserEntity.class);

        //todo

      return this.userRepository.save(newUser);

    }

    public boolean checkPasswordsEquals(String password, String confirmPassword){
        return password.equals(confirmPassword);
    }

    public boolean isUserLoggedIn(){
        return this.currentUser.isLogged();
    }


    public List<SongsViewDto> findCurrentUserPlaylist() {


        List<SongsViewDto> playlist = new ArrayList<>();

        this.userRepository.
                findById(currentUser.getId()).
                get().getPlaylist()
            .forEach(s->{
                    SongsViewDto songsViewDto = new SongsViewDto();

                    songsViewDto.
                            setId(s.getId()).
                            setStyle(s.getStyle()).
                            setPerformer(s.getPerformer()).
                            setTitle(s.getTitle()).
                            setDurationInMin(this.returnMinets(s.getDuration()));

                playlist.add(songsViewDto);

                });



        return playlist ;
    }

    public void deleteAllSongsFromPLayList() {

        UserEntity currentUserEntity =
                this.userRepository.findById(currentUser.getId()).get();
        currentUserEntity.getPlaylist().clear();
        this.userRepository.save(currentUserEntity);
    }

    public UserEntity findCurrentUser() {
        return this.userRepository.findById(currentUser.getId()).get();
    }

    public void saveUser(UserEntity user) {
        this.userRepository.save(user);
    }
    public String returnMinets(int seconds){
        int sec = seconds % 60;

        int minets = seconds / 60;

        String secondsString ="";

        if(sec < 10 ){
            secondsString =String.format("0%d",sec);

        }   else{
            secondsString =String.format("%d",sec);
        }
        return String.format("%d:%s",minets,secondsString);

    }

    public List<SongEntity> getPlayListEntity() {
       return this.userRepository.findByUsername(currentUser.getUsername()).get().getPlaylist();
    }

    public void logoutUser() {
        this.currentUser.setUsername(null).setId(null);
    }
}
