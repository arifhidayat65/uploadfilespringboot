package com.enigma.services;

import com.enigma.entities.Artist;
import com.enigma.entities.Song;
import com.enigma.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    SongRepository songRepository;

    @Autowired
    ArtistService artistService;

    @Override
    public Song saveSong(Song song) {
        return songRepository.save(song);
    }
    public Song saveSong(Song song, String artistId){
        Artist artist = artistService.getArtistById(artistId);
        song.setArtist(artist);
        return songRepository.save(song);
    }

    @Override
    public Song getSongById(String id) {
        return songRepository.findById(id).get();
    }

    @Override
    public List<Song> getAllSong() {
        return songRepository.findAll();
    }

    @Override
    public void deleteSongById(String id) {
        songRepository.deleteById(id);
    }

    @Override
    public List<Song> getSongByArtistId(String id) {
        return songRepository.findAllByArtist_Id(id);
    }
}
