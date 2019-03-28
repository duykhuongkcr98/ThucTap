package com.example.thuctap.Model;

public class Song {
    String nameSong;
    int imgSong;
    String nameSinger;
    String URL;

    public Song(String nameSong, int imgSong, String nameSinger, String URL) {
        this.nameSong = nameSong;
        this.imgSong = imgSong;
        this.nameSinger = nameSinger;
        this.URL = URL;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public int getImgSong() {
        return imgSong;
    }

    public void setImgSong(int imgSong) {
        this.imgSong = imgSong;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
