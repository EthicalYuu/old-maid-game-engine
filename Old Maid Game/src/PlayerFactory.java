import java.util.ArrayList;

public class PlayerFactory {

    private ArrayList<Player> players;

    public PlayerFactory(TurnManager turnManager, int noPlayers, DeckManager deckManager) {

        players = new ArrayList<>();

        int allCards = deckManager.getGameDeck().size();
        int singlePlayerCards = allCards / noPlayers;
        int leftOverCards = allCards % noPlayers;

        // All players get the same number of cards unless there's leftover then it goes to the last player

        for (int i = 0; i < noPlayers - 1 ; i++) {
            players.add(new Player(i + 1, turnManager, singlePlayerCards, deckManager));
        }
            players.add(new Player(noPlayers, turnManager, singlePlayerCards + leftOverCards, deckManager));
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }
}
