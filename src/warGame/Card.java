package warGame;

public class Card {

	/* Codes for the 4 suits.*/
	public final static int SPADES = 0, 
							HEARTS = 1, 
							DIAMONDS = 2, 
							CLUBS = 3;

	/* constant values for non numeric card values */
	public final static int ACE = 1, 
							JACK = 11, 
							QUEEN = 12, 
							KING = 13;
	
	/* suit of the card, which will use one of the constants
	 * 0 = SPADES, 1 = HEARTS, 2 = DIAMONDS, or 3 = CLUBS */
	private final int cardSuit; 
							
	/* value of the card */
	private final int cardValue; 

	/**
	 * Constructor for card with a given value and suit
	 * @param cardValue an integer between 1 and 13
	 * @param cardSuit an integer between 0 and 3
	 */
	public Card(int cardValue, int cardSuit) {
		this.cardValue = cardValue;
		this.cardSuit = cardSuit;
	}

	public String convertCardValueToString() {
		
		switch (cardValue) {
			case 1:
				return "ACE";
			case 2:
				return "TWO";
			case 3:
				return "THREE";
			case 4:
				return "FOUR";
			case 5:
				return "FIVE";
			case 6:
				return "SIX";
			case 7:
				return "SEVEN";
			case 8:
				return "EIGHT";
			case 9:
				return "NINE";
			case 10:
				return "TEN";
			case 11:
				return "JACK";
			case 12:
				return "QUEEN";
			case 13:
				return "KING";
			default:
				return "INVALID VALUE";
		}
	}

	public String convertCardSuitToString() {
		
		switch (cardSuit) {
			case SPADES:
				return "SPADES";
			case HEARTS:
				return "HEARTS";
			case DIAMONDS:
				return "DIAMONDS";
			case CLUBS:
				return "CLUBS";
			default:
				return "INVALID SUIT";
		}
	}

	/**
	 * Returns a String representation of this card.
	 * in the format "TEN of HEARTS, JACK of DIAMONDS"
	 */
	public String toString() {
		return convertCardValueToString() + " of " + convertCardSuitToString();
	}
}