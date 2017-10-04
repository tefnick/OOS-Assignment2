package warGame;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Justin
 *
 */
class Round {
	private ArrayList<Player> players;
	private int numOfPrizes;
	private int numOfIterations;
	private ArrayList<Player> warPlayers;
	
	public Round(ArrayList<Player> players, int numOfPrizes, int numOfIterations) {
		this.players.addAll(players);
		this.numOfPrizes = numOfPrizes;
		this.numOfIterations = numOfIterations;
	}

	public void gameStart() {
		//while no winner or numOfIterations > 0
		do {
			//winner check (52 cards in hand)
				//if winner break and call logger with winner
			//compare cards
			
			Player winner = compareCards(players);
			
			//if = war()
		}while();
			
		
	}

	public  Player compareCards(ArrayList<Player> players) {
		int numOfPlayers = players.size();
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
			new Card card = players.get(i).InvokePlay();
			if ( card.getValue > roundTracker[0]) {
				roundTracker[0] = card.getValue(); // TODO card implementations 
				roundTracker[1] = i;
				//reset war in roundTracker(new highest card)
				for(int j = 2; j <= 5; j++) {
					roundTracker[j] = 0;
				}
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
			
			War(warPlayers);
		}
		return winner;
	}
}
