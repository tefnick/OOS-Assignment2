package warGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//import warGame.Round.variation;

/**
 * 
 * @author Justin
 *
 */
public class Game {
	private static int numOfPlayers;
	private static int numOfPrizes;
	private static int numOfIterations;
	private static String variationForGame;
	private static ArrayList<Player> players;
	private static final int maxIterations = 50;

	public static void main(String[] args) {
		Scanner getInput = new Scanner(System.in);
		players = new ArrayList<Player>();
		getWarMethod(getInput);
		getPlayersList(getInput);
		getInput.close();
		CardGroup deckOfCards = new CardGroup();
		Deck deck = new Deck(deckOfCards);
		deck.Shuffle();
		while (deck.hasCards() == true) {
			for (Player player : players) {
				if(deck.hasCards() == true) {
					player.InvokeDraw(deck.DistributeCard());
				}else break;
			}
		}
		// start round
		Round startGame = new Round(players, numOfPrizes, numOfIterations, variationForGame);
		Player gameWinner = startGame.gameStart();
		Logger.displayWinnerOfGame(gameWinner);
		return;
	}

	

	private static void getWarMethod(Scanner getInput) {
		System.out.println("What variation(A, B, C):  ");
		String variation = getInput.next().toUpperCase();
		setVariation(variation);
		if (getVariation().equals("A") || getVariation().equals("B")) {
			setNumOfPlayers(2);
			System.out.println("The number of players for version A and B is always 2.");
			if(getVariation().equals("A") ) {
				System.out.println("How many iterations should be played this game: ");
				numOfIterations = getInput.nextInt();
			}
			if (numOfIterations > 50) {
				numOfIterations = maxIterations;
			}
		} else {
			System.out.println("Please enter the number of players: ");
			setNumOfPlayers(getInput.nextInt());
			if (getNumOfPlayers() > 3) {
				setNumOfPlayers(3);
			}
		}
		System.out.println("Please enter the number of prizes in a war: ");
		setNumOfPrizes(getInput.nextInt());
	}
	
	private static void getPlayersList(Scanner getInput) {
		for (int i = 0; i < numOfPlayers; i++) {
			System.out.println("Please enter the name of player " + (i + 1) + ": ");
			String playerName = "";
			while (playerName.isEmpty()) {
				playerName = getInput.nextLine();
			}
			Player player = new Player(playerName);
			addPlayers(player);
			System.out.println("Player " + (i + 1) + " will be " + players.get(i).getNameOfPlayer() + "\n");
		}
	}
	
	public static String getVariation() {
		return variationForGame;
	}

	public static void setVariation(String variation) {
		variationForGame = variation;
		if (!variationForGame.equals("A") && !variationForGame.equals("B") && !variationForGame.equals("C")) {
			variationForGame = "A";
		}
	}
	
	public static int getNumOfPlayers() {
		return numOfPlayers;
	}

	public static void setNumOfPlayers(int numOfPlayers) {
		Game.numOfPlayers = numOfPlayers;
	}
	
	public static int getNumOfIterations() {
		return numOfIterations;
	}

	public static void setNumOfIterations(int numOfIterations) {
		Game.numOfIterations = numOfIterations;
	}
	
	public static ArrayList<Player> getPlayers() {
		return players;
	}

	public static void addPlayers(Player player) {
		Game.players.add(player);
	}
	
	public static int getNumOfPrizes() {
		return numOfPrizes;
	}

	public static void setNumOfPrizes(int numOfPrizes) {
		Game.numOfPrizes = numOfPrizes;
	}
}
