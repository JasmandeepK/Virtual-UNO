package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.*;

public class UnoPane extends GraphicsPane {
	private MainApplication program;
	private GButton unoButton;
	private GButton drawCard;
	private GImage currCardDisplayed;
	private GLabel playerHand1;
	private GLabel playerHand2;
	private Player player1;
	private Player player2;
	private Dealer deck;
	private UnoCard currentCard;
	private UnoCard cardClicked;
	private boolean player1Turn = true;
	private int cardY;
	private int cardX;
	private String colorChange = "";
	private String winnerName;
	private GLabel prompt;
	private GButton red;
	private GButton blue;
	private GButton green;
	private GButton yellow;
	private boolean wildCase = false;
	
	
	public UnoPane(MainApplication app) {
		super();
		program = app;
		
		//Creates UNO button 
		unoButton = new GButton("UNO", 1550,25, 200, 200);
		unoButton.setColor(Color.WHITE);
		unoButton.setFillColor(Color.YELLOW);
		
		//Creates DRAW CARD button
		drawCard = new GButton("DRAW CARD", 50, 100, 250, 100);
		drawCard.setColor(Color.WHITE);
		drawCard.setFillColor(Color.RED);
		
		//Shown when Player 1's hand is visible 
		playerHand1 = new GLabel("Player 1", 1600,875);
		playerHand1.setFont("TimesRoman-Bold-45");
		playerHand1.setColor(Color.BLACK);
		
		//Shown when Player 2's hand is visible
		playerHand2 = new GLabel("Player 2", 1600,875);
		playerHand2.setFont("TimesRoman-Bold-45");
		playerHand2.setColor(Color.BLACK);
		
		//Initializes both players
		player1 = new Player(0);
		player2 = new Player(1);
		
		//Initializes deck
		deck = new Dealer(108);
		for(int i = 0; i < 7; i++) {
			player1.addToHand(deck.deal());
			player2.addToHand(deck.deal());
		}
		
		//current card
		currentCard = deck.deal();
		while(currentCard.getColorType().getColor() == "Wild") {
			currentCard = deck.deal();
		}
		

		prompt = new GLabel("Choose a Color:", 700, 100);
		prompt.setFont("TimesRoman-Bold-50");
		red = new GButton("", 50, 300, 300,300);
		red.setFillColor(Color.RED);
		blue = new GButton("", 500, 300, 300,300);
		blue.setFillColor(Color.BLUE);
		green = new GButton("", 950, 300, 300,300);
		green.setFillColor(Color.GREEN);
		yellow = new GButton("", 1400, 300, 300,300);
		yellow.setFillColor(Color.YELLOW);
	}
	
	public Player getPlayer1() {
		return player1;
	}
	
	public Player getPlayer2() {
		return player2;
	}
	
	public void displayCards(Player player) {
		for(int i = 0; i < player.getPlayerHand().length; i++) {
			if(player.getPlayerHand()[i] != null) {
				if(i% 25 < 12) {	cardY = 250;} else if(i % 25 < 24) { cardY = 470;} else {cardY = 690;}
				cardX = (i%12)*150+20;
				String filepath = player.getPlayerHand()[i].getColorType().getColor() + "/" + player.getPlayerHand()[i].getCardValue().getValue() + ".png";
				GImage card = new GImage(filepath, cardX,cardY);
				card.setSize(100, 200);
				int[] location = {cardX, cardY, cardX+100, cardY+200};
				player.setCoordinates(i, location);
				program.add(card);
			}
		}
	}
	
	public void displayCurrentCard(UnoCard card) {
		String path = card.getColorType().getColor() + "/" + card.getCardValue().getValue() + ".png";
		currCardDisplayed = new GImage(path, 850, 25);
		currCardDisplayed.setSize(100, 200);
		program.add(currCardDisplayed);	
	}
	
	public String getWinningPlayerName() {
		return winnerName;
	}
	
	public Player getCurrentPlayer() {
		if(player1Turn) {
			return player2;	
		}
		else {
			return player1;	
		}
	}
	
	public int[] getObjSpace(GObject obj) {
		int[] space = new int[4];
		space[0] = (int) obj.getX();
		space[1] = (int) obj.getY();
		space[2] = (int) (obj.getX() + obj.getWidth());
		space[3] = (int) (obj.getY() + obj.getHeight());
		return space;
	}
	
