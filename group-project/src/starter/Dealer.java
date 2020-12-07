package starter;
import java.util.*;

class Dealer {
	private UnoCard[] deck;
	private Queue queue = new Queue(108);

	public Dealer(int num) {
		deck = new UnoCard[num];		
		
		//Red Cards
		deck[0] = new UnoCard(0,0);
		deck[1] = new UnoCard(0,1);
		deck[2] = new UnoCard(0,1);
		deck[3] = new UnoCard(0,2);
		deck[4] = new UnoCard(0,2);
		deck[5] = new UnoCard(0,3);
		deck[6] = new UnoCard(0,3);
		deck[7] = new UnoCard(0,4);
		deck[8] = new UnoCard(0,4);
		deck[9] = new UnoCard(0,5);
		deck[10] = new UnoCard(0,5);
		deck[11] = new UnoCard(0,6);
		deck[12] = new UnoCard(0,6);
		deck[13] = new UnoCard(0,7);
		deck[14] = new UnoCard(0,7);
		deck[15] = new UnoCard(0,8);
		deck[16] = new UnoCard(0,8);
		deck[17] = new UnoCard(0,9);
		deck[18] = new UnoCard(0,9);
		deck[19] = new UnoCard(0,10);
		deck[20] = new UnoCard(0,10);
		deck[21] = new UnoCard(0,11);
		deck[22] = new UnoCard(0,11);
		deck[23] = new UnoCard(0,12);
		deck[24] = new UnoCard(0,12);
		
		//Yellow Cards
		deck[25] = new UnoCard(1,0);
		deck[26] = new UnoCard(1,1);
		deck[27] = new UnoCard(1,1);
		deck[28] = new UnoCard(1,2);
		deck[29] = new UnoCard(1,2);
		deck[30] = new UnoCard(1,3);
		deck[31] = new UnoCard(1,3);
		deck[32] = new UnoCard(1,4);
		deck[33] = new UnoCard(1,4);
		deck[34] = new UnoCard(1,5);
		deck[35] = new UnoCard(1,5);
		deck[36] = new UnoCard(1,6);
		deck[37] = new UnoCard(1,6);
		deck[38] = new UnoCard(1,7);
		deck[39] = new UnoCard(1,7);
		deck[40] = new UnoCard(1,8);
		deck[41] = new UnoCard(1,8);
		deck[42] = new UnoCard(1,9);
		deck[43] = new UnoCard(1,9);
		deck[44] = new UnoCard(1,10);
		deck[45] = new UnoCard(1,10);
		deck[46] = new UnoCard(1,11);
		deck[47] = new UnoCard(1,11);
		deck[48] = new UnoCard(1,12);
		deck[49] = new UnoCard(1,12);

		//Blue Cards
		deck[50] = new UnoCard(2,0);
		deck[51] = new UnoCard(2,1);
		deck[52] = new UnoCard(2,1);
		deck[53] = new UnoCard(2,2);
		deck[54] = new UnoCard(2,2);
		deck[55] = new UnoCard(2,3);
		deck[56] = new UnoCard(2,3);
		deck[57] = new UnoCard(2,4);
		deck[58] = new UnoCard(2,4);
		deck[59] = new UnoCard(2,5);
		deck[60] = new UnoCard(2,5);
		deck[61] = new UnoCard(2,6);
		deck[62] = new UnoCard(2,6);
		deck[63] = new UnoCard(2,7);
		deck[64] = new UnoCard(2,7);
		deck[65] = new UnoCard(2,8);
		deck[66] = new UnoCard(2,8);
		deck[67] = new UnoCard(2,9);
		deck[68] = new UnoCard(2,9);
		deck[69] = new UnoCard(2,10);
		deck[70] = new UnoCard(2,10);
		deck[71] = new UnoCard(2,11);
		deck[72] = new UnoCard(2,11);
		deck[73] = new UnoCard(2,12);
		deck[74] = new UnoCard(2,12);
		
		//Green Cards
		deck[75] = new UnoCard(3,0);
		deck[76] = new UnoCard(3,1);
		deck[77] = new UnoCard(3,1);
		deck[78] = new UnoCard(3,2);
		deck[79] = new UnoCard(3,2);
		deck[80] = new UnoCard(3,3);
		deck[81] = new UnoCard(3,3);
		deck[82] = new UnoCard(3,4);
		deck[83] = new UnoCard(3,4);
		deck[84] = new UnoCard(3,5);
		deck[85] = new UnoCard(3,5);
		deck[86] = new UnoCard(3,6);
		deck[87] = new UnoCard(3,6);
		deck[88] = new UnoCard(3,7);
		deck[89] = new UnoCard(3,7);
		deck[90] = new UnoCard(3,8);
		deck[91] = new UnoCard(3,8);
		deck[92] = new UnoCard(3,9);
		deck[93] = new UnoCard(3,9);
		deck[94] = new UnoCard(3,10);
		deck[95] = new UnoCard(3,10);
		deck[96] = new UnoCard(3,11);
		deck[97] = new UnoCard(3,11);
		deck[98] = new UnoCard(3,12);
		deck[99] = new UnoCard(3,12);
		
		//Wild Cards
		deck[100] = new UnoCard(4,13);
		deck[101] = new UnoCard(4,13);
		deck[102] = new UnoCard(4,13);
		deck[103] = new UnoCard(4,13);
		deck[104] = new UnoCard(4,14);
		deck[105] = new UnoCard(4,14);
		deck[106] = new UnoCard(4,14);
		deck[107] = new UnoCard(4,14);
		shuffle();
	}
	
	public UnoCard[] getDeck() {
		return deck;
	}
	
	public static void main(String[] args) {
		Dealer dealerDeck = new Dealer(108);
		UnoCard c;
		dealerDeck.shuffle();
		for(int i = 0; i < 108; i++) {
			 c = dealerDeck.deal();
			 System.out.println((i+1) + "." + c.getCardValue().getValue() + 
 					 " " + c.getColorType().getColor());
		}
	}
	
	public void shuffle() {
        Random randomNumber = new Random();
        //Randomize the deck
        for (int i = 0; i < 108; i++) {
            int rand = randomNumber.nextInt(107) + 1;
            queue.enqueue(deck[rand]);
        }
   }
	
	 public UnoCard deal() { // Deals one card at a time
		  if (Queue.isEmpty(queue)) { // If deck has no cards 
               shuffle();
          }

		  return queue.dequeue();
    }
}