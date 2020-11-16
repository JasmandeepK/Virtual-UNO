package starter;

//actionCard -- specialCard -- winCondition -- validation -- player1Turn -- player2Turn

//Test

public class GamePlay {
	
	//Constructor
	public GamePlay() {
		
	}
	
	//Verify that the current player has no remaining cards
	public boolean emptyHand(Player player) {
		return (player.numberOfCards == 0);
		//Will change and add more later
	}
}