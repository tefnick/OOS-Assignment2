package warGame;

import java.util.ArrayList;

/**
 * 
 * @author Richard A. Bravo
 *
 */
public class Hand {

	private ArrayList<Card> CurrentHand;
	
	public Hand(){
	     CurrentHand = new ArrayList<Card>();
	}
	
	public Card PlayCard(){
		Card card = CurrentHand.get(0);
		CurrentHand.remove(0);
		return card;
	}
	
	public void DrawCards(Card card){
		CurrentHand.add(card);
	}
	
	
	
	
	
}
