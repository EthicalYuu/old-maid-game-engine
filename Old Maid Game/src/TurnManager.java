import java.util.ArrayList;

public class TurnManager {

    private ArrayList<Player> players;
    private Card passedCard = null;
    private int turnIndex;

    public TurnManager() {
        turnIndex = 0;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }


    public synchronized void nextTurn() {
        turnIndex = (turnIndex + 1) % players.size();
    }

    public synchronized void terminateCurrentPlayer() {
        players.remove(turnIndex);
        if (turnIndex == 0) {
            turnIndex = players.size() - 1;
        } else {
            turnIndex--;
        }
    }

    public synchronized Player getCurrentPlayer() {
        return players.get(turnIndex);
    }

    public synchronized int getRemainingNoPlayers(){
        return players.size();
    }

    public synchronized Card getPassedCard() {
        return passedCard;
    }

    public synchronized void setPassedCard(Card passedCard) {
        this.passedCard = passedCard;
    }


}