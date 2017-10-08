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

		getWarMethod(getInput);
		// could call populatePlayers(getInput);
		players = new ArrayList<Player>();
		for (int i = 0; i < numOfPlayers; i++) {
			// do {
			System.out.println("Please enter the name of player " + (i + 1) + ": ");

			// Player player; //= new Player(getInput.nextLine());
			// player.setNameOfPlayer(getInput.nextLine());
			String playerName = "";

			// if(getInput.hasNextLine()) {
			while (playerName.isEmpty()) {
				playerName = getInput.nextLine();
				// }
			}
			Player player = new Player(playerName);
			players.add(player);

			System.out.println("Player " + (i + 1) + " will be " + players.get(i).getNameOfPlayer() + "\n");

		} // while();

		getInput.close();
		// round(playerArray, numOfPrizes, numOfIterations);
		CardGroup deckOfCards = new CardGroup();
		// deckOfCards.displayDeck();
		Deck deck = new Deck(deckOfCards);

		// Collections.shuffle(deck.getDeck().displayDeck());
		deck.Shuffle();
		// deckOfCards.displayDeck();

		while (deck.hasCards()) {
			for (Player player : players)
				player.InvokeDraw(deck.DistributeCard());
		}

		// get deck
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
			numOfPlayers = 2;
			System.out.println("The number of players for version A and B is always 2.");
			System.out.println("How many iterations should be played this game: ");
			numOfIterations = getInput.nextInt();
			if (numOfIterations > 50) {
				numOfIterations = maxIterations;
			}
		} else {
			System.out.println("Please enter the number of players: ");
			numOfPlayers = getInput.nextInt();
			if (numOfPlayers > 3) {
				numOfPlayers = 3;
			}
		}
		System.out.println("Please enter the number of prizes in a war: ");
		numOfPrizes = getInput.nextInt();
	}

	public static String getVariation() {
		return variationForGame;
	}

	/*
	 * public static void setVariation(String variation) { //enum VariationForWar =
	 * variation; for(variation VariationForWar : values()) {
	 * if(VariationForWar.toString().equals(variation)) { VariationForWar =
	 * VariationForWar; } } }
	 */
	public static void setVariation(String variation) {
		variationForGame = variation;
		if (!variationForGame.equals("A") && !variationForGame.equals("B") && !variationForGame.equals("C")) {
			variationForGame = "A";
		}
	}
}
