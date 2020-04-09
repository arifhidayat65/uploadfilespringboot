package com.enigma.services;

import com.enigma.entities.Artist;
import com.enigma.repositories.ArtistRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArtistServiceImplTest {

    @Autowired
    ArtistRepository artistRepository;

    @Autowired
    ArtistService artistService;
    @Before
    public void deleteAll(){
        artistRepository.deleteAll();
    }
//    @Test
//    public void saveArtist_should_return_artist_andExistInDB_when_oneArtistInput() {
//        Artist artist = new Artist("Ari Lasso", "Surabaya", new Date());
//        Artist newArtist = artistService.saveImageArtist(artist);
//        Artist actual = artistRepository.findById(artist.getId()).get();
//        assertEquals(newArtist, actual);
//    }

    @Test
    public void getArtistById_should_return_oneArtist_whenFound() {
        Artist artist = new Artist("Ari Lasso", "Surabaya", new Date());
        artist = artistRepository.save(artist);
        assertEquals(artist, artistService.getArtistById(artist.getId()));


    }

//    @Test
//    public void getAllArtists_should_return_2_when_2_artistInput() {
//        Artist artist1 = new Artist("Ari Lasso", "Surabaya", new Date());
//        Artist artist2 = new Artist("Glen Fredly", "Ambon", new Date());
//        artistRepository.save(artist1);
//        artistRepository.save(artist2);
//        Pageable pageable = PageRequest.of(0, 3);
//        assertEquals(2, artistService.getAllArtists(pageable).getTotalElements());
//    }

    @Test
    public void editArtist_should_return_newData_when_dataArtist_edited() {
        Artist artist = new Artist("Ari Lasso", "Surabaya", new Date());
        artist = artistRepository.save(artist);
        Artist artistEdit = new Artist("Ari Lasso", "Jakarta", new Date());
        artistEdit.setId(artist.getId());
        Artist expected = artistRepository.save(artistEdit);
        Artist actual = artistService.editArtist(artistEdit);
        assertEquals(expected, actual);
    }

//    @Test
//    public void deleteArtist_should_make_anEmptyDB_when1DateDeleted() {
//        Artist artist = new Artist("Ari Lasso", "Surabaya", new Date());
//        artist = artistRepository.save(artist);
//        artistService.deleteArtist(artist.getId());
//        Pageable pageable = PageRequest.of(0, 3);
//        assertEquals(0, artistService.getAllArtists(pageable).getTotalElements());
//    }
}