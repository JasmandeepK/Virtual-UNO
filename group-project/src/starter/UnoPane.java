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
	private String winnerName;
	
	
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
	
	public void checkWin() {
		if(player1.getNumCards() == 0) {
			winnerName = player2.getPlayerName();
			program.switchToWinPane();
		}
		else if(player2.getNumCards() == 0) {
			winnerName = player1.getPlayerName();
			program.switchToWinPane();
		}
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
	
	public UnoCard userCardPressed() {
		
		return cardClicked;
	}
	
	@Override
	public void showContents() {
		// TODO Auto-generated method stub
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
		checkWin();

	}

	@Override
	public void hideContents() {
		// TODO Auto-generated method stub
		program.removeAll();
		showContents();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj instanceof GImage && obj != currCardDisplayed) {
			
			hideContents();
		}
		if(obj == drawCard) {
			getCurrentPlayer().addToHand(deck.deal());
			hideContents();
		}
		if(obj == unoButton) {
			if(getCurrentPlayer().getNumCards() == 1){
				winnerName = getCurrentPlayer().getPlayerName();
				program.switchToWinPane();
			}
		}
		
	}
}
