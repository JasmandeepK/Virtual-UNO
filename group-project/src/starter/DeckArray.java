package starter;
import java.util.ArrayList;
import javax.smartcardio.Card;

class Deck {

	ArrayList<Card> pile;
	ArrayList<Card> cards;

	public Deck(ArrayList<Card> c) {
		cards = c;
	}

	public Deck() {
		cards = new ArrayList<Card>(108);
	}

	public void addCard(Card c) {
		cards.add(c);
	}

}