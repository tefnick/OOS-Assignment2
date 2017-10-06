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
		Card card = new Card(Rank.ACE, Suit.CLUBS);
			
		Logger.displayUpCard(players.get(0),card);	
		System.out.println();;
	}
	
	@Test
	public void compareUpCardsTest(){
		ArrayList<Player> players = new ArrayList<Player>();
		Player player1 = new Player("Nick");
		Player player2 = new Player("Justin");
		players.add(player1);
		players.add(player2);
		Round round = new Round();
		Player winner;
		
		players.get(0).InvokePlay().getRank(); //TODO: need to fix Player:InvokePlay and Hand: PLayCard to test this
		players.get(1).InvokePlay().getRank();
		winner = round.compareUpCards(players);
		System.out.println(winner);	
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
		
}
