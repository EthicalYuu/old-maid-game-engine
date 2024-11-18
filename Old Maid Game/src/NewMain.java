import java.util.ArrayList;

public class NewMain{
    public static void main(String[] args) {
        DeckFactory deckFactory = new DeckFactory();
        ArrayList<Card> cardList = deckFactory.getStandardDeck();
        System.out.println(cardList.size());
        for(Card card: cardList){
            System.out.println(card);
        }
    }
}