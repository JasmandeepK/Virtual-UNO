package starter;
import java.util.*;

public class Player {
	String playerName = "x";
	int playerNumber, numberOfCards;
	Player nextPlayer;
	Player previousPlayer;
	//Max number of cards = 25
	UnoCard playerHand[] = new UnoCard[25];
	//private Scanner x = new Scanner(System.in);
	//Constructor
	
	/*public static void main(String[] args) {
		Player player1 = new Player(0);
		Player player2 = new Player(1);
		Dealer dealerDeck = new Dealer(108);
		dealerDeck.shuffle();
		UnoCard c;
		for(int i = 0; i < 7; i++) {
			c = dealerDeck.deal();
			player1.addToHand(c);
		}
		for(int i = 0; i < 7; i++) {
			c = dealerDeck.deal();
			player2.addToHand(c);
		}
		player1.displayPlayerHand();
		player2.displayPlayerHand();
		player1.removeFromHand(5);
		System.out.println("Should print player 1's deck with the sixth card removed");
		player1.displayPlayerHand();
	}*/
	
	Player(int playerNum){
		playerName = "";
		playerNumber = playerNum;
		numberOfCards = 0;
		getPlayerName();
	}
	
	public UnoCard[] getPlayerHand() {
		return playerHand;
	}
	//Get Player name from User
	public void getPlayerName(){
		System.out.print("Enter the player's name "+(playerNumber+1)+": ");
		playerName = "x";
		System.out.println();
	}
	
	//Add card to player hand
	public void addToHand(UnoCard c){
		numberOfCards++;
		playerHand[numberOfCards-1] = c;
	}
	public UnoCard removeFromHand(int index){
		UnoCard toReturn = playerHand[index];
		for(;index<numberOfCards;index++){
			if(index==numberOfCards-1){
				playerHand[index] = null;
			}
			else{
				playerHand[index] = playerHand[index+1];
			}		
		}
		numberOfCards--;
		return toReturn;
	}
	//Display player's hand - call at every turn
	public void displayPlayerHand(){
		
		System.out.println(playerName+"'s cards:");
		for(int i=0;i<numberOfCards;i++){
			System.out.println((i+1)+". "+playerHand[i].getColorType().getColor()+" "+playerHand[i].getCardValue().getValue());
			
		}
	}
	
}