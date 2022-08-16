package com.dictionary.repository.impl;

import com.dictionary.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;


@Repository
public class DictionaryRepository implements IDictionaryRepository {
    String[] english = {"hello", "good bye", "convert"};
    String[] vietnam = {"xin chào", "tạm biệt", "chuyển đổi"};

    @Override
    public String convert(String word) {
        String result = "Không tìm thấy";
        for (int i = 0; i < english.length; i++) {
            if (word.equals(english[i])) {
                result = vietnam[i];
            }
        }
        return result;
    }
}
