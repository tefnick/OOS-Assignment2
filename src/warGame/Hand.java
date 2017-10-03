package warGame;

import java.util.ArrayList;

/**
 * 
 * @author richard
 *
 */
public class Hand {

	private ArrayList<Card> CurrentHand;
	
	public Hand(){
	     CurrentHand = new ArrayList<Card>();
	}
	
	public Card PlayCard(Card Card){
		return Card;
	}
	
	public void DrawCard(Card card){
		CurrentHand.add(card);
	}
	
	
	
	
	
}
