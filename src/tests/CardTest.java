package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import warGame.Card;
import warGame.Card.Rank;
import warGame.Card.Suit;
import warGame.CardGroup;
import warGame.Game;
import warGame.Hand;
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
	}
	
	@Test
	public void testLoggerDisplayFunction(){
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Player("Nick"));
		Card card = new Card(Rank.ACE, Suit.CLUBS);
			
		Logger.displayUpCard(players.get(0),card);	
		System.out.println();;
	}
	
	@Test
	public void getVariationTest(){
		Game game = new Game();
		String variation = "A";
		game.setVariation(variation);
		
		assertEquals(variation, variation);
	}

	@Test
	public void CardRankCompareToTest(){
		Card winner = null;
		Card card1 = new Card(Rank.TWO, Suit.HEARTS);
		Card card2 = new Card(Rank.ACE, Suit.HEARTS);
		
		if(card1.getRank().compareTo(card2.getRank()) > 0){
			winner = card1;
		}else if(card1.getRank().compareTo(card2.getRank()) < 0){
			winner = card2;
		}
		else{
			Logger.displayTie();
		}
		System.out.println("Winner is " + winner);
		
	}
	
	@Test
	public void getNumberOfPlayersTest(){
		Game game = new Game();
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Player("Juan"));
		players.add(new Player("Chu"));
		players.add(new Player("Tre"));
		game.setNumOfPlayers(players.size());
		
		assertEquals(3, game.getNumOfPlayers());		
	}
	
	@Test
	public void setVariationTest(){
		Game game = new Game();
		game.setVariation("c");
		String variation = game.getVariation();
		
		assertEquals("C", variation);
	}
	
	@Test
	public void roundPLayersTest(){
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Player("Juan"));
		players.add(new Player("Chu"));
		players.add(new Player("Tre"));
		Round round = new Round(players, 3, 3, "C");
		
		assertEquals(3, round.getPlayers().size());
	}
	
	@Test
	public void displayNumberOfIterations(){
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Player("Juan"));
		players.add(new Player("Chu"));
		players.add(new Player("Tre"));
		Round round = new Round(players, 3, 3, "C");
		
		assertEquals(3, round.getNumOfIterations());
	}
	
	@Test
	public void disCardTest(){
		Hand hand = new Hand();
		int numOfCards;
		ArrayList<Card> CurrentHand = new ArrayList<Card>(10);
		hand.addCard(new Card(Rank.ACE, Suit.SPADES));
		numOfCards = hand.getNumberOfCards();
		
		assertEquals(1, numOfCards);
	}
			
}
