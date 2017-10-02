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
	
	public int getCardSuit(){
		return this.cardSuit;
	}
	
	public int getCardValue(){
		return this.cardValue;
	}

	/**
	 * Displays a String representation of this card
	 * in the format "TEN of HEARTS, JACK of DIAMONDS"
	 */
	public String displayCard() {
		return convertCardValueToString() + " of " + convertCardSuitToString();
	}
}


//import java.util.*;
//
//public class Card {
//    public enum Rank { DEUCE, THREE, FOUR, FIVE, SIX,
//        SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE }
//
//    public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }
//
//    private final Rank rank;
//    private final Suit suit;
//    private Card(Rank rank, Suit suit) {
//        this.rank = rank;
//        this.suit = suit;
//    }
//
//    public Rank rank() { return rank; }
//    public Suit suit() { return suit; }
//    public String toString() { return rank + " of " + suit; }
//
//    private static final List<Card> protoDeck = new ArrayList<Card>();
//
//    // Initialize prototype deck
//    static {
//        for (Suit suit : Suit.values())
//            for (Rank rank : Rank.values())
//                protoDeck.add(new Card(rank, suit));
//    }
//
//    public static ArrayList<Card> newDeck() {
//        return new ArrayList<Card>(protoDeck); // Return copy of prototype deck
//    }
//}