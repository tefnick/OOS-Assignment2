package warGame;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class WarVariationA implements War {
	/**
	 * 
	 */
	Player[] Players;
	
	/**
	 * 
	 */
	Player WinnerOfWar;
	
	/**
	 * 
	 */
	ArrayList<Card> Cards = new ArrayList<Card>();
	
	
	/**
	 * 
	 * @param Players
	 */
	public WarVariationA(Player[] Players){
		Players = Players;
	}
	
	/**
	 * 
	 * @param Cards
	 */
	public void WarCompareCards(LinkedHashMap<Player, Card.Rank> PlayersAndPlayedCards){
		
	}
	
	/**
	 * 
	 * @return
	 */
	public Player WinnerOfWar(){
		return this.WinnerOfWar;
	}
}
