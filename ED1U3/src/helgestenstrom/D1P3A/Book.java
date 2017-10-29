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
        this.name = name;
        this.isbn = isbn;
        this.price = price;
        this.authors = authors;
    }

    Book(String name, String isbn, double price, String author) {
        ArrayList<String> auth = new ArrayList<String>();
        auth.add(author);
         new   Book(name, isbn, price, auth);
    }

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
        return String.format("[name=%s, ISBN=%s, price=%.2f, authors=[%s]]",
                name, isbn, price, authorList());
    }

    private String authorList() {
        return commaSep(authors);
    }

    static String commaSep(ArrayList<String> lst) {
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
