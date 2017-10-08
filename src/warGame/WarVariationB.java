package warGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class WarVariationB implements War {
	
	private ArrayList<Player> players;
	private Player winnerOfWar;
	private ArrayList<Card> cards = new ArrayList<Card>();	
	private int pointscounter = 0;
	
	public WarVariationB(ArrayList<Player> players) {
		this.players = players;	
	}
	
	@Override
	public void WarCompareCards(ArrayList<Player> players) {
		
		Player winner = null;
		HashMap<Player, Card> playersAndCards = new HashMap<Player, Card>();
		
		/*iterate through all players and collect their up cards */
		for(int i = 0; i < players.size(); i++)
			playersAndCards.put(players.get(i), players.get(i).InvokePlay());	
	
		
		/* now compare all collected up cards */
		for(int i = 0; i < playersAndCards.values().size(); i++){
			Card highCard;		
			Card currentCard = playersAndCards.get(i);
			Card previousCard = playersAndCards.get(i - 1);	
		
			if(currentCard.getRank().compareTo(previousCard.getRank()) == 0){ // if same
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
		Logger.displayWinnerOfRound(winner);
		this.winnerOfWar = winner;
		pointscounter = 0;
	}

	
	/**
	 * 
	 * @return
	 */
	public Player WinnerOfWar(){
		Logger.displayWinnerOfGame(winnerOfWar);
		return this.winnerOfWar;
	}


}
