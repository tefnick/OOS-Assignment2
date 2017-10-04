package warGame;

import java.util.Collections;
import java.util.Random;

/**
 * 
 * @author richard
 *
 */
public class Deck {
	
	private CardGroup DeckOfCards;
	
	/**
	 * 
	 */
	public Deck(CardGroup DeckOfCards){
		DeckOfCards = DeckOfCards;
	}
	
	public Card DistributeCard(){
		Card TopOfDeckCard = CardGroup.displayDeck().get(0);
		CardGroup.displayDeck().remove(0);
		return TopOfDeckCard;
	}
	
	public void Shuffle(){
		Collections.shuffle(DeckOfCards.displayDeck()); // :)
	}
}
