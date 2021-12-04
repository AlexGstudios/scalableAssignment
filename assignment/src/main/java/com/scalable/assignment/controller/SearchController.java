package com.scalable.assignment.controller;

import java.util.Collection;

import com.scalable.assignment.model.Theme;
import com.scalable.assignment.service.SearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping("/find")
    public Collection<Theme> getSearched(@RequestBody String name) {

        return searchService.getSearched(name);
    }

    @GetMapping("/all")
    public Collection<Theme> getAll() {
        return searchService.getAll();
    }
}