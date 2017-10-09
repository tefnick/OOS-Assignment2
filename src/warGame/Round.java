package warGame;

import java.util.ArrayList;

/**
 * @author Justin Round acts as the game driver
 */
public class Round {
	private ArrayList<Player> players;
	private int numOfPrizes;
	private int numOfIterations;
	private ArrayList<Player> warPlayers;
	private String VariationForWar;

	public Round(ArrayList<Player> players, int numOfPrizes, int numOfIterations, String variation) {
		this.players = players;
		this.numOfPrizes = numOfPrizes;
		this.numOfIterations = numOfIterations;
		this.VariationForWar = variation;
	}

	public Player gameStart() {
		int roundIteration = 0;
		int gameOver = 0;
		Player gameWinner = null;
		Player gameWinner2 = null;
		Player roundWinner = null;
		do {
			roundWinner = compareCards(players);
			Logger.displayWinnerOfRound(roundWinner);
			// check game over by max cards
			for (int i = 0; i < players.size(); i++) {
				if (players.get(i).getHandOfPlayer().getNumberOfCards() == 52) {
					gameOver++;
					return players.get(i); // ^^
				}
			}
			// check game over by number of iterations, game winner unnecessary for return
			if (Game.getVariation().equals("A")) {
				roundIteration++;
				if (roundIteration == numOfIterations) {
					int highestNumberOfPoints = 0;
					for (int i = 0; i < players.size(); i++) {
						if (highestNumberOfPoints < players.get(i).getTotalPoints()) {
							highestNumberOfPoints = players.get(i).getTotalPoints();
							gameWinner = players.get(i);
							gameWinner2 = null;// reset any tie because new high
						} else if (highestNumberOfPoints == players.get(i).getTotalPoints()) {
							gameWinner2 = players.get(i);
						}
					}
					if (gameWinner2 == null) {
						gameOver++;
						return gameWinner;
					} else {
						Logger.displayWinnerOfGameTie(gameWinner, gameWinner2);
						Player gameTIE = new Player("TIE");
						return gameTIE;
					}
				}
			}
			// check game over from lack of playing cards left, game winner has most points
			if (players.get(0).getHandOfPlayer().getNumberOfCards() == 0
					|| players.get(1).getHandOfPlayer().getNumberOfCards() == 0) {
				gameWinner = decideWinnerNoCards(gameWinner);
				gameOver++;
				return gameWinner;
			}
		} while (gameOver == 0);
		return gameWinner;
	}

	private Player decideWinnerNoCards(Player gameWinner) {
		int highestNumberOfPoints = 0;
		if (!this.VariationForWar.equalsIgnoreCase("A")) {
			for (int i = 0; i < players.size(); i++) {
				if (highestNumberOfPoints < players.get(i).getTotalPoints()) {
					highestNumberOfPoints = players.get(i).getTotalPoints();
					gameWinner = players.get(i);
				}
			}
		} else {
			for (int i = 0; i < players.size(); i++) {
				if (players.get(i).getHandOfPlayer().getNumberOfCards() != 0) {
					gameWinner = players.get(i);
				}
			}
		}
		return gameWinner;
	}

	public Player compareCards(ArrayList<Player> players) {
		int numOfPlayers = players.size();
		Player winner = null;
		ArrayList<Card> prizePile = new ArrayList<Card>();
		/*
		 * roundTracker array values index 0: current highest value index 1: current
		 * winning player index in players index 2: war achieved 1 = true index 3: 2nd
		 * player for war index in players index 4: 3rd player for war index in players
		 * index 5: 4th player for war index in players there is only ever a max of 4
		 * war players due to suits
		 */
		int roundTracker[] = { 0, 0, 0, 0, 0, 0 };
		for (int i = 0; i < numOfPlayers; i++) {
			Card card = players.get(i).InvokePlay();
			if (Game.getVariation().equals("A")) {
				prizePile.add(card);
			}

			if (card.getValue() > roundTracker[0]) {
				roundTracker[0] = card.getValue();
				roundTracker[1] = i;

				for (int j = 2; j <= 5; j++) {// reset war in roundTracker(new highest card)
					roundTracker[j] = 0;
				}
				winner = players.get(roundTracker[1]);
			} else if (card.getValue() == roundTracker[0]) {
				if (roundTracker[2] == 0) {// no war yet
					roundTracker[2] = 1; // set war to true
					roundTracker[3] = i; // add second player
				} else if (roundTracker[4] == 0) {
					roundTracker[4] = i;// add third player
				} else {
					roundTracker[5] = i;// add 4th player
				}
			} else {
				continue;// do nothing
			}
		}
		if (roundTracker[2] == 1) {// war achieved
			warPlayers = new ArrayList<Player>();
			warPlayers.add(players.get(roundTracker[1]));// add first
			for (int j = 2; j <= 5; j++) {
				if (roundTracker[j] != 0) {
					warPlayers.add(players.get(roundTracker[j]));// add player index from roundTracker
				}
			}
			Logger.declareWar();
			winner = decideWarVersion(players);
		}
		players.get(roundTracker[1]).addPlayerPoints(players.size());
		if (Game.getVariation().equals("A")) {
			for (Card card : prizePile) {
				players.get(roundTracker[1]).getHandOfPlayer().addCard(card);
			}
		}
		return winner;
	}

	private Player decideWarVersion(ArrayList<Player> players) {
		Player winner;
		if (Game.getVariation().equals("A")) {
			WarVariationA WarVariationA = new WarVariationA(players, numOfIterations);
			WarVariationA.WarCompareCards(players);
			winner = WarVariationA.WinnerOfWar();
		} else if (Game.getVariation().equals("B")) {
			WarVariationB WarVariationB = new WarVariationB(players);
			WarVariationB.WarCompareCards(players);
			winner = WarVariationB.WinnerOfWar();
		} else {
			WarVariationC WarVariationC = new WarVariationC(players);
			WarVariationC.WarCompareCards(players);
			winner = WarVariationC.WinnerOfWar();
		}
		return winner;
	}

	public ArrayList<Player> getPlayers() {
		return this.players;
	}

	public int getNumOfPrizes() {
		return this.numOfPrizes;
	}

	public int getNumOfIterations() {
		return this.numOfIterations;
	}
}
