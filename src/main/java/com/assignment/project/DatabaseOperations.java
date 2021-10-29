package com.assignment.project;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseOperations {
    final static String url = "jdbc:mysql://localhost:3306/libjava?useSSL=false";
    final static String user = "root";
    final static String password = "";

    static void checkVersion() {
        String query = "SELECT VERSION()";
        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            if (rs.next()) {
                System.out.println("it has connected");
                System.out.println(rs.getString(1));
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DatabaseOperations.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    static void createUser(String createquerry, int id, String name, String email, String password, String role) {

        try (Connection con = DriverManager.getConnection(url, user, DatabaseOperations.password);
             PreparedStatement pst = con.prepareStatement(createquerry)) {
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setString(3, email);
            pst.setString(4, password);
            pst.setString(5, role);

            pst.executeUpdate();

            System.out.println("A new user has been created");

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(DatabaseOperations.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
    }

    static void createBook(String createquerry, int id, String title, String author, Integer category_id, Integer fine_amount, String publisher, Integer quantity) {

        try (Connection con = DriverManager.getConnection(url, user, DatabaseOperations.password);
             PreparedStatement pst = con.prepareStatement(createquerry)) {
            pst.setInt(1, id);
            pst.setString(2, title);
            pst.setString(3, author);
            pst.setInt(4, category_id);
            pst.setInt(5, fine_amount);
            pst.setString(6, publisher);
            pst.setInt(7, quantity);

            pst.executeUpdate();

            System.out.println("A new book has been created");

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(DatabaseOperations.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
    }

    static void createBorrowing(String createquerry,  Integer id, Integer member_id, Integer book_id, String date_borrowed, String due_date, String return_date, boolean status) {

        try (Connection con = DriverManager.getConnection(url, user, DatabaseOperations.password);
             PreparedStatement pst = con.prepareStatement(createquerry)) {
            pst.setInt(1, id);
            pst.setInt(2, member_id);
            pst.setInt(3, book_id);
            pst.setString(4, date_borrowed);
            pst.setString(5, due_date);
            pst.setString(6, return_date);
            pst.setBoolean(7, status);

            pst.executeUpdate();

            System.out.println("A new borrowing has been created");

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(DatabaseOperations.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
    }


    static void createCategory(String createquerry, int id, String name) {

        try (Connection con = DriverManager.getConnection(url, user, DatabaseOperations.password);
             PreparedStatement pst = con.prepareStatement(createquerry)) {
            pst.setInt(1, id);
            pst.setString(2, name);

            pst.executeUpdate();

            System.out.println("A new category has been created");

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(DatabaseOperations.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
    }

    static void insertClearBorrow(String updatequery, String return_date, Integer id) {

        try (Connection con = DriverManager.getConnection(url, user, DatabaseOperations.password);
             PreparedStatement pst = con.prepareStatement(updatequery)) {
            pst.setString(1, return_date);
            pst.setInt(2, id);
            pst.executeUpdate();

            System.out.println("The borrowing has been cleared");

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(DatabaseOperations.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
    }


    static void listMembers(String listquery) {
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(listquery);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Name: " + rs.getString("name"));
                System.out.println(", Email: " + rs.getString("email"));
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DatabaseOperations.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    static void listAllCategories(String listallcategories){
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(listallcategories);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                System.out.print("ID: " + rs.getInt("id"));
                System.out.println(", Name: " + rs.getString("name"));
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DatabaseOperations.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    static void listAllBooks(String listallbooks){
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(listallbooks);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Title: " + rs.getString("title"));
                System.out.print(", Author: " + rs.getString("author"));
                System.out.print(", Publisher: " + rs.getString("publisher"));
                System.out.println(", Quantity: " + rs.getString("quantity"));
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DatabaseOperations.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    static void listAllBorrowing(String listallborrowing){
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(listallborrowing);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Member Id: " + rs.getString("member_id"));
                System.out.print(", Book Id: " + rs.getString("member_id"));
                System.out.print(", Date Borrowed: " + rs.getString("book_id"));
                System.out.print(", Due Borrowed: " + rs.getString("date_borrowed"));
                System.out.println(", Return Date: " + rs.getString("return_date"));
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DatabaseOperations.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

}