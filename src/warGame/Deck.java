package warGame;

import java.util.Collections;


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
	@SuppressWarnings("static-access")
	public Card DistributeCard(){
		Card TopOfDeckCard = cardDeck.getCardAtIndex(0);
		cardDeck.displayDeck().remove(0);
		return TopOfDeckCard;
	}
	
	/**
	 * 
	 */
	@SuppressWarnings("static-access")
	public void Shuffle(){
		Collections.shuffle(cardDeck.displayDeck()); // :)
	}
}
