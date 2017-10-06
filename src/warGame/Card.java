package warGame;

/**
 * Basic model of a Card object.
 * Declares enums for Rank and Suit and a toString method
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
    public int assignRankValue(){
    	int value;
    	switch(rank){
    	case TWO:
    		value = 2;
    		break;
    	case THREE:
    		value = 3;
    		break;
    	case FOUR:
    		value = 4;
    		break;
    	case FIVE:
    		value = 5;
    		break;
    	case SIX:
    		value = 6;
    		break;
    	case SEVEN:
    		value = 7;
    		break;
    	case EIGHT:
    		value = 8;
    		break;
    	case NINE:
    		value = 9;
    		break;
    	case TEN:
    		value = 10;
    		break;
    	case JACK:
    		value=11;
    		break;
    	case QUEEN:
    		value = 12;
    		break;
    	case KING:
    		value= 13;
    		break;
    	case ACE:
    		value =14;
    		break;
    	}
		return 0;
    	
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