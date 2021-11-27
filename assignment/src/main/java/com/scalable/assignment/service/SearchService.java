package com.scalable.assignment.service;

import java.util.Collection;

import com.scalable.assignment.model.Theme;

public interface SearchService {

    public Collection<Theme> getSearched(String name);

    public Collection<Theme> getAll();
}