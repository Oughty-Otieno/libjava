package com.assignment.project;

import static com.assignment.project.DatabaseOperations.createBorrowing;

public class Borrowing implements ResourceOperations{

    private Integer id;
    private Integer member_id;
    private Integer book_id;
    private String date_borrowed;
    private String due_date;
    private String return_date;
    private boolean status;

    public Borrowing(Integer id, Integer member_id, Integer book_id, String date_borrowed, String due_date, String return_date, boolean status) {
        this.id = id;
        this.member_id = member_id;
        this.book_id = book_id;
        this.date_borrowed = date_borrowed;
        this.due_date = due_date;
        this.return_date = return_date;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public Integer getMember() {
        return member_id;
    }

    public Integer getBook() {
        return book_id;
    }

    public String getDate_borrowed() {
        return date_borrowed;
    }

    public String getDue_date() {
        return due_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public void storeRecord() {
        String createQuery = "INSERT INTO borrowings(id,member_id, book_id, date_borrowed, due_date, return_date, status) VALUES(?,?,?,?,?,?,?)";
        createBorrowing(createQuery, getId(), getMember(),getBook(), getDate_borrowed(), getDue_date(), getReturn_date(), isStatus());
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
