package com.scalable.assignment.impl;

import java.util.Collection;

import com.scalable.assignment.model.Theme;
import com.scalable.assignment.repository.SearchRepository;
import com.scalable.assignment.service.SearchService;

import org.springframework.stereotype.Service;

@Service
public class SearchedImpl implements SearchService {

    SearchRepository srcRepo;

    public SearchedImpl(SearchRepository repo) {
        this.srcRepo = repo;
    }

    @Override
    public Collection<Theme> getSearched(String name) {

        return srcRepo.get(name);
    }

    @Override
    public Collection<Theme> getAll() {
        return srcRepo.getAll();
    }
}