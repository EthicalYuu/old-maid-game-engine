import java.util.ArrayList;
import java.util.List;

public class Game {
    private final ArrayList<Player> players;

    private final TurnManager turnManager;

    private final PlayerFactory playerFactory;

    private final DeckManager deckManager;

    public Game(int noPlayers) {
        turnManager = new TurnManager();
        deckManager = new DeckManager(DeckFactory.getStandardDeck());
        playerFactory = new PlayerFactory(turnManager, noPlayers, deckManager);
        this.players = playerFactory.getPlayers();
        turnManager.setPlayers(players);
    }
    public void startGame() {
        for (Player player : players) {
            player.start();
        }
    }
}