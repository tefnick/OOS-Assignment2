package warGame;
/**
 * 
 * @author Richard A. Bravo
 *
 */
public class Player {
	
	//Variables for Player class
	private String nameOfPlayer;
	private Hand HandOfPlayer;
	private int TotalPoints;
	
	/**
	 * Constructor for Player Object
	 * @param nameOfPlayer
	 */
	public Player(String nameOfPlayer) {
		this.nameOfPlayer = nameOfPlayer;
		this.HandOfPlayer = new Hand();
		this.TotalPoints = 0;
	}

	/**
	 * 
	 * @return
	 */
	public String getNameOfPlayer() {
		return this.nameOfPlayer;
	} 
	
	/**
	 * 
	 * @param name
	 */
	public void setNameOfPlayer(String name) {
		this.nameOfPlayer = name;
	}
	
	/**
	 * 
	 */
	public Card InvokePlay(){
		return this.HandOfPlayer.PlayCard(this);
	}
	
	public void disCard(){
		this.HandOfPlayer.disCard();
	}
	
	public Card setPrize() {
		return this.HandOfPlayer.PrizeSet(this);
	}
	/**
	 * 
	 */
	public void InvokeDraw(Card card){
		this.HandOfPlayer.DrawCard(card);
	}
	
	/**
	 * 
	 * @return
	 */
	public Hand getHandOfPlayer(){
		return this.HandOfPlayer;
	}

	/**
	 * 
	 * @return
	 */
	public int getTotalPoints() {
		return this.TotalPoints;
	}

	public void increasePlayerPoints(){
		this.TotalPoints += 2;
	}
	
	public void addPlayerPoints(int points) {
		this.TotalPoints += points;
	}
	
}
