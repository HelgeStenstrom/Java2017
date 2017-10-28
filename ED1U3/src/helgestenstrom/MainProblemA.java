package helgestenstrom;

import java.util.ArrayList;
import java.util.Arrays;

public class MainProblemA {



    public static void main(String[] args) {
        ArrayList<String> vm = new ArrayList<String>();
        vm.add("Vilhelm Moberg");

        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Utvandrarna","987654331", 51, vm));
        books.add(new Book("Invandrarna","987654339", 54, new ArrayList<String>(Arrays.asList("Vilhem Moberg"))));
        books.add(new Book("Head First JavaScript Programming", "987xxxxxx", 372,
                new ArrayList<String>(Arrays.asList("Eric Freeman", "Elisabeth Robson"))));


        double totalPrice = 0;
        for (Book book: books) {
            totalPrice += book.getPrice();
            System.out.println(book.toString());
        }
        System.out.println("--- --- ---");
        System.out.printf("Total price: %.2f \n", totalPrice);
    }
}
