package warGame;

import java.util.ArrayList;
import java.util.List;
import warGame.Card.Suit;
import warGame.Card.Rank;

/**
 * This class is used to model and initialize a set of cards.
 * By default, a traditional 52 card deck
 * @author tefnick
 *
 */
public class CardGroup{
	
	/*Traditional deck size of 52 but can be changed 
	 *for testing purposes*/
	private static final int deckSize = 52; 
	private static List<Card> cardDeck = new ArrayList<Card>();
	
	/* Initializes the Full Traditional deck once as static 
	 * to preserve the Singleton property */
    static{
        for (Suit suit : Suit.values())
            for (Rank rank : Rank.values())
                cardDeck.add(new Card(rank, suit));
    }
    
    /**
     * Adds a new card to card group
     * @param card
     */
    public void addCardToGroup(Card card){
    	cardDeck.add(card);
    }
    
    /**
     * 
     * @param index
     * @return
     */
    public Card getCardAtIndex(int index){
    	return cardDeck.get(index);
    }
    
    /**
     * 
     * @return
     */
    public int deckSize(){
    	return cardDeck.size(); 
    }
    
    /**
     * Returns the card deck to use for other classes
     * @return The Card Deck
     */
    public List<Card> displayDeck() {
        return this.cardDeck; 
    }
}