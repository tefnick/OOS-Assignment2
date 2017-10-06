package warGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import warGame.Card.Rank;

/**
 * 
 * @author Justin
 *
 */
public class Round {
	private ArrayList<Player> players;
	private int numOfPrizes;
	private int numOfIterations;
	private ArrayList<Player> warPlayers;
	
	public Round(){
		//empty constructor
	}
			
	public Round(ArrayList<Player> players, int numOfPrizes, int numOfIterations) {
		this.players.addAll(players);
		this.numOfPrizes = numOfPrizes;
		this.numOfIterations = numOfIterations;
	}
	
	//round driver
	public Player gameStart() {
		//while no winner or numOfIterations > 0
		int roundIteration = 0;
		int gameOver = 0;
		Player gameWinner = null;
		do {
			//winner check (52 cards in hand)
				//if winner break and call logger with winner
			//compare cards
			
			Player roundWinner = compareCards(players);
			Logger.displayWinnerOfRound(roundWinner);
			//if = war()
			//check game over by max cards
			for (int i = 0; i < players.size(); i++) {
				if ( players.get(i).getHandOfPlayer().getNumberOfCards() == 52) {
					//gameWinner = players.get(i); //might not need to return, just print from logger that this player won
					gameOver++;
					return players.get(i); //^^
				}
			}
			//check game over by number of iterations, game winner unnecessary for return version
			roundIteration++;
			if (roundIteration == numOfIterations) {// TODO Tie check 
				int highestNumberOfPoints = 0;
				for (int i = 0; i < players.size(); i++) {
					if(highestNumberOfPoints < players.get(i).getTotalPoints()) {
						gameWinner = players.get(i);	
					}
				}
				gameOver++;
				return gameWinner;
			}
		}while(gameOver == 0);
	
		return gameWinner;
	}

	public  Player compareCards(ArrayList<Player> players) {
		int numOfPlayers = players.size();
		Player winner;
		/*
		 * roundTracker array values
		 * index 0: current highest value
		 * index 1: current winning player index in players
		 * index 2: war achieved 1 = true
		 * index 3: 2nd player for war index in players
		 * index 4: 3rd player for war index in players
		 * index 5: 4th player for war index in players
		 * there is only ever a max of 4 war players due to suits
		 */
		int roundTracker[] = {0,0,0,0,0,0};
		for (int i = 0; i < numOfPlayers; i++) {
			Card card = players.get(i).InvokePlay();
			Logger.displayUpCard(players.get(i), card);
			if ( card.getRank() > roundTracker[0]) {//TODO getValue, returns int card value
				roundTracker[0] = card.getValue(); // TODO card implementations 
				roundTracker[1] = i;
				//reset war in roundTracker(new highest card)
				for(int j = 2; j <= 5; j++) {
					roundTracker[j] = 0;
				}
				winner = players.get(roundTracker[1]);
			}
			else if(card.getValue == roundTracker[0]) {// TODO card implementations
				if(roundTracker[2] == 0) {//no war yet
				roundTracker[2] = 1; //set war to true
				roundTracker[3] = i; //add second player
				}else if(roundTracker[4] == 0){
					roundTracker[4] = i;//add third player
				}else{
					roundTracker[5] = i;//add 4th player
				}
			}else {
				continue;// do nothing
			}
		}
		if (roundTracker[2] == 1) {//war achieved
			warPlayers = new ArrayList<Player>();
			warPlayers.add(players.get(roundTracker[1]));//add first 
			for(int j = 2; j <= 5; j++) {
				if(roundTracker[j] != 0) {
					//add player index from roundTracker
					warPlayers.add(players.get(roundTracker[j]));
				}
			}
			Logger.declareWar();
			
			//Before you call War you must figure out which
			//variation of war will be used
			winner = War(warPlayers);
			//winner.hand.addCards(prizes);
		}
		return winner;
	}
	
	/**
	 * Compares up cards from all the players in the round
	 * @param players in this round
	 * @return the winning player of this round
	 */
	public Player compareUpCards(ArrayList<Player> players){
		Player winner = null;
		LinkedHashMap<Player, Card.Rank> playersAndCards = new LinkedHashMap<>();
		
		/*iterate through all players and collect their up cards */
		for(int i = 0; i < players.size(); i++){
			playersAndCards.put(players.get(i), players.get(i).InvokePlay().getRank());	
		}
		/* now compare all collected up cards */
		for(int i = 0; i < playersAndCards.values().size(); i++){
			Card.Rank highCard;
			
			Card.Rank currentCard = playersAndCards.get(i);
			Card.Rank previousCard = playersAndCards.get(i - 1);
			
			if(currentCard.compareTo(previousCard) > 0){
				highCard = currentCard;
				winner = players.get(i);
				
			}else{
				highCard = previousCard;
				winner = players.get(i);
			}
		}
		
		return winner;
	}
	
	public ArrayList<Player> getPlayers(){
		return this.players;
	}

	public int getNumOfPrizes() {
		return this.numOfPrizes;
	}

	public int getNumOfIterations() {
		return this.numOfIterations;
	}
}
