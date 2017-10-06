package warGame;

import java.util.ArrayList;

/**
 * This class is used to log gameplay to the console
 * @author tefnick
 *
 */
public class Logger {
	
	private Game currentGame;
	private Round currentRound;
	
	

	public Logger(){}
	
	/**
	 * Logs the current play to the console
	 * @param game
	 * @param player
	 */
	public static void display(Player player, Card card){		
		System.out.println(player.getNameOfPlayer() + " plays "
				+ card.getRank() + " of " + card.getSuit() + "as up card");
	}
	
	public static void displayWinnerOfRound(Player player){
		System.out.println(player.getNameOfPlayer() + " wins the round");
	}
	
	public static void declareWar(){
		System.out.println("War!");
	}
	
	public void displayTie(){
		System.out.println("Tie");
	}
	
	public void displayScore(Round currentRound){
		System.out.print("Score is ");
		for(Player player : currentRound.getPlayers()){
			System.out.print(player.getNameOfPlayer() + " " 
					+ player.getTotalPoints() + ",");		
		}
	}
	
	public static void displayWinnerOfGame(Player player){
		System.out.println(player.getNameOfPlayer() + " wins the game!");
	}

}
