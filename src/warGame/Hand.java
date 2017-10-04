package warGame;

import java.util.ArrayList;

/**
 * 
 * @author Richard A. Bravo
 *
 */
public class Hand {
	//Variables for CurrentHand
	private ArrayList<Card> CurrentHand;
	

	/**
	 * 
	 */
	public Hand(){
	    CurrentHand = new ArrayList<Card>();
	}
	
	/**
	 * 
	 * @return
	 */
	public Card PlayCard(){
		Card card = CurrentHand.get(0);
		CurrentHand.remove(0);
		return card;
	}
	
	/**
	 * 
	 * @param card
	 */
	public void DrawCard(Card card){
		CurrentHand.add(card);
	}
		
}
