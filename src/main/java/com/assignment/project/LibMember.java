package com.assignment.project;

import static com.assignment.project.DatabaseOperations.createUser;

public class LibMember extends User implements ResourceOperations {

    private String role = "Member";

    public LibMember(int id, String email, String password, String name, String role) {
        super(id, email, password, name);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public void storeRecord() {
        String createQuery = "INSERT INTO users(id,name, email, password, role) VALUES(?,?,?,?,?)";
        createUser(createQuery, getId(), getName(),getEmail(), getPassword(), getRole());
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
