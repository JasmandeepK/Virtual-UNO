package starter;
import java.util.*;

class Dealer {
	private UnoCard[] deck;
	
	public Dealer(int num) {
		deck = new UnoCard[num];
		int start = 0;
		for(int i = 0; i < 4; i ++) {
			for(int j = 0; j < 13; j++) {
				if(j == 0) {	// there is only one 0 card value per color
					deck[start] = new UnoCard(i,j);
					start++;
				}
				else {	//there are 2 of card values for each number except for wild cards
					deck[start] = new UnoCard(i,j);
					start++;
					deck[start] = new UnoCard(i,j);
					start++;
				}
			}
		}
		for(int i = 0; i < 4; i++) {	//there are 4 wild cards and 4 +4 wild cards in an UNO deck
			deck[start] = new UnoCard(4,13);
			start++;
			deck[start] = new UnoCard(4,14);
			start++;
		}
	}
	
	public static void main(String[] args) {
		Dealer dealerDeck = new Dealer(108);
		dealerDeck.shuffle();
	}
	
	public void shuffle() {
        Random randomNumber = new Random();
        //randomizing the deck
        for (int i = 0; i <= 107; i++) {
             int rand = randomNumber.nextInt(107) + 1;
             UnoCard temp = deck[i];
             deck[i] = deck[rand];
             deck[rand] = temp;
        }
   }
}