package warGame;

public interface War {
	/**
	 * 
	 * @param Cards
	 */
	void WarCompareCards(Card[] Cards);//compareCards function is in round
	
	/**
	 * 
	 * @return
	 */
	Player WinnerOfWar();
}
