package com.example.repository;

import com.example.model.Declaration;

import java.util.List;

public interface IDeclarationRepository {
    List<String> findAllYears();
    List<String> findAllGender();
    List<String> findALlNation();
    List<String> findAllTravelInformation();
    List<String> findAllDayStart();
    List<String> findAllMonthStart();
    List<String> findAllYearsStart();
    List<String> findAllDayEnd();
    List<String> findAllMonthEnd();
    List<String> findAllYearsEnd();

    List<Declaration> findAll();

    Declaration findById(int id);

    void create(Declaration declaration);

    void update(int id, Declaration declaration);
}
