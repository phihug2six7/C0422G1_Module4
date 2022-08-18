package com.example.repository.impl;

import com.example.repository.ILanguageRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LanguageRepository implements ILanguageRepository {
    private static List<String> stringList = new ArrayList<>();
    private static List<String> stringList2 = new ArrayList<>();

    static {
        stringList.add("English");
        stringList.add("Vietnamese");
        stringList.add("Japanese");
        stringList.add("Chinese");
    }

    static {
        stringList2.add("5");
        stringList2.add("10");
        stringList2.add("15");
        stringList2.add("25");
        stringList2.add("50");
        stringList2.add("100 email per page");
    }

    @Override
    public List<String> findAllLanguage() {
        return stringList;
    }

    @Override
    public List<String> findAllPageSize() {
        return stringList2;
    }
}
