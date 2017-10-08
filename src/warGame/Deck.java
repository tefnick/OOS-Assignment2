package warGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 
 * @author richard
 *
 */
public class Deck {
	
	//private CardGroup DeckOfCards;
	private CardGroup cardDeck = new CardGroup();	
	
	/**
	 * 
	 */
	public Deck(CardGroup cardDeck){
		this.cardDeck = cardDeck;
	}
	
	/**
	 * 
	 * @return
	 */
	//@SuppressWarnings("static-access")
	public Card DistributeCard(){
		Card TopOfDeckCard = cardDeck.getCardAtIndex(0);
		cardDeck.displayDeck().remove(0);
		return TopOfDeckCard;
	}
	
	/**
	 * 
	 */
	//@SuppressWarnings("static-access")
	public void Shuffle(){
		Collections.shuffle(this.cardDeck.displayDeck()); // :)
		
	}
	
	public boolean hasCards() {
		if (this.cardDeck.deckSize() > 0) {
			return true;
		}else {
			return false;
		}
	}
	public CardGroup getDeck() {
        return this.cardDeck; 
    }
    
}
