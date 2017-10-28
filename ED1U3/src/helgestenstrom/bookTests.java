package helgestenstrom;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class bookTests {
    @Test
    public void createAndGetFields() throws Exception {
        // Setup
        ArrayList<String> author = new ArrayList<String>();
        author.add("Tage Danielsson");
        Book b = new Book("Bok", "1234-56", 149.50, author);

        // Verify
        assertEquals("Bok", b.getName());
        assertEquals("1234-56", b.getIsbn());
        assertEquals( "nästan samma pris", 149.5, b.getPrice(), 0.01 );
        assertEquals("Tage Danielsson", b.getAuthors().get(0));
    }

    @Test
    public void stringRepresentation() throws Exception {
        // Setup
        ArrayList<String> author = new ArrayList<String>();
        author.add("Tage Danielsson");
        author.add("Unknown");
        Book b = new Book("Bok", "1234-56", 149.50, author);

        // Verify
        String exp = "[name=Bok, ISBN=1234-56, price=149,50, authors=[Tage Danielsson, Unknown]]";
        assertEquals(exp, b.toString());
    }

    @Test
    public void commaSeparatedEmptyList() throws Exception {
        // Setup
        ArrayList<String> l = new ArrayList<String>();

        // Verify
        assertEquals("", Book.commaSep(l));
    }

    @Test
    public void commaSeparatedOneItem() throws Exception {
        // Setup
        ArrayList<String> l = new ArrayList<String>();
        l.add("aa");

        // Verify
        assertEquals("aa", Book.commaSep(l));
    }
    @Test
    public void commaSeparatedTwoItems() throws Exception {
        // Setup
        ArrayList<String> l = new ArrayList<String>();
        l.add("aa");
        l.add("bb");

        // Verify
        assertEquals("aa, bb", Book.commaSep(l));
    }

    @Test
    public void createBookWithSingelAuthorString() throws Exception {
        Book b = new Book("name", "isbn", 1.1, "Author");
    }


}


