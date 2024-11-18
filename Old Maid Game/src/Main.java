import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of players");

        try{

            int noPlayers = scanner.nextInt();
            while(noPlayers > 12 || noPlayers < 2){
                System.out.println("Invalid number of players");
                noPlayers = scanner.nextInt();
            }

            Game game = new Game(noPlayers);
            game.startGame();

        } catch (InputMismatchException e){
            System.out.println("Incorrect number format");
        }

    }
}