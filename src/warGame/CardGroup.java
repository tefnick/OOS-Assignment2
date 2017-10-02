package warGame;
import java.util.ArrayList;

/**
 *  makes the deck of cards 
 *  I borrowed some ideas from 
 */
public class CardGroup {
	
	private static final int numberOfCards = 52;
	private ArrayList<Card> cards;
	private int currentSize;
	private int i, suit, rank;
	
	/**
	 * I borrowed some ideas from here in the constructor
	 * http://www.mathcs.emory.edu/~cheung/Courses/170/Syllabus/10/deck-of-cards.html
	 * TODO: this needs review
	 */
	public CardGroup(){
		this.cards = new ArrayList<Card>(numberOfCards); //initialize arrayList with max # of cards
		//initialize the deck with all card suites "i" and ranks "j"
		for(int i = 0; i <= 3; i++ ){
			for(int j = 0; j <= 13; j++){
				cards.add(new Card(i, j));
			}
		}
	}
	
	/**
	 * Add card to the card group
	 * @param card
	 */
	public void addCard(Card card){
		cards.add(new Card(1, 0)); //hard coded values 1, 0 for ACE of SPADES
		currentSize++; //do we need this variable when we can use cards.size() ?
	}
}
/*Example deck of cards
 * import java.util.Random;

public class DeckOfCards
{
   private Card deck[]; // array of Card objects
   private int currentCard; // index of next Card to be dealt
   private final int NUMBER_OF_CARDS = 52; // constant number of Cards
   private Random randomNumbers; // random number generator

   // constructor fills deck of Cards
   public DeckOfCards()
   {
      String faces[] = { "Ace", "Deuce", "Three", "Four", "Five", "Six", 
         "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
      String suits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };

      deck = new Card[ NUMBER_OF_CARDS ]; // create array of Card objects
      currentCard = 0; // set currentCard so first Card dealt is deck[ 0 ]
      randomNumbers = new Random(); // create random number generator

      // populate deck with Card objects
      for ( int count = 0; count < deck.length; count++ ) 
         deck[ count ] = 
            new Card( faces[ count % 13 ], suits[ count / 13 ] );
   } // end DeckOfCards constructor

   // shuffle deck of Cards with one-pass algorithm
   public void shuffle()
   {
      // after shuffling, dealing should start at deck[ 0 ] again
      currentCard = 0; // reinitialize currentCard

      // for each Card, pick another random Card and swap them
      for ( int first = 0; first < deck.length; first++ ) 
      {
         // select a random number between 0 and 51 
         int second =  randomNumbers.nextInt( NUMBER_OF_CARDS );
         
         // swap current Card with randomly selected Card
         Card temp = deck[ first ];        
         deck[ first ] = deck[ second ];   
         deck[ second ] = temp;            
      } // end for
   } // end method shuffle

   // deal one Card
   public Card dealCard()
   {
      // determine whether Cards remain to be dealt
      if ( currentCard < deck.length )
         return deck[ currentCard++ ]; // return current Card in array
      else        
         return null; // return null to indicate that all Cards were dealt
   } // end method dealCard
} // end class DeckOfCards


/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 **********************************************
*/