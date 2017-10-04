package warGame;

import java.util.ArrayList;
import java.util.List;
import warGame.Card.Suit;
import warGame.Card.Rank;

public class CardGroup{
	
	/*Traditional deck size of 52 but can be changed 
	 *for testing purposes*/
	private static final int deckSize = 52; 
	private static final List<Card> cardDeck = new ArrayList<Card>(deckSize);
	
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
    
    public Card getCardAtIndex(int index){
    	return cardDeck.get(index);
    }
    
    public int deckSize(){
    	return cardDeck.size(); 
    }
    
    /**
     * Returns the card deck to use for other classes
     * @return The Card Deck
     */
    public static ArrayList<Card> displayDeck() {
        return new ArrayList<Card>(cardDeck); 
    }
}