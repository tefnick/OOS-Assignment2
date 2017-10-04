package warGame;
/**
 * 
 * @author richard
 *
 */
public class Player {
	private String nameOfPlayer;
	//public String setNameOfPlayer;

	private Hand HandOfPlayer;
	
	private int TotalPoints;
	
	public Player(String nameOfPlayer) {
		super();
		this.nameOfPlayer = nameOfPlayer;
		HandOfPlayer = new Hand();
		TotalPoints = 0;
	}

	public String getNameOfPlayer() {
		return nameOfPlayer;
	} 
	
	public void setNameOfPlayer(String name) {
		this.nameOfPlayer = name;
	}
	
	public void InvokePlay(){
		
	}
	
	public void InvokeDraw(){
		
	}
	
	public Hand getHandOfPlayer(){
		return this.HandOfPlayer;
	}

	public int getTotalPoints() {
		return this.TotalPoints;
	}
	
	
}
