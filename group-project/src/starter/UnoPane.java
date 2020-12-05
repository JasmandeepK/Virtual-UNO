package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class UnoPane extends GraphicsPane {
	private MainApplication program;
	private GButton unoButton;
	private GButton drawCard;
	private Player player1;
	private Player player2;
	private Dealer deck;
	private boolean player1Turn = true;
	private int cardY = 200;
	
	
	public UnoPane(MainApplication app) {
		super();
		program = app;
		
		unoButton = new GButton("UNO", MainApplication.WINDOW_WIDTH - 105, MainApplication.WINDOW_HEIGHT - 695, 100, 100);
		unoButton.setColor(Color.WHITE);
		unoButton.setFillColor(Color.YELLOW);
		drawCard = new GButton("DRAW CARD", MainApplication.WINDOW_WIDTH - 795, MainApplication.WINDOW_HEIGHT - 695, 150, 100);
		drawCard.setColor(Color.WHITE);
		drawCard.setFillColor(Color.RED);
		player1 = new Player(0);
		player2 = new Player(1);
		deck = new Dealer(108);
		for(int i = 0; i < 7; i++) {
			player1.addToHand(deck.deal());
			player2.addToHand(deck.deal());
		}
		System.out.println("Player1:");
		for(int i = 0; i < player1.getPlayerHand().length; i++) {
			if(player1.getPlayerHand()[i] != null) {
				System.out.println(player1.getPlayerHand()[i].getColorType().getColor() + ": " + player1.getPlayerHand()[i].getCardValue().getValue());
			}
		}
		System.out.println("Player2:");
		for(int i = 0; i < player2.getPlayerHand().length; i++) {
			if(player1.getPlayerHand()[i] != null) {
				System.out.println(player2.getPlayerHand()[i].getColorType().getColor() + ": " + player2.getPlayerHand()[i].getCardValue().getValue());
			}
		}
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
				if(i% 10 < 5) {
					cardY = 200;
				}
				else {
					cardY = 420;
				}
				String filepath = player.getPlayerHand()[i].getColorType().getColor() + "/" + player.getPlayerHand()[i].getCardValue().getValue() + ".png";
				GImage card = new GImage(filepath, (i%5)*150+20,cardY);
				card.setSize(100, 200);
				program.add(card);
			}
		}
	}
	
	@Override
	public void showContents() {
		// TODO Auto-generated method stub
		program.add(unoButton);
		program.add(drawCard);
		if(player1Turn) {
			displayCards(player1);
			player1Turn = false;
		}
		else {
			displayCards(player2);
			player1Turn = true;
		}
		
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
		if (obj instanceof GImage) {
			hideContents();
		}
//		if(obj == unoButton) {
//			
//		}
		
	}
}
