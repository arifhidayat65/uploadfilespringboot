package com.enigma.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mst_song")
public class Song {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String title;
    private String songWriter;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    @JsonIgnore
    private Artist artist;

    @Transient
    private String artistId;

    public Song() {
    }

    public Song(String title, String songWriter) {
        this.title = title;
        this.songWriter = songWriter;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getArtistId() {
        if (!(artist== null)) {
            return artist.getName();
        }
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(id, song.id) &&
                Objects.equals(title, song.title) &&
                Objects.equals(songWriter, song.songWriter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, songWriter);
    }
}
