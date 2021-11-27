package com.scalable.assignment.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.scalable.assignment.model.Theme;
import com.scalable.assignment.util.DataFromFile;

import org.springframework.stereotype.Repository;

@Repository
public class SearchRepository {

    Map<String, Theme> themes = DataFromFile.getData();

    public Collection<Theme> getAll() {
        return themes.values();
    }

    public Collection<Theme> get(String searched) {

        List<Theme> themeList = new ArrayList<>();

        for (Theme theme : themes.values()) {
            if (theme.getName().toLowerCase().contains(searched.toLowerCase())) {
                themeList.add(theme);
            }
        }
        return themeList;
    }
}