package com.example.examspringfundskeleton.service;

import com.example.examspringfundskeleton.dtos.SongAddDto;
import com.example.examspringfundskeleton.dtos.SongsViewDto;
import com.example.examspringfundskeleton.entity.SongEntity;
import com.example.examspringfundskeleton.repositories.SongRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongService {

    private final SongRepository songRepository;
    private final StyleService styleService;
    private final ModelMapper modelMapper;

    public SongService(SongRepository songRepository, StyleService styleService, ModelMapper modelMapper) {
        this.songRepository = songRepository;
        this.styleService = styleService;
        this.modelMapper = modelMapper;
    }


    public SongEntity addSongsInDb(SongAddDto songAddDto) {

        SongEntity newSong = this.modelMapper.map(songAddDto,SongEntity.class);

        newSong.setStyle(this.styleService.findStyleByStyleEnum(songAddDto.getStyle()));

        return this.songRepository.save(newSong);
    }

    public boolean isExistSameSong(String performer){
        return this.songRepository.findByPerformer(performer).isPresent();
    }

    public List<SongsViewDto> getAllSongs() {

        List<SongsViewDto> dtoSongs = new LinkedList<>();

        this.songRepository.
                findAll().forEach(s->{
                    SongsViewDto songsViewDto = new SongsViewDto();

                    songsViewDto.
                            setId(s.getId()).
                            setStyle(s.getStyle()).
                            setPerformer(s.getPerformer()).
                            setTitle(s.getTitle()).
                            setDurationInMin(this.returnMinets(s.getDuration()));

                   dtoSongs.add(songsViewDto);

               });

        return dtoSongs;


    }

    public SongEntity findSong(Long id) {
        return this.songRepository.findById(id).get();
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

    public List<SongEntity> getAllSongsEntity() {
        return this.songRepository.findAll();
    }
}
