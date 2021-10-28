package com.assignment.project;


import static com.assignment.project.DatabaseOperations.createBook;


public class Book implements ResourceOperations{
    private Integer id;
    private String title;
    private String author;
    private Integer category_id ;
    private Integer fine_amount;
    private String publisher;
    private Integer quantity;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public Integer getFine_amount() {
        return fine_amount;
    }

    public String getPublisher() {
        return publisher;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Book(Integer id, String title, String author, Integer category_id, Integer fine_amount, String publisher, Integer quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category_id = category_id;
        this.fine_amount = fine_amount;
        this.publisher = publisher;
        this.quantity = quantity;
    }

    @Override
    public void storeRecord() {
        String createQuery = "INSERT INTO books(id,title, author, category_id, fine_amount, publisher, quantity) VALUES(?,?,?,?,?,?,?)";
        createBook(createQuery, getId(), getTitle(),getAuthor(), getCategory_id(), getFine_amount(), getPublisher(), getQuantity());
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
