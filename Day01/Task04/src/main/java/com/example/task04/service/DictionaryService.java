package com.example.task04.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictionaryService {
    Map<String, String> dictionary;

    public DictionaryService() {
        dictionary = new HashMap<>();
        dictionary.put("Hello", "Chào");
        dictionary.put("Cat", "Mèo");
        dictionary.put("Dog", "Chó");

    }

    public String getVietnamese(String word) {
        return dictionary.get(word);
    }
}
