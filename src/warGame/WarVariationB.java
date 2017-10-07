package warGame;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class WarVariationB implements War {
	
	private ArrayList<Player> players;
	private Player winnerOfWar;
	private ArrayList<Card> cards = new ArrayList<Card>();	
	
	public WarVariationB(ArrayList<Player> players) {
		this.players = players;	
	}
	
	@Override
	public void WarCompareCards(ArrayList<Player> players) {
		int pointscounter = 0;
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
			if(currentCard.getRank().compareTo(previousCard.getRank()) == 0){
				cards.add(previousCard);
				cards.add(currentCard);
				WarCompareCards(players);
			}
			
			if(currentCard.getRank().compareTo(previousCard.getRank()) > 0){
				highCard = currentCard;
				winner = players.get(i);
				pointscounter++;
				winner.increasePlayerPoints();
				
				
			}else{
				highCard = previousCard;
				winner = players.get(i-1);
				pointscounter++;
				winner.increasePlayerPoints();
			}
		}	
		
		winner.addPlayerPoints(pointscounter);
		this.winnerOfWar = winner;
		
	}

	
	/**
	 * 
	 * @return
	 */
	public Player WinnerOfWar(){
		return this.winnerOfWar;
	}


}
