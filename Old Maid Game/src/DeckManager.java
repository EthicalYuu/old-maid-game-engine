import java.util.ArrayList;

public class DeckManager {
    private ArrayList<Card> gameDeck;
    public DeckManager(ArrayList<Card> gameDeck){
        this.gameDeck = gameDeck;
    }

    public synchronized ArrayList<Card> drawCards(int noCards) {
        ArrayList<Card> discardedCards = new ArrayList<>();
        for (int i = 0; i < noCards; i++) {
            Card discarded = gameDeck.remove(gameDeck.size() - 1);
            discardedCards.add(discarded);
        }
        return discardedCards;
    }

    public ArrayList<Card> getGameDeck(){
        return gameDeck;
    }

}
