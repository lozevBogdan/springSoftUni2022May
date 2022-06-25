package com.example.examspringfundskeleton.web;

import com.example.examspringfundskeleton.dtos.SongsViewDto;
import com.example.examspringfundskeleton.entity.SongEntity;
import com.example.examspringfundskeleton.entity.StyleEnum;
import com.example.examspringfundskeleton.service.SongService;
import com.example.examspringfundskeleton.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final UserService userService;
    private final SongService songService;

    public HomeController(UserService userService, SongService songService) {
        this.userService = userService;
        this.songService = songService;
    }

    @GetMapping("/")
    public String index(){

        if(this.userService.isUserLoggedIn()){
            return "redirect:home";
        }

        return "index";
    }

    @GetMapping("/home")
    public String home(Model model){

        if(!this.userService.isUserLoggedIn()){
            return "redirect:/";
        }

        List<SongsViewDto> playlistOfUser =
                userService.findCurrentUserPlaylist();

      //  List<SongsViewDto> allSongs = this.songService.getAllSongs();

       // List<SongEntity> allSongsEntity = this.songService.getAllSongsEntity();

        List<SongsViewDto> popSongs =
                this.songService.
                        getAllSongs().
                        stream().
                        filter(s->s.getStyle().getName() == StyleEnum.POP)
                        .collect(Collectors.toList());

        List<SongsViewDto> rockSongs =
                this.songService.
                        getAllSongs().
                        stream().
                        filter(s->s.getStyle().getName() == StyleEnum.ROCK)
                        .collect(Collectors.toList());

        List<SongsViewDto> jazzSongs =
                this.songService.
                        getAllSongs().
                        stream().
                        filter(s->s.getStyle().getName() == StyleEnum.JAZZ)
                        .collect(Collectors.toList());

            model.addAttribute("popSongs",popSongs);
            model.addAttribute("rockSongs",rockSongs);
            model.addAttribute("jazzSongs",jazzSongs);
            model.addAttribute("playlistOfUser",playlistOfUser);
            model.addAttribute("totalTime",this.getAllTimeOfPlaylistUser());

        return "home";
    }

    public String returnMinets(int seconds){
        int sec = seconds % 60;

        int minets = seconds / 60;

        String secondsString ="";

        if(sec < 10 ){
            secondsString =String.format("0%d",sec);

        }  else{
            secondsString =String.format("%d",sec);
        }       return String.format("%d:%s",minets,secondsString);

    }

    public String getAllTimeOfPlaylistUser(){

       List<SongEntity> playlist =  this.userService.getPlayListEntity();
        int totalTme = 0;

        for (SongEntity songEntity : playlist) {
            totalTme+= songEntity.getDuration();
        }

        return returnMinets(totalTme);

    }
}
