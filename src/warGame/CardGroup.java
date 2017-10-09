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
     * Gets a card at a given index
     * @param index
     * @return a Card at that index
     */
    public Card getCardAtIndex(int index){
    	return cardDeck.get(index);
    }
    
    /**
     * Returns the size of this deck 
     * @return an int of the size of this deck
     */
    public int deckSize(){
    	return cardDeck.size(); 
    }
    
    /**
     * Prints the card deck to the console
     * @return The Card Deck
     */
    public void displayDeck() {
    	for(int i = 0; i < cardDeck.size(); i++){
    		System.out.println(cardDeck.get(i));
    	}
    }

    /**
     * Returns the card deck to use for other classes
     * @return The Card Deck
     */
	public static List<Card> getCardDeck() {
		return cardDeck;
	}
}