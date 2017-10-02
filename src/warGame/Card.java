package warGame;

public class Card {
	
	private final int cardValue; 
	private final int cardSuit; 
							
	/**
	 * Constructor for card with a given value and suit
	 * @param cardValue, an integer between 1 and 13
	 * @param cardSuit, an integer between 0 and 3
	 */
	public Card(int cardValue, int cardSuit) {
		this.cardValue = cardValue;	//Question: Should we randomize a card value when it gets initialized?
		this.cardSuit = cardSuit;   //			instead of hard coding it?
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
				return "INVALID CARD VALUE";
		}
	}

	public String convertCardSuitToString() {
		
		switch (cardSuit) {
			case 0:
				return "SPADES";
			case 1:
				return "HEARTS";
			case 2:
				return "DIAMONDS";
			case 3:
				return "CLUBS";
			default:
				return "INVALID CARD SUIT";
		}
	}

	/**
	 * Displays a String representation of this card
	 * in the format "TEN of HEARTS, JACK of DIAMONDS"
	 */
	public String displayCard() {
		return convertCardValueToString() + " of " + convertCardSuitToString();
	}
}