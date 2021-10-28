package com.assignment.project;

import static com.assignment.project.DatabaseOperations.listMembers;
import static com.assignment.project.DatabaseOperations.insertClearBorrow;

public class LibAdmin extends User implements ResourceOperations {

    private static String role ="Admin";

    public LibAdmin(int id, String email, String password, String name, String role) {
        super(id, email, password, name);
        this.role = role;
    }

    public static void main(String[] args) {
        //clearBorrowing(3, "28-10-2024");
        //listlibMembers();
        //createMember(4,"otieno@web", "password","Joshua", "member");
        //createBook(1, "The art of War", "SUn Tzue", 4, 400, "Macmilan", 400);
        //createCategory(1, "Politics");
        //createBorrowing(3,4, 4, "31-10-2021", "15-11-2021", " ", true);
    }


    public static void createMember(int id, String email, String password, String name, String role) {
        LibMember newMember = new LibMember(id, email, password, name, role);
        newMember.storeRecord();
    }

    public static void createCategory(int id, String name) {
        Category newcategory = new Category(id, name);
        newcategory.storeRecord();
    }

    public static void createBorrowing(Integer id, Integer member_id, Integer book_id, String date_borrowed, String due_date, String return_date, boolean status) {
        Borrowing newborrowing = new Borrowing(id, member_id, book_id, date_borrowed, due_date,return_date, status);
        newborrowing.storeRecord();
    }

    public static void createBook(int id, String title, String author, Integer category_id, Integer fine_amount, String publisher, Integer quantity) {
        Book newbook = new Book(id, title, author, category_id, fine_amount, publisher, quantity);
        newbook.storeRecord();
    }

    public static void listlibMembers(){
        String listquery = "SELECT id, name, email  FROM users";
        listMembers(listquery);
    }

    public static void clearBorrowing(Integer id, String return_date){
//       update `borrowings` set `return_date` = 20-11-2022 where id = 2
        String updatequery = "UPDATE borrowings set return_date = ? where id = ?";
        insertClearBorrow(updatequery,return_date, id);
    }

    public static String getRole() {
        return role;
    }

    @Override
    public void storeRecord() {

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
