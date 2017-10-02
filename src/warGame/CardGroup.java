package warGame;

import java.util.ArrayList;

public class CardGroup {
	
	private ArrayList<Card> cards;
	private int currentSize;
	
	public CardGroup(){
		this.cards = new ArrayList<Card>();
		this.currentSize = cards.size();
	}
	
	/**
	 * Add card to the card group
	 * @param card
	 */
	public void addCard(Card card){
		cards.add(new Card(1, 0)); //hard coded values 1, 0 for ACE of SPADES
		currentSize++; //do we need this variable when we can use cards.size() ?
	}
}

