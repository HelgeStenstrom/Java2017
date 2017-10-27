package helgestenstrom;

import java.util.ArrayList;
import java.util.Iterator;

public class Book {
    private String name;
    private String isbn;
    private double price;
    private ArrayList<String> authors;

    public Book(String name, String isbn, double price, ArrayList<String> authors) {
        this.name = name;
        this.isbn = isbn;
        this.price = price;
        this.authors = authors;
    }

    public String getName() {
        return name;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }


    @Override
    public String toString() {


        String rep = String.format("[name=%s, ISBN=%s, price=%.2f, authors=[%s]]",
                name, isbn, price, authorList());
        return rep;
    }

    private String authorList() {
        return commaSep(authors);
    }

    public static String commaSep(ArrayList<String> lst) {
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
