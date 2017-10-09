package warGame;

/**
 * 
 * @author Richard A. Bravo
 *
 */
public class Player {

	// Variables for Player class
	private String nameOfPlayer;
	private Hand HandOfPlayer;
	private int TotalPoints;

	/**
	 * Constructor for Player Object
	 * 
	 * @param nameOfPlayer
	 */
	public Player(String nameOfPlayer) {
		this.nameOfPlayer = nameOfPlayer;
		this.HandOfPlayer = new Hand();
		this.TotalPoints = 0;
	}

	public String getNameOfPlayer() {
		return this.nameOfPlayer;
	}

	public void setNameOfPlayer(String name) {
		this.nameOfPlayer = name;
	}

	/**
	 * Display an up card to be played
	 * 
	 * @return Card to played
	 */
	public Card InvokePlay() {
		return this.HandOfPlayer.PlayCard(this);
	}

	/**
	 * Remove a card from hand
	 */
	public void disCard() {
		this.HandOfPlayer.disCard();
	}

	public Card setPrize() {
		return this.HandOfPlayer.PrizeSet(this);
	}

	/**
	 * Draw a card from hand
	 */
	public void InvokeDraw(Card card) {
		this.HandOfPlayer.DrawCard(card);
	}

	/**
	 * Return the hand of this player
	 * 
	 * @return
	 */
	public Hand getHandOfPlayer() {
		return this.HandOfPlayer;
	}

	/**
	 * Get total points from this player
	 * 
	 * @return int value of total points
	 */
	public int getTotalPoints() {
		return this.TotalPoints;
	}

	/**
	 * Adds points to player if they won a round
	 */
	public void increasePlayerPoints() {
		this.TotalPoints += 2;
	}

	public void addPlayerPoints(int points) {
		this.TotalPoints += points;
	}

}
