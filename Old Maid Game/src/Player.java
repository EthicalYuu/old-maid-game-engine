import java.util.*;

public class Player extends Thread {
    private final int playerId;
    private ArrayList<Card> handCards;

    private final TurnManager turnManager;

    private final DeckManager deckManager;

    private int noCards;


    public Player(int playerId, TurnManager turnManager, int noCards, DeckManager deckManager) {
        this.handCards = new ArrayList<>();
        this.noCards = noCards;
        this.playerId = playerId;
        this.turnManager = turnManager;
        this.deckManager = deckManager;
    }

    public Card getRandomCard(ArrayList<Card> cardList) {
        int rnd = new Random().nextInt(cardList.size());
        return cardList.remove(rnd);
    }


    public synchronized void discardMatches(){

        boolean sameColor;
        boolean sameValue;

        ArrayList<Card> toRemove = new ArrayList<>();
        for(int i = 0; i<handCards.size() ;i++){
            for(int j = i+1; j<handCards.size() ;j++){
                sameColor = handCards.get(i).getColor().equals(handCards.get(j).getColor());
                sameValue = handCards.get(i).getRank().equals(handCards.get(j).getRank());
                if(sameColor && sameValue){
                    toRemove.add(handCards.get(i));
                    toRemove.add(handCards.get(j));
                }
            }
        }

        for(Card card: toRemove){
            handCards.remove(card);
            System.out.println("Card " + card + " matched so it was removed...");
        }
    }

    public synchronized void terminateAndNotify(){
        System.out.println("Player " + playerId + " is out");
        turnManager.terminateCurrentPlayer();
        turnManager.notifyAll();
    }

    @Override
    public void run() {
        try {
            synchronized (turnManager) {

                while (turnManager.getCurrentPlayer() != this) {
                    turnManager.wait();
                }

                System.out.println("Player " + playerId + " Drawing Cards");
                handCards = deckManager.drawCards(noCards);
                System.out.println("Drawn Cards " + handCards.toString());
                System.out.println("-----------------------------------------");

                turnManager.nextTurn();
                turnManager.notifyAll();

                while (turnManager.getCurrentPlayer() != this) {
                    turnManager.wait();
                }

                System.out.println("-----------------------------------------");
                System.out.println("Player " + playerId + " is discarding matches");
                discardMatches();
                System.out.println("-----------------------------------------");

                if(handCards.isEmpty()){
                    terminateAndNotify();
                }

                turnManager.nextTurn();
                turnManager.notifyAll();

                while(true){

                    while (turnManager.getCurrentPlayer() != this) {
                        turnManager.wait();
                    }

                    System.out.println("-----------------------------------------");
                    System.out.println("Player " + playerId + " is in the game.");
                    System.out.println("List Before: " + handCards.toString());

                    if(turnManager.getPassedCard() != null){
                        System.out.println("Player " + playerId + " took " + turnManager.getPassedCard() + " from prev player");
                        handCards.add(turnManager.getPassedCard());
                    }

                    discardMatches();
                    turnManager.setPassedCard(null);

                    if(turnManager.getRemainingNoPlayers() == 1 &&
                            handCards.size() == 1){
                        System.out.println("Player " + playerId + " is the old maid!");
                        break;
                    }

                    System.out.println("List After: " + handCards.toString());
                    if(handCards.isEmpty()){
                        terminateAndNotify();
                        break;
                    }

                    Card randomCard = getRandomCard(handCards);

                    System.out.println("Player " + playerId + " gives " + randomCard + " card to the next player");
                    turnManager.setPassedCard(randomCard);
                    handCards.remove(randomCard);

                    if(handCards.isEmpty()){
                        terminateAndNotify();
                        break;
                    }

                    Thread.sleep(100);

                    System.out.println("------------------------------------------");

                    turnManager.nextTurn();
                    turnManager.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted!");
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String toString() {
        return "Player " + playerId;
    }
}
