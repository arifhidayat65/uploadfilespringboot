package com.enigma.controllers;

import com.enigma.entities.Song;
import com.enigma.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongController {
    @Autowired
    SongService songService;

    @CrossOrigin
    @PostMapping("/song")
    public Song saveSong(@RequestBody Song song){
        return songService.saveSong(song);
    }

    @CrossOrigin
    @PostMapping("/song/{id}")
    public Song saveSongWithTransient(@RequestBody Song song, @PathVariable String id){
        return songService.saveSong(song, id);
    }

    @CrossOrigin
    @GetMapping("/song/{id}")
    public Song getSongById(@PathVariable String id){
        return songService.getSongById(id);
    }

    @CrossOrigin
    @GetMapping("/songs")
    public List<Song> getAllSong(){
        return songService.getAllSong();
    }

    @CrossOrigin
    @DeleteMapping("/song/{id}")
    public void deleteSong(@PathVariable String id){
        songService.deleteSongById(id);
    }

    @CrossOrigin
    @GetMapping("/artist-songs/{id}")
    public List<Song> getSongByArtistId(@PathVariable String id){
        return songService.getSongByArtistId(id);
    }
}