	public UnoCard userCardPressed(GObject obj) {
		int[] location = getObjSpace(obj);
		for(int i = 0; i < getCurrentPlayer().playerHand.length; i++) {
			if(getCurrentPlayer().playerHand[i] != null) {
				if(getCurrentPlayer().playerHand[i].getCoordinates()[0] == location[0] &&
					getCurrentPlayer().playerHand[i].getCoordinates()[1] == location[1] &&
					getCurrentPlayer().playerHand[i].getCoordinates()[2] == location[2] &&
					getCurrentPlayer().playerHand[i].getCoordinates()[3] == location[3]) {
					cardClicked = getCurrentPlayer().playerHand[i];
					
					if(cardClicked.getColorType().getColor() == "Wild") {
						wildCase = true;
					}
					return cardClicked;
				}
			}
		}
		return null;
	}
	
	public boolean validateCard(GObject obj) {
		UnoCard card = userCardPressed(obj);
		if(card != null) {
			if(currentCard.getColorType().getColor() == card.getColorType().getColor()) {
				return true;
			}
			else if(currentCard.getCardValue().getValue() == card.getCardValue().getValue()) {
				return true;
			}
			else if(card.getColorType().getColor() == "Wild") {
				return true;
			}
			else if(card.getColorType().getColor() == colorChange) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkCardMatch(UnoCard card1, UnoCard card2) {
		if(card1.getColorType().getColor() == card2.getColorType().getColor() &&
			card1.getCardValue().getValue() == card2.getCardValue().getValue() &&
			card1.getCoordinates()[0] == card2.getCoordinates()[0] &&
			card1.getCoordinates()[1] == card2.getCoordinates()[1] &&
			card1.getCoordinates()[2] == card2.getCoordinates()[2] &&
			card1.getCoordinates()[3] == card2.getCoordinates()[3]) {
				return true;
		}
		return false;
	}
	
	public void changeHands() {
		currentCard = cardClicked;
		for(int i = 0; i < getCurrentPlayer().getPlayerHand().length; i++) {
			if(getCurrentPlayer().getPlayerHand()[i] != null) {
				if(checkCardMatch(cardClicked, getCurrentPlayer().getPlayerHand()[i])) {
					getCurrentPlayer().removeFromHand(i);
					return;
				}
			}
		}
	}
	
	public void affectPlayerTurn() {
		if(getCurrentPlayer() == player1) {
			player1Turn = true;
		}
		else {
			player1Turn = false;
		}
	}
	
	public void affectNextPlayer() {
		if(currentCard.getCardValue().getValue() == "+4") {
			affectPlayerTurn();
		}
		else if(currentCard.getCardValue().getValue() == "skip") {
			affectPlayerTurn();
		}
		else if(currentCard.getCardValue().getValue() == "reverse") {
			affectPlayerTurn();
		}
		else if(currentCard.getCardValue().getValue() == "+2" ) {
			affectPlayerTurn();
		}
	}
	
	@Override
	public void showContents() {
		program.add(unoButton);
		program.add(drawCard);
		if(player1Turn) {
			displayCards(player1);
			program.add(playerHand1);
			player1Turn = false;
		}
		else {
			displayCards(player2);
			program.add(playerHand2);
			player1Turn = true;
		}	
		displayCurrentCard(currentCard);
		if(wildCase) {
			program.removeAll();
			program.add(prompt);
			program.add(red);
			program.add(yellow);
			program.add(blue);
			program.add(green);
		}

	}

	@Override
	public void hideContents() {
		// TODO Auto-generated method stub
		program.removeAll();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj instanceof GImage && obj != currCardDisplayed) {
			if(validateCard(obj)) {
				changeHands();
				affectNextPlayer();
				hideContents();
				showContents();
				if(player1.getNumCards() == 0) {
					winnerName = player2.getPlayerName();
					hideContents();
					program.switchToWinPane();
				}
				else if(player2.getNumCards() == 0) {
					winnerName = player1.getPlayerName();
					hideContents();
					program.switchToWinPane();
				}
			}
		}
		if(obj == drawCard) {
			getCurrentPlayer().addToHand(deck.deal());
			hideContents();
			showContents();
		}
		if(obj == unoButton) {
			if(getCurrentPlayer().getNumCards() == 1){
				winnerName = getCurrentPlayer().getPlayerName();
				program.switchToWinPane();
			}
		}
		if (obj == red) {
			colorChange = "Red";
			wildCase = false;
			hideContents();
			showContents();
		}
		if (obj == yellow) {
			colorChange = "Yellow";
			wildCase = false;
			hideContents();
			showContents();
		}
		if (obj == blue) {
			colorChange = "Blue";
			wildCase = false;
			hideContents();
			showContents();
		}
		if (obj == green) {
			colorChange = "Green";
			wildCase = false;
			hideContents();
			showContents();
		}
		
	}
}
