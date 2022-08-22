package com.example.service;

import com.example.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    Music findById(int id);

    void save(Music music);

    void update(Music music);

    void delete(int id);
}
