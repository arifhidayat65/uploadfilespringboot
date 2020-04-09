package com.enigma.controllers;

import com.enigma.entities.Artist;
import com.enigma.services.ArtistService;
import com.enigma.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class ArtistController {

    @Autowired
    ArtistService artistService;
    @Autowired
    FileService fileService;
//    @CrossOrigin
//    @PostMapping("/artist")
//    public Artist saveArtist(@RequestBody Artist artist) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonArtist = objectMapper.writeValueAsString(artist);
//        return artistService.saveArtist(jsonArtist);
//    }

    @CrossOrigin
    @GetMapping("/artist/{id}")
    public Artist getArtistById(@PathVariable String id){
        return artistService.getArtistById(id);
    }

    @CrossOrigin
    @GetMapping("/artists-page")
    public Page<Artist> getAllArtistPage(@RequestParam Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return artistService.getAllArtistsPage(pageable);
    }

    @CrossOrigin
    @GetMapping("/artists")
    public List<Artist> getAllArtist(){
        return artistService.getAllArtist();
    }

    @CrossOrigin
    @PostMapping("/edit-artist")
    public Artist editArtist(@RequestBody Artist artist){
        return artistService.editArtist(artist);
    }

    @CrossOrigin
    @DeleteMapping("/artist/{id}")
    public void deleteArtist(@PathVariable String id){
        artistService.deleteArtist(id);
    }

    @CrossOrigin
    @PostMapping("/save-artist")
    public Artist saveArtistWithImage(@RequestPart MultipartFile image, String artistInput) throws IOException {
        return artistService.saveImageArtist(image, artistInput);
    }
}
