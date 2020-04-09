package com.enigma.services;

import com.enigma.entities.Song;

import java.util.List;

public interface SongService {
    public Song saveSong(Song song);
    public Song saveSong(Song song, String artistId);
    public Song getSongById(String id);
    public List<Song> getAllSong();
    public void deleteSongById(String id);
    public List<Song> getSongByArtistId(String id);
}
