package warGame;

import java.util.ArrayList;

/**
 * This class is used to log gameplay to the console
 * 
 * @author tefnick
 *
 */
public class Logger {

	public Logger() {
	}

	/**
	 * Logs the current play to the console
	 * 
	 * @param game
	 * @param player
	 */
	public static void displayUpCard(Player player, Card card) {
		System.out.println(
				player.getNameOfPlayer() + " plays " + card.getRank() + " of " + card.getSuit() + " as up card");
	}

	public static void displayWinnerOfRound(Player player) {
		System.out.println(player.getNameOfPlayer() + " wins the round");
	}

	public static void declareWar() {
		System.out.println("War!");
	}

	public static void displayTie() {
		System.out.println("Tie");
	}

	public static void displayScore(ArrayList<Player> players) {
		System.out.print("Score is ");
		for (Player player : players) {
			System.out.print(player.getNameOfPlayer() + " " + player.getTotalPoints() + ", ");
		}
		System.out.println();
	}

	public static void displayWinnerOfGame(Player player) {
		System.out.println(player.getNameOfPlayer() + " wins the game!");
	}

	public static void displayWinnerOfGameTie(Player player1, Player player2) {
		System.out.println("The game ended in a tie between " + player1.getNameOfPlayer() + " and "
				+ player2.getNameOfPlayer() + "!");
	}

	public static void displayAScore(ArrayList<Player> players) {
		System.out.print("Number of cards in hand is ");
		for (Player player : players) {
			System.out.print(player.getNameOfPlayer() + " " + player.getHandOfPlayer().getNumberOfCards() + ", ");
		}
	}
}
