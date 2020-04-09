package com.enigma.services;

import com.enigma.entities.Song;
import com.enigma.repositories.SongRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SongServiceImplTest {

    @Autowired
    SongRepository songRepository;
    @Autowired
    SongService songService;

    @Before
    public void deleteAll(){
        songRepository.deleteAll();
    }

    @Test
    public void saveSong() {
        Song song = new Song("Bohemian Rhapsody", "Freddie Mercury");
        song = songService.saveSong(song);
        Song actual = songRepository.findById(song.getId()).get();
        assertEquals(song, actual);
    }

//    @Test
//    public void saveSongwith_artistTransient() {
//        Song song = new Song("Bohemian Rhapsody", "Freddie Mercury");
//        song = songService.saveSong(song, "8a8a8d2c6e05eadc016e05eb79310000");
//        Song actual = songRepository.findById(song.getId()).get();
//        assertEquals(song, actual);
//    }

    @Test
    public void getSongById() {
        Song song = new Song("Bohemian Rhapsody", "Freddie Mercury");
        song = songService.saveSong(song);
        assertEquals(song, songService.getSongById(song.getId()));
    }

    @Test
    public void getAllSong_should_return_2_when_2DataInputed() {
        Song song1 = new Song("Bohemian Rhapsody", "Freddie Mercury");
        Song song2 = new Song("Love Of My Live", "Freddie Mercury");
        Song song3 = new Song("Love Of My Live", "Freddie Mercury");
        songService.saveSong(song1);
        songService.saveSong(song2);
        songService.saveSong(song3);
        assertEquals(3, songService.getAllSong().size());
    }

    @Test
    public void deleteSongById_should_return_zero_when_allDataDeleted() {
        Song song = new Song("Bohemian Rhapsody", "Freddie Mercury");
        song = songRepository.save(song);
        songService.deleteSongById(song.getId());
        assertEquals(0, songRepository.findAll().size());


    }
}