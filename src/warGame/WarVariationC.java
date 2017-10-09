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
		return this.WinnerOfWar;
	}

	public void WarCompareCards(ArrayList<Player> players) {
		Player winner = null;
		ArrayList<Player> playersForWar = new ArrayList<Player>();
		int highestValue;
		Card player1Card;
		Card player2Card;
		Card player3Card;
		Card highCard;
		
		if(players.size() == 2){

			if(players.get(0).getHandOfPlayer().getNumberOfCards() > 4 && players.get(1).getHandOfPlayer().getNumberOfCards() > 4){
				for(int i = 0; i < Game.getNumOfPrizes(); i++){
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

			if(player1Card.getValue() > player2Card.getValue()){
				highCard = player1Card;
				winner = players.get(0);
				Logger.displayWinnerOfRound(winner);
				winner.increasePlayerPoints();

			}else{//if player 2 has high card
				highCard = player2Card; 
				winner = players.get(1);
				Logger.displayWinnerOfRound(winner);
				winner.increasePlayerPoints();
			}

			System.out.println("End of War!");
			winner.addPlayerPoints(this.pointsCounter);
			this.pointsCounter = 0;
			this.WinnerOfWar = winner;
			return;
		}
		//3 players in war
		else{

			//Check to see if the players have enough cards to play war
			if(players.get(0).getHandOfPlayer().getNumberOfCards() > 4 && players.get(1).getHandOfPlayer().getNumberOfCards() > 4){
				for(int i = 0; i < Game.getNumOfPrizes(); i++){
					players.get(0).disCard();
					players.get(1).disCard();
					players.get(2).disCard();
					this.pointsCounter += 3;
				}
			}
		
			//Play cards
			player1Card = players.get(0).InvokePlay();
			player2Card = players.get(1).InvokePlay();
			player3Card = players.get(2).InvokePlay();
			this.pointsCounter += 3;
			
			//Check to see which card is max
			highestValue = Math.max(player1Card.getValue(),player2Card.getValue());
			highestValue = Math.max(highestValue, player3Card.getValue());
			
			//Check to see which players have the highest card
			if(player1Card.getValue() == highestValue){
				playersForWar.add(players.get(0));
			}
			if(player2Card.getValue() == highestValue){
				playersForWar.add(players.get(1));
			}
			if(player3Card.getValue() == highestValue){
				playersForWar.add(players.get(2));
			}
			
			//Check to see if there is a winner
			if(playersForWar.size() == 1){
				winner = playersForWar.get(0);//1 was previous
				this.WinnerOfWar = winner;
				Logger.displayWinnerOfRound(winner);
				winner.increasePlayerPoints();
				winner.addPlayerPoints(pointsCounter);
				this.pointsCounter = 0;
				return;
			}
			//If there is not a single winner
			else{
				if(playersForWar.size() == 2){
					
					Player player1 = playersForWar.get(0);
					Player player2 = playersForWar.get(1);
					
					if(player1.getHandOfPlayer().getNumberOfCards() > 4 && player2.getHandOfPlayer().getNumberOfCards() > 4){
						for(int i = 0; i < Game.getNumOfPrizes(); i++){
							player1.disCard();
							player2.disCard();
							this.pointsCounter += 2;

						}
					}
					
					System.out.println("End of discards");
					player1Card = player1.InvokePlay();
					player2Card = player2.InvokePlay();
					this.pointsCounter += 2;

					if(player1Card.getValue() == player2Card.getValue()){
						if(player1.getHandOfPlayer().getNumberOfCards() < 1 && player2.getHandOfPlayer().getNumberOfCards() < 1){
							winner = null;
							this.pointsCounter = 0;
							Logger.displayTie();
							return;
						}
						if(player1.getHandOfPlayer().getNumberOfCards() < 1){
							highCard = player2Card;
							winner = player2;
							winner.addPlayerPoints(this.pointsCounter);
							this.pointsCounter = 0;
							return;
						}
						if(player2.getHandOfPlayer().getNumberOfCards() < 1){
							highCard = player1Card;
							winner = player1;
							winner.addPlayerPoints(this.pointsCounter);
							this.pointsCounter = 0;
							return;
						}
						player1Card = player1.InvokePlay();
						player2Card = player2.InvokePlay();
						this.pointsCounter += 2;
						while(player1Card.getRank().compareTo(player2Card.getRank()) == 0){
							if(player1.getHandOfPlayer().getNumberOfCards() < 1 && player2.getHandOfPlayer().getNumberOfCards() < 1){
								winner = null;
								this.pointsCounter = 0;
								return;
							}
							if(player1.getHandOfPlayer().getNumberOfCards() < 1){
								winner = player2;
								Logger.displayWinnerOfRound(players.get(1));
								winner.addPlayerPoints(this.pointsCounter);
								this.pointsCounter = 0;
								return;

							}
							if(player2.getHandOfPlayer().getNumberOfCards() < 1){
								winner = player1;
								Logger.displayWinnerOfRound(players.get(0));
								winner.addPlayerPoints(this.pointsCounter);
								this.pointsCounter = 0;
								return;

							}
							player1Card = player1.InvokePlay();
							player2Card = player2.InvokePlay();
							this.pointsCounter += 2;
						}
					}

					if(player1Card.getValue() > player2Card.getValue()){
						highCard = player1Card;
						winner = player1;
						Logger.displayWinnerOfRound(winner);
						winner.increasePlayerPoints();

					}else{//if player 2 has high card
						highCard = player2Card; 
						winner = player2;
						Logger.displayWinnerOfRound(winner);
						winner.increasePlayerPoints();
					}

					System.out.println("End of War!");
					winner.addPlayerPoints(this.pointsCounter);
					this.pointsCounter = 0;
					this.WinnerOfWar = winner;
					return;
	
				}
				else{
					
					//Play cards
					player1Card = players.get(0).InvokePlay();
					player2Card = players.get(1).InvokePlay();
					player3Card = players.get(2).InvokePlay();
					this.pointsCounter += 3;
					
					//Check to see which card is max
					highestValue = Math.max(player1Card.getValue(),player2Card.getValue());
					highestValue = Math.max(highestValue, player3Card.getValue());
					
					//Check to see which players have the highest card
					if(player1Card.getValue() == highestValue){
						playersForWar.add(players.get(0));
					}
					if(player2Card.getValue() == highestValue){
						playersForWar.add(players.get(1));
					}
					if(player3Card.getValue() == highestValue){
						playersForWar.add(players.get(2));
					}
					
					//Check to see if there is a winner
					if(playersForWar.size() == 1){
						winner = playersForWar.get(1);
						this.WinnerOfWar = winner;
						Logger.displayWinnerOfRound(winner);
						winner.increasePlayerPoints();
						winner.addPlayerPoints(pointsCounter);
						this.pointsCounter = 0;
						return;
					}
					//There will be a tie
					else{
						winner = null;
						this.pointsCounter = 0;
						Logger.displayTie();
						return;
					}
					
				}
					
			}
		
		}
	}
}
