package com.enigma.services;

import com.enigma.entities.Artist;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ArtistService {
    public Artist saveImageArtist(MultipartFile image, String artist) throws IOException;
    public Artist getArtistById(String id);
    public List<Artist> getAllArtist();
    public Page<Artist> getAllArtistsPage(Pageable pageable);
    public Artist editArtist(Artist artist);
    public void deleteArtist(String id);

}
