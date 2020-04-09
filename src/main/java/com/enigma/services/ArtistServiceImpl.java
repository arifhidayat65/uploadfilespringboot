package com.enigma.services;

import com.enigma.entities.Artist;
import com.enigma.entities.Song;
import com.enigma.repositories.ArtistRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    ArtistRepository artistRepository;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    FileService fileService;


    @Override
    public Artist saveImageArtist(MultipartFile image, String artist) throws IOException {
        Artist newArtist = objectMapper.readValue(artist, Artist.class);
        fileService.saveImageArtist(image,newArtist.getId());
        for (Song song: newArtist.getSongs()) {
            song.setArtist(newArtist);
        }
        return artistRepository.save(newArtist);
    }

    @Override
    public Artist getArtistById(String id) {
        return artistRepository.findById(id).get();
    }

    @Override
    public List<Artist> getAllArtist() {
        return artistRepository.findAll();
    }

    @Override
    public Page<Artist> getAllArtistsPage(Pageable pageable) {
        return artistRepository.findAll(pageable);
    }

    @Override
    public Artist editArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public void deleteArtist(String id) {
        artistRepository.deleteById(id);
    }
}
