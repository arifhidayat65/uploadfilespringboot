package com.enigma.services;

import com.enigma.entities.Song;
import com.enigma.repositories.SongRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SongServiceImplTestJUnit5 {

    @Autowired
    SongService songService;

    @MockBean
    SongRepository songRepository;

    @MockBean
    ArtistService artistService;

    private static final Song song = new Song("Manuk Dadali", "Unknown");

    @Test
    void saveSong_should_call_songRepository_save_once() {
        songService.saveSong(song);
        Mockito.verify(songRepository, Mockito.times(1)).save(song);
    }

    @Test
    void testSaveSong() {
    }

    @Test
    void getSongById() {
        song.setId("asjdniwd12");
        Mockito.when(songRepository.findById(song.getId())).thenReturn(Optional.of(song));
        songService.getSongById(song.getId());
        Mockito.verify(songRepository, Mockito.times(1)).findById(song.getId());
    }

    @Test
    void getAllSong() {
    }

    @Test
    void deleteSongById() {
    }

    @Test
    void getSongByArtistId() {
    }
}