package warGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Models a particular deck of cards
 * and functions that are used in the war game
 * @author richard
 *
 */
public class Deck {
	
	private CardGroup cardDeck = new CardGroup();	
	
	/**
	 * Constructor for a new Deck
	 */
	public Deck(CardGroup cardDeck){
		this.cardDeck = cardDeck;
	}
	
	/**
	 * Distributes a card to a player
	 * @return a new Card distributed to user
	 */
	
	public Card DistributeCard(){
		Card TopOfDeckCard = cardDeck.getCardAtIndex(0);
		cardDeck.getCardDeck().remove(0);
		return TopOfDeckCard;
	}
	
	/**
	* Shuffles the deck of cards
	*/
	public void Shuffle(){
		Collections.shuffle(this.cardDeck.getCardDeck()); 
		
	}
	
	public boolean hasCards() {
		if (this.cardDeck.deckSize() > 0) {
			return true;
		}else{
			return false;
		}
	}
	
	public CardGroup getDeck() {
        return this.cardDeck; 
	}    
}
