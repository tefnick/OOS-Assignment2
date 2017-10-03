package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import warGame.Card;
import warGame.Card.Rank;
import warGame.Card.Suit;
import warGame.CardGroup;

import org.junit.Test;

public class CardTest {
	
	@Test
	public void cardsAreAbletoInitialize(){
		int deckSize = 52;
		int i;
		List<Card> cardDeck = new ArrayList<Card>(deckSize);
		for(i = 0; i < deckSize; i++)
			cardDeck.add(new Card(Rank.ACE, Suit.CLUBS)); 
		
		assertEquals("Deck size is not 52!", 52, cardDeck.size());		
	}

}
