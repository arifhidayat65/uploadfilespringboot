package com.enigma.services;

import com.enigma.entities.Artist;
import com.enigma.repositories.ArtistRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ArtistServiceImplTestJUnit5 {

    @Autowired
    ArtistService artistService;
    @MockBean
    ArtistRepository artistRepository;
    @MockBean
    FileService fileService;

    public static final Artist artist = new Artist("Jaja Miharja", "Jakarta", new Date());
    @Test
    void saveArtist_should_call_artistRepository_save_once() {
    }

    @Test
    void getArtistById() {
    }

    @Test
    void getAllArtist() {
    }

    @Test
    void getAllArtistsPage() {
    }

    @Test
    void editArtist() {
    }

    @Test
    void deleteArtist() {
    }
}