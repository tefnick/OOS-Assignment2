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

}
