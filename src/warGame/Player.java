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
	public void InvokePlay(){
		this.HandOfPlayer.PlayCard();
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
	
	
}
