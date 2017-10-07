package warGame;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class WarVariationA implements War {
	/**
	 * 
	 */
	private Player[] Players;
	
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
	public WarVariationA(Player[] Players, int iteration){
	this.Players = Players;
	this.iteration = iteration;
	}
	
	/**
	 * 
	 * @param Cards
	 */
	public void WarCompareCards(ArrayList<Player> players){
		Player winner = null;
		LinkedHashMap<Player, Card> playersAndCards = new LinkedHashMap<Player, Card>();
		
		/*iterate through all players and collect their up cards */
		for(int i = 0; i < players.size(); i++)
			playersAndCards.put(players.get(i), players.get(i).InvokePlay());	
	
		
		/* now compare all collected up cards */
		for(int i = 0; i < playersAndCards.values().size(); i++){
			Card highCard;		
			Card currentCard = playersAndCards.get(i);
			Card previousCard = playersAndCards.get(i - 1);	
		
			//TODO needs a war determining segment that tracks all possible war members, 4 max
			if(currentCard.getRank().compareTo(previousCard.getRank()) == 0 && this.iteration > 0){
				Cards.add(previousCard);
				Cards.add(currentCard);
				WarCompareCards(players);
			}
			
			if(currentCard.getRank().compareTo(previousCard.getRank()) > 0){
				highCard = currentCard;
				winner = players.get(i);
				winner.getHandOfPlayer().addCard(currentCard);
				winner.getHandOfPlayer().addCard(previousCard);
				if(Cards.size() != 0){
					for(int j = 0; j < Cards.size();j++){
						winner.getHandOfPlayer().addCard(Cards.get(j));
					}
				}
				
			}else{
				highCard = previousCard;
				winner = players.get(i-1);
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
	}
	
	/**
	 * 
	 * @return
	 */
	public Player WinnerOfWar(){
		return this.WinnerOfWar;
	}
}
