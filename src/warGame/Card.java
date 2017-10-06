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
    private int Value;
    
    /**
     * Constructor is visible only to the current package
     * @param rank, Rank type of this card
     * @param suit, Suit type of this card
     */
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
        SettingValue();
    }
  
    /**
     * 
     * @return
     */
    public Rank getRank() { 
    	return rank; 
    }
    
    /**
     * 
     * @return
     */
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

    
    public int getValue(){
    	return this.Value;
    }
    /**
     * 
     */
    private void SettingValue(){
    	switch(this.rank){
    	case TWO:
    		this.Value = 2;
    		return;
    	case THREE:
    		this.Value = 3;
    		return;
    	case FOUR:
    		this.Value = 4;
    		return;
    	case FIVE:
    		this.Value = 5;
    		return;
    	case SIX:
    		this.Value = 6;
    		return;
    	case SEVEN:
    		this.Value = 7;
    		return;
    	case EIGHT:
    		this.Value = 8;
    		return;
    	case NINE:
    		this.Value = 9;
    		return;
    	case TEN:
    		this.Value = 10;
    		return;
    	case JACK:
    		this.Value = 11;
    		return;
    	case QUEEN:
    		this.Value = 12;
    		return;
    	case KING:
    		this.Value = 13;
    		return;
    	default:
    		this.Value = 14;
    		return;
    	}
    
    }

}