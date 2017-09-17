package playingcardsrun;

import playingcards.*;

public class PlayingCardsRun {

    /**
     *
     * @param args the command line arguments
     */

    public static void main(String[] args) {
    Card c = new Card(Ranks.EIGHT, Suits.DIAMONDS);
    Card d = new Card(26);

    System.out.println(c);
    System.out.println(d);
    }
}
