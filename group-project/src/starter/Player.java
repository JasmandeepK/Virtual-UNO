package starter;
import java.util.*;

public class Player {
	String playerName;
	int playerNumber, numberOfCards;
	Player nextPlayer;
	Player previousPlayer;
	//Max number of cards = 20
	UnoCard playerHand[] = new UnoCard[25];
	private Scanner x = new Scanner(System.in);
	//Constructor
	Player(int playerNum){
		playerName = "";
		playerNumber = playerNum;
		numberOfCards = 0;
		getPlayerName();
	}
	//Get Player name from User
	public void getPlayerName(){
		System.out.print("Enter the player's name "+(playerNumber+1)+": ");
		playerName = x.next();
		System.out.println();
	}
	
	//Add a card to player Deck
	public void addToDeck(UnoCard c){
		numberOfCards++;
		playerHand[numberOfCards-1] = c;
	}
	public UnoCard removeFromDeck(int index){
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
			System.out.println((i+1)+". "+playerHand[i].cardColorCodeConvert()+" "+playerHand[i].cardTypeCodeConvert());

			
		}
	}
	
}