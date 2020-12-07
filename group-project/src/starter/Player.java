//This class contains player data such as playername, hand, number, and the number of cards
package starter;
import java.util.*;

public class Player {
	String playerName = "x";
	int playerNumber, numberOfCards;
	//Max number of cards = 25
	UnoCard playerHand[] = new UnoCard[25];
	
	
	Player(int playerNum){
		playerName = "";
		playerNumber = playerNum;
		numberOfCards = 0;
	}
	
	//sets the location of the card on the screen
	public void setCoordinates(int i, int[] location) {
		playerHand[i].setCoordinates(location);
	}
	
	//returns the location of a card
	public int[] getCoordinates(int i) {
		return playerHand[i].getCoordinates();
	}
	
	//sets the player name
	public void setName(String name) {
		playerName = name;
	}
	
	//returns an array of cards which is the player's hand
	public UnoCard[] getPlayerHand() {
		return playerHand;
	}
	
	//sets the player hand
	public void setPlayerHand(UnoCard[] array) {
		playerHand = array;
	}
	
	//Get Player name from User
	public String getPlayerName(){
		return playerName;
	}
	
	//gets the number of cards the player has
	public int getNumCards() {
		return numberOfCards;
	}
	
	//Add card to player hand
	public void addToHand(UnoCard c){
		numberOfCards++;
		playerHand[numberOfCards-1] = c;
	}
	
	//removes a card from the player's hand
	public void removeFromHand(int index){
		for(int i = index;i < numberOfCards;i++){
			if(i == numberOfCards-1) {
				playerHand[i] = null;
			}
			else {
				playerHand[i] = playerHand[i+1];
			}		
		}
		numberOfCards--;
	}
	
	//Display player's hand - call at every turn
	public void displayPlayerHand(){
		
		System.out.println(playerName+"'s cards:");
		for(int i=0;i<numberOfCards;i++){
			System.out.println((i+1)+". "+playerHand[i].getColorType().getColor()+" "+playerHand[i].getCardValue().getValue());
			
		}
	}
	
}