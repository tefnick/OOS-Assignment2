package warGame;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class WarVariationA implements War {
	/**
	 * 
	 */
	private ArrayList<Player> Players;
	
	/**
	 * 
	 */
	private Player WinnerOfWar;
	
	/**
	 * 
	 */
	private ArrayList<Card> Cards = new ArrayList<Card>();
	
	private int iteration;
	
	/**
	 * 
	 * @param Players
	 */
	public WarVariationA(ArrayList<Player> Players, int iteration){
		this.Players = Players;
		this.iteration = iteration;
	}
	
	/**
	 * 
	 * @param Cards
	 */
	public void WarCompareCards(ArrayList<Player> players){
		
		Player winner = null;
		Card player1Card;
		Card player2Card;
		Card highCard;
		
		if(players.get(0).getHandOfPlayer().getNumberOfCards() > 4 && players.get(1).getHandOfPlayer().getNumberOfCards() > 4){
			for(int i = 0; i < 3; i++){
				players.get(0).disCard();
				players.get(1).disCard();
			}
		}
		//System.out.println("End of discards");
		if(players.get(0).getHandOfPlayer().getNumberOfCards() < 1){
			winner = players.get(1);
			for(int i = 0; i < Cards.size(); i++){
				if(!Cards.isEmpty()){
					winner.getHandOfPlayer().DrawCard(Cards.get(i));
					Cards.remove(i);
				}
			}
			this.WinnerOfWar = winner;
			return;
		}
		if(players.get(1).getHandOfPlayer().getNumberOfCards() < 1){
			winner = players.get(0);
			for(int i = 0; i < Cards.size(); i++){
				if(!Cards.isEmpty()){
					winner.getHandOfPlayer().DrawCard(Cards.get(i));
					Cards.remove(i);
				}
			}
			this.WinnerOfWar = winner;
			return;
		}
		
		player1Card = players.get(0).InvokePlay();
		player2Card = players.get(1).InvokePlay();
		Cards.add(player1Card);
		Cards.add(player2Card);
		
		if(player1Card.getValue() == player2Card.getValue()){
			if(players.get(0).getHandOfPlayer().getNumberOfCards() < 1 && players.get(1).getHandOfPlayer().getNumberOfCards() < 1){
				winner = null;
				Logger.displayTie();
				return;
			}
			if(players.get(0).getHandOfPlayer().getNumberOfCards() < 1){
				highCard = player1Card;
				winner = players.get(1);
				for(int i = 0; i < Cards.size(); i++){
					winner.getHandOfPlayer().DrawCard(Cards.get(i));
					Cards.remove(i);
				}
				this.WinnerOfWar = winner;
				return;
			}
			if(players.get(1).getHandOfPlayer().getNumberOfCards() < 1){
				highCard = player1Card;
				winner = players.get(0);
				for(int i = 0; i < Cards.size(); i++){
					winner.getHandOfPlayer().DrawCard(Cards.get(i));
					Cards.remove(i);
				}
				
				this.WinnerOfWar = winner;
				return;
			}
			player1Card = players.get(0).InvokePlay();
			player2Card = players.get(1).InvokePlay();
			Cards.add(player1Card);
			Cards.add(player2Card);
			
			while(player1Card.getRank().compareTo(player2Card.getRank()) == 0){
				if(players.get(0).getHandOfPlayer().getNumberOfCards() < 1 && players.get(1).getHandOfPlayer().getNumberOfCards() < 1){
					winner = null;
					return;
				}
				if(players.get(0).getHandOfPlayer().getNumberOfCards() < 1){
					winner = players.get(1);
					this.WinnerOfWar = winner;
					for(int i = 0; i < Cards.size(); i++){
						winner.getHandOfPlayer().DrawCard(Cards.get(i));
						Cards.remove(i);
					}
					Logger.displayWinnerOfRound(players.get(1));
					return;
					
				}
				if(players.get(1).getHandOfPlayer().getNumberOfCards() < 1){
					winner = players.get(0);
					this.WinnerOfWar = winner;
					for(int i = 0; i < Cards.size(); i++){
						winner.getHandOfPlayer().DrawCard(Cards.get(i));
						Cards.remove(i);
					}
					Logger.displayWinnerOfRound(players.get(0));
					return;
					
				}
				player1Card = players.get(0).InvokePlay();
				player2Card = players.get(1).InvokePlay();
				Cards.add(player1Card);
				Cards.add(player2Card);
			}
		}
		
		if(player1Card.getValue() > player2Card.getValue()){//if player 1 has highcard
			highCard = player1Card;
			winner = players.get(0);
			for(int i = 0; i < Cards.size(); i++){
				winner.getHandOfPlayer().DrawCard(Cards.get(i));
				Cards.remove(i);
			}
			Logger.displayWinnerOfRound(winner);
			

			
		}else{//if player 2 has high card
			highCard = player2Card; 
			winner = players.get(1);
			for(int i = 0; i < Cards.size(); i++){
				winner.getHandOfPlayer().DrawCard(Cards.get(i));
				Cards.remove(i);
			}
			Logger.displayWinnerOfRound(winner);
			

		}
		
	this.WinnerOfWar = winner;
	return;
		
		
		/**
		Player winner = null;
		Card player1Card;
		Card player2Card;
		Card highCard;
		LinkedHashMap<Player, Card> playersAndCards = new LinkedHashMap<Player, Card>();
		

		if(players.get(0).getHandOfPlayer().getNumberOfCards() > 4 && players.get(1).getHandOfPlayer().getNumberOfCards() > 4){
			for(int i = 0; i < 3; i++){
				players.get(0).disCard();
				players.get(1).disCard();
			}
		}
		

		for(int i = 0; i < playersAndCards.values().size(); i++){
			Card currentCard = players.get(0).InvokePlay();
			Card previousCard = players.get(1).InvokePlay();	
		
			//TODO needs a war determining segment that tracks all possible war members, 4 max
			if(currentCard.getValue() == previousCard.getValue()){
				Cards.add(previousCard);
				Cards.add(currentCard);
				WarCompareCards(players);
			}
			
			if(currentCard.getValue() > previousCard.getValue()){
				highCard = currentCard;
				winner = players.get(0);
				winner.getHandOfPlayer().addCard(currentCard);
				winner.getHandOfPlayer().addCard(previousCard);
				if(Cards.size() != 0){
					for(int j = 0; j < Cards.size();j++){
						winner.getHandOfPlayer().addCard(Cards.get(j));
					}
				}
				
			}else{
				highCard = previousCard;
				winner = players.get(1);
				winner.getHandOfPlayer().addCard(currentCard);
				winner.getHandOfPlayer().addCard(previousCard);
				if(Cards.size() != 0){
					for(int j = 0; j < Cards.size();j++){
						winner.getHandOfPlayer().addCard(Cards.get(j));
					}
				}
				
			}
		}	
		
		//TODO winner.getPrizes();
		this.WinnerOfWar = winner;
		*/
		
		
	}
	
	/**
	 * 
	 * @return
	 */
	public Player WinnerOfWar(){
		return this.WinnerOfWar;
	}
}
