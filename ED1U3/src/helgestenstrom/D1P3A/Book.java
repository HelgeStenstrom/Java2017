/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom.D1P3A;

import java.util.ArrayList;
import java.util.Iterator;

public class Book {
    private String name;
    private String isbn;
    private double price;
    private ArrayList<String> authors;

    Book(String name, String isbn, double price, ArrayList<String> authors) {
        // Standard constructor
        this.name = name;
        this.isbn = isbn;
        this.price = price;
        this.authors = authors;
    }

    Book(String name, String isbn, double price, String author) {
        // Alternative constructor, simpler if there is only one author.
        this.name = name;
        this.isbn = isbn;
        this.price = price;

        ArrayList<String> auth = new ArrayList<>();
        auth.add(author);
        this.authors = auth;
        }


    // Getters (they do what their names suggest)
    String getName() {
        return name;
    }

    String getIsbn() {
        return isbn;
    }

    double getPrice() {
        return price;
    }

    ArrayList<String> getAuthors() {
        return authors;
    }


    @Override
    public String toString() {
        // String representation of the book.
        return String.format("[name=%s, ISBN=%s, price=%.2f, authors=[%s]]",
                name, isbn, price, authorList());
    }

    private String authorList() {
        // Utility method to get a comma separated list of authors.
        return commaSep(authors);
    }

    static String commaSep(ArrayList<String> lst) {
        // Create a comma separated list as a string, of any ArrayList of strings.
        if (lst.isEmpty())
                return "";

        Iterator<String> iter = lst.iterator();
        String collector = iter.next();
        while(iter.hasNext()) {
            collector += ", ";
            collector += iter.next();
        }

        return collector;
    }
}
