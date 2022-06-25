package com.example.examspringfundskeleton.web;

import com.example.examspringfundskeleton.dtos.SongAddDto;
import com.example.examspringfundskeleton.dtos.UserLoginDto;
import com.example.examspringfundskeleton.entity.SongEntity;
import com.example.examspringfundskeleton.entity.UserEntity;
import com.example.examspringfundskeleton.service.SongService;
import com.example.examspringfundskeleton.service.UserService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/songs")
public class SongsController {


    private final UserService userService;
    private final SongService songService;

    public SongsController(UserService userService, SongService songService) {
        this.userService = userService;
        this.songService = songService;
    }

    @ModelAttribute
    public SongAddDto songAddDto(){
        return new SongAddDto();
    }


    @GetMapping("/add")
    public String add(){

        if(!this.userService.isUserLoggedIn()){
            return "redirect:/";
        }

        return "song-add";
    }

    @PostMapping("/add")
    public String add(@Valid SongAddDto songAddDto, BindingResult bindingResult,
                        RedirectAttributes redirectAttributes){

        if(!this.userService.isUserLoggedIn()){
            return "redirect:/";
        }

        boolean isExistingPerformer =
                this.songService.isExistSameSong(songAddDto.getPerformer());

        if (bindingResult.hasErrors() || isExistingPerformer) {
            redirectAttributes.addFlashAttribute("songAddDto", songAddDto);
            redirectAttributes.addFlashAttribute("isExistingPerformer",
                    isExistingPerformer);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.songAddDto",
                    bindingResult);
            System.out.println(songAddDto);
            return "redirect:/songs/add";
        }

        SongEntity newSong =  this.songService.addSongsInDb(songAddDto);
        System.out.println(newSong);

            return "redirect:/home";
//

        }

    @GetMapping("/add/{id}")
    public String addSongToPlayList(@PathVariable Long id){

        if(!this.userService.isUserLoggedIn()){
            return "redirect:/";
        }

       SongEntity song =  this.songService.findSong(id);
       UserEntity user = this.userService.findCurrentUser();

       user.getPlaylist().add(song);
       this.userService.saveUser(user);

        return "redirect:/home";

    }


    }


