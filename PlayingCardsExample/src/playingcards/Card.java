package playingcards;

public class Card {
    private int suit;
    private int rank;

    /**
     * Creates a new card
     * @param rank
     * @param suit
     */

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     *
     * @param cardnumber represents a card. 0 is 2 of clubs, 13 is 2 of diamonds.
     */

    public Card(int cardnumber) {
        this.rank = cardnumber % 13;
        this.suit = (cardnumber/13) % 4;
    }

    @Override
    public String toString() {
        String ranks = "23456789TJQKA";
        String suits = "\u2663\u2666\u2665\u2660"; // "CDHS"
        return ranks.charAt(rank) + "" + suits.charAt(suit);
    }

    public int rank() {
        return this.rank;
    }
}
