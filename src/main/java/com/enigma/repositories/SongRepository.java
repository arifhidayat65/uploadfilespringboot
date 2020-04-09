package com.enigma.repositories;

import com.enigma.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, String> {
    public List<Song> findAllByArtist_Id(String id);
}
