package com.example.service;

import com.example.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();
    void  save (Music music);
    void update(Music music);
    Music findById(Integer id);
}
