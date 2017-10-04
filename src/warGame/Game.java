package warGame;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Justin
 *
 */
public class Game {
	private static int numOfPlayers;
	private static int numOfPrizes;
	private static int numOfIterations;
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
		System.out.println("Please enter the number of prizes in a war");
		numOfPrizes = getInput.nextInt();
		//could call getIterations(getInput);
		System.out.println("How many iterations should be played this game?");
		numOfIterations = getInput.nextInt();
		
		//could call populatePlayers(getInput);
		//commented out til player class and array/list are implemented
		players = new ArrayList<Player>();
		for(int i = 0; i < numOfPlayers; i++) {
			System.out.println("Please enter the name of player " + i + ": ");
			
			Player player; //= new Player(getInput.nextLine());
			//player.setNameOfPlayer(getInput.nextLine());
			players.add( player = new Player(getInput.nextLine()));
			
			System.out.println("Player " + i + " will be " + players.get(i));
		}
		
		getInput.close();
		//round(playerArray, numOfPrizes, numOfIterations);
		
		//get deck
		//start round
		Round startGame = new Round(players, numOfPrizes, numOfIterations);
		
		return;
	}

}
