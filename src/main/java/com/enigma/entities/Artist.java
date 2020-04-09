package com.enigma.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "mst_artist")
public class Artist {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String name;
    private String originPlace;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date debut;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.PERSIST)
    List<Song> songs = new ArrayList<>();

    public Artist() {
    }

    public Artist(String name, String originPlace, Date debut) {
        this.name = name;
        this.originPlace = originPlace;
        this.debut = debut;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginPlace() {
        return originPlace;
    }

    public void setOriginPlace(String originPlace) {
        this.originPlace = originPlace;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(id, artist.id) &&
                Objects.equals(name, artist.name) &&
                Objects.equals(originPlace, artist.originPlace) &&
                Objects.equals(debut, artist.debut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, originPlace, debut);
    }
}
