package warGame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//import warGame.Round.variation;

/**
 * 
 * @author Justin
 *
 */
public class Game {
	private static int numOfPlayers;
	private static int numOfPrizes;
	private static int numOfIterations;
	private static String variationForGame;
	//private variation Variation;
	//private enum variation {A, B, C};
	/* this could be a list instead of array
	//private static player playerArray[];//need to make player class,
	 * 
	*/
	private static ArrayList<Player> players;
	
	public static void main(String[] args) {
		Scanner getInput = new Scanner(System.in);
		
		/* could call getPlayers(getInput) function
		 * get # of players, enter that many names, return players
		 */
		System.out.println("Please enter the number of players: ");
		numOfPlayers = getInput.nextInt();
		//could call get numPrizes(getInput)
		System.out.println("Please enter the number of prizes in a war: ");
		numOfPrizes = getInput.nextInt();
		//could call getIterations(getInput);
		System.out.println("How many iterations should be played this game: ");
		numOfIterations = getInput.nextInt();
		System.out.println("What variation(A, B, C):  ");

		//variation = getInput.next().toUpperCase();

		setVariation(getInput.next().toUpperCase());

		
		
		//could call populatePlayers(getInput);
		players = new ArrayList<Player>();
		for(int i = 0; i < numOfPlayers; i++) {
		//do {
			System.out.println("Please enter the name of player " + (i + 1) + ": ");
			
			//Player player; //= new Player(getInput.nextLine());
			//player.setNameOfPlayer(getInput.nextLine());
			String playerName = "";
			
			//if(getInput.hasNextLine()) {
			while(playerName.isEmpty()) {
				playerName = getInput.nextLine(); 
			//}
			}
			Player player = new Player(playerName);
			players.add( player);
			
			System.out.println("Player " + (i+1) + " will be " + players.get(i).getNameOfPlayer() + "\n");
			
		}//while();
		
		getInput.close();
		//round(playerArray, numOfPrizes, numOfIterations);
		CardGroup deckOfCards = new CardGroup();
		//deckOfCards.displayDeck();
		Deck deck = new Deck(deckOfCards);

		//Collections.shuffle(deck.getDeck().displayDeck());
		deck.Shuffle();
		//deckOfCards.displayDeck();
		
		while(deck.hasCards()) {
			for(Player player : players)
			player.InvokeDraw(deck.DistributeCard());
		}
	
		
		//get deck
		//start round
		Round startGame = new Round(players, numOfPrizes, numOfIterations, variationForGame);
		Player gameWinner = startGame.gameStart();
		Logger.displayWinnerOfGame(gameWinner);
		return;
	}

	public static String getVariation() {
		return variationForGame;
	}
/*
	public static void setVariation(String variation) {
		//enum VariationForWar = variation;
		for(variation VariationForWar : values()) {
			if(VariationForWar.toString().equals(variation)) {
				VariationForWar = VariationForWar;
			}
		}
	}
	*/
	public static void setVariation(String variation){
		variationForGame = variation;
		if(!variationForGame.equals("A") && !variationForGame.equals("B") && !variationForGame.equals("C")) {
			variationForGame = "A";
		}
	}

}
