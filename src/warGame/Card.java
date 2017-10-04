package warGame;

/**
 * Basic model of a Card object.
 * Declares enums for Rank and Suit and a toString method
 * @author tefnick
 */
public class Card {
	
    public enum Rank { TWO, THREE, FOUR, FIVE, SIX,
        SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE }

    public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }

    private final Rank rank;
    private final Suit suit;
    
    /**
     * Constructor is visible only to the current package
     * @param rank, Rank type of this card
     * @param suit, Suit type of this card
     */
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
  
    public Rank getRank() { 
    	return rank; 
    }
    
    public Suit getSuit() { 
    	return suit; 
    }
    
    /**
     * Converts the card to a String literal
     * Example output: "JACK of DIAMONDS" or "TEN of HEARTS"
     * @return String representation of this card
     */
    public String toString() { 
    	return rank + " of " + suit; 
    }
}