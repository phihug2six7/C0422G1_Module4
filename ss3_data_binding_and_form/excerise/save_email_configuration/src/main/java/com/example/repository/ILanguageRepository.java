package com.example.repository;

import java.util.List;

public interface ILanguageRepository {
    List<String> findAllLanguage();
    List<String> findAllPageSize();
}
