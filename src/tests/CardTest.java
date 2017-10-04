package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import warGame.Card;
import warGame.Card.Rank;
import warGame.Card.Suit;
import warGame.CardGroup;
import warGame.Game;
import warGame.Logger;
import warGame.Player;
import warGame.Round;

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

	@Test
	public void changeDeckSize(){
		int deckSize = 10;
		int i;
		List<Card> cardDeck = new ArrayList<Card>(deckSize);
		for(i = 0; i < deckSize; i++)
			cardDeck.add(new Card(Rank.ACE, Suit.CLUBS)); 
		
		assertEquals("Deck size is not 10!", 10, cardDeck.size());		
	}
	
	@Test
	public void displayAllCardsOnFullTraditionalDeck(){
		CardGroup cards = new CardGroup();	
		System.out.println("Size of Card Deck = " + cards.deckSize());
		for(int i = 0; i < cards.deckSize(); i++)
			System.out.println(cards.getCardAtIndex(i));
		assertNotNull("cards list should not be null!", cards.displayDeck());	
	}
	
	@Test
	public void testLoggerDisplayFunction(){
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Player("Nick"));
	
		Logger logger = new Logger();
		
		logger.display(players.get(0));	
		System.out.println();;
	}
		
}
