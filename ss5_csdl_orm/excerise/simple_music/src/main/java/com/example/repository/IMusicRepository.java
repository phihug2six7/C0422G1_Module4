package com.example.repository;

import com.example.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> findAll();

    Music findById(int id);

    void save(Music music);

    void update(Music music);

    void delete(int id);
}
