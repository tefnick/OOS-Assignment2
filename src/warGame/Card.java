package warGame;

import java.util.*;
import java.awt.List;

public class Card {
	
    public enum Rank { TWO, THREE, FOUR, FIVE, SIX,
        SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE }

    public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }

    private final Rank rank;
    private final Suit suit;
    
    /**
     * Constructor
     * @param rank, Rank type of this card
     * @param suit, Suit type of this card
     */
    private Card(Rank rank, Suit suit) {
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
     * Converts the card Rank and Suit to a String literal
     * Example: "JACK of DIAMONDS" or "TEN of HEARTS"
     * @return String representation of this card
     */
    public String toString() { 
    	return rank + " of " + suit; 
    }
}