package warGame;

import java.util.ArrayList;

public interface War {
	/**
	 * 
	 * @param Cards
	 */
	void WarCompareCards(ArrayList<Player> players);//compareCards function is in round
	
	/**
	 * 
	 * @return
	 */
	Player WinnerOfWar();
}
