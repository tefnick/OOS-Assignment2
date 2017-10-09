package warGame;

import java.util.ArrayList;

public interface War {

	/**
	 * Compare player cards when a War is in effect
	 * 
	 * @param Cards
	 */
	abstract void WarCompareCards(ArrayList<Player> players);

	/**
	 * Return the winner of the War
	 * 
	 * @return
	 */
	Player WinnerOfWar();
}
