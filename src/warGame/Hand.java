package warGame;

import java.util.ArrayList;

/**
 * Models a hand of cards for a player
 * @author Richard A. Bravo
 *
 */
public class Hand {
	
	private ArrayList<Card> CurrentHand;
	
	/**
	 * Constructor for a hand of cards
	 */
	public Hand(){
	    CurrentHand = new ArrayList<Card>();
	}
	
	/**
	 * Plays a card from the current hand
	 * @param player
	 * @return Card, play a card from the deck
	 */
	public Card PlayCard(Player player){
		Card card = CurrentHand.get(0);
		Logger.displayUpCard(player, card);
		CurrentHand.remove(0);
		return card;
	}
	
	public Card PrizeSet(Player player) {
		Card card = CurrentHand.get(0);
		CurrentHand.remove(0);
		return card;
	}
	
	/**
	 * Draws a card from the current deck
	 * @param card
	 */
	public void DrawCard(Card card){
		CurrentHand.add(card);
	}
	
	/**
	 * Remove card from deck
	 */
	public void disCard(){
		CurrentHand.remove(0);
	}
	
	public int getNumberOfCards() {
		return CurrentHand.size();
	}
	
	/**
	 * Add a card to the deck
	 * @param card
	 */
	public void addCard(Card card) {
		CurrentHand.add(card);
	}
}
