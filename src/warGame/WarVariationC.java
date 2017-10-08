package warGame;

import java.util.ArrayList;

public class WarVariationC implements War {
	
	private ArrayList<Player> players;
	private Player WinnerOfWar;
	private int pointsCounter = 0;
	
	
	public WarVariationC(ArrayList<Player> players) {
		this.players = players;	
	}
	
	public Player WinnerOfWar(){
		Player player = null;
		return null;
	}

	public void WarCompareCards(ArrayList<Player> players) {
		Player winner = null;
		Card player1Card;
		Card player2Card;
		Card highCard;
		
		if(players.get(0).getHandOfPlayer().getNumberOfCards() > 4 && players.get(1).getHandOfPlayer().getNumberOfCards() > 4){
			for(int i = 0; i < 3; i++){
				players.get(0).disCard();
				players.get(1).disCard();
				this.pointsCounter += 2;
				
			}
		}
		System.out.println("End of discards");
		player1Card = players.get(0).InvokePlay();
		player2Card = players.get(1).InvokePlay();
		this.pointsCounter += 2;

		if(player1Card.getValue() == player2Card.getValue()){
			if(players.get(0).getHandOfPlayer().getNumberOfCards() < 1 && players.get(1).getHandOfPlayer().getNumberOfCards() < 1){
				winner = null;
				this.pointsCounter = 0;
				Logger.displayTie();
				return;
			}
			if(players.get(0).getHandOfPlayer().getNumberOfCards() < 1){
				highCard = player1Card;
				winner = players.get(1);
				//winner.increasePlayerPoints();
				winner.addPlayerPoints(this.pointsCounter);
				this.pointsCounter = 0;
				return;
			}
			if(players.get(1).getHandOfPlayer().getNumberOfCards() < 1){
				highCard = player1Card;
				winner = players.get(0);
				//winner.increasePlayerPoints();
				winner.addPlayerPoints(this.pointsCounter);
				this.pointsCounter = 0;
				return;
			}
			player1Card = players.get(0).InvokePlay();
			player2Card = players.get(1).InvokePlay();
			this.pointsCounter += 2;
			while(player1Card.getRank().compareTo(player2Card.getRank()) == 0){
				if(players.get(0).getHandOfPlayer().getNumberOfCards() < 1 && players.get(1).getHandOfPlayer().getNumberOfCards() < 1){
					winner = null;
					this.pointsCounter = 0;
					return;
				}
				if(players.get(0).getHandOfPlayer().getNumberOfCards() < 1){
					winner = players.get(1);
					Logger.displayWinnerOfRound(players.get(1));
					winner.addPlayerPoints(this.pointsCounter);
					this.pointsCounter = 0;
					return;
					
				}
				if(players.get(1).getHandOfPlayer().getNumberOfCards() < 1){
					winner = players.get(0);
					Logger.displayWinnerOfRound(players.get(0));
					winner.addPlayerPoints(this.pointsCounter);
					this.pointsCounter = 0;
					return;
					
				}
				player1Card = players.get(0).InvokePlay();
				player2Card = players.get(1).InvokePlay();
				this.pointsCounter += 2;
			}
		}
		
		if(player1Card.getValue() > player2Card.getValue()){//if player 1 has highcard
			highCard = player1Card;
			winner = players.get(0);
			Logger.displayWinnerOfRound(winner);
			winner.increasePlayerPoints();
			
		}else{//if player 2 has high card
			highCard = player2Card; 
			winner = players.get(1);
//			System.out.println(players.get(1).getNameOfPlayer());
			Logger.displayWinnerOfRound(winner);
			winner.increasePlayerPoints();
		}
		
	System.out.println("End of War!");
	winner.addPlayerPoints(this.pointsCounter);
	this.pointsCounter = 0;
	this.WinnerOfWar = winner;
	return;
	}
}
