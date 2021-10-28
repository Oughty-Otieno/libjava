package com.assignment.project;

import static com.assignment.project.DatabaseOperations.createCategory;

public class Category implements ResourceOperations{
    private Integer id;
    private String name;

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public void storeRecord() {
        String createQuery = "INSERT INTO categories(id,name) VALUES(?,?)";
        createCategory(createQuery, getId(), getName());
    }

    @Override
    public void listRecords() {

    }

    @Override
    public void updateRecords() {

    }

    @Override
    public void deleteRecords() {

    }
}
