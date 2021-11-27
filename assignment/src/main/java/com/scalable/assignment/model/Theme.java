package com.scalable.assignment.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Theme {

    private String id;
    private String name;
    private String parentId;

    public Theme(String id, String name, String parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }
}