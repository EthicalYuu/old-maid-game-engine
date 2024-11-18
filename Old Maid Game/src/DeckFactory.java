import java.util.ArrayList;
import java.util.Collections;
public class DeckFactory {
    private static ArrayList<Card> deck;

    public DeckFactory(){
        deck = new ArrayList<>();
    }

    public static ArrayList<Card> getStandardDeck(){
        ArrayList<Card> standardDeck = new ArrayList<>();
        for(Rank rank: Rank.values()){
            if(rank != Rank.JOKER){
                standardDeck.add(new Card(Color.RED, rank, Suit.DIAMOND));
                standardDeck.add(new Card(Color.RED, rank, Suit.HEART));
                standardDeck.add(new Card(Color.BLACK, rank, Suit.CLUB));
                standardDeck.add(new Card(Color.BLACK, rank, Suit.SPADE));
            }
        }
        standardDeck.add(new Card(Color.JOKER, Rank.JOKER, Suit.JOKER));
        Collections.shuffle(standardDeck);
        return standardDeck;
    }


}
