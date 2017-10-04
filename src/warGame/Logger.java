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
	public void display(Player player){		
		System.out.println(player.getNameOfPlayer() + " plays "
				+ player.getHandOfPlayer() + " as up card");
	}
	
	public void displayWinnerOfRound(Player player){
		System.out.println(player.getNameOfPlayer() + " wins the round");
	}
	
	public void declareWar(){
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
	
	public void displayWinnerOfGame(Player player){
		System.out.println(player.getNameOfPlayer() + " wins the game!");
	}

}
