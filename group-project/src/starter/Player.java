package starter;
import java.util.*;

public class Player {
	String playerName = "x";
	int playerNumber, numberOfCards;
	private boolean hasUno = false;
	//Max number of cards = 25
	UnoCard playerHand[] = new UnoCard[25];
	
	
	Player(int playerNum){
		playerName = "";
		playerNumber = playerNum;
		numberOfCards = 0;
	}
	
	public void setHasUno(boolean bool) {
		hasUno = bool;
	}
	
	public boolean getHasUno() {
		return hasUno;
	}
	
	public void setName(String name) {
		playerName = name;
	}
	public UnoCard[] getPlayerHand() {
		return playerHand;
	}
	//Get Player name from User
	public String getPlayerName(){
		return playerName;
	}
	
	public int getNumCards() {
		return numberOfCards;
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