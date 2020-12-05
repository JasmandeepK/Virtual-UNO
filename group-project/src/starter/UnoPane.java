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
	private int cardY = 150;
	
	
	public UnoPane(MainApplication app) {
		super();
		program = app;
		
		unoButton = new GButton("UNO", MainApplication.WINDOW_WIDTH - 105, MainApplication.WINDOW_HEIGHT - 595, 100, 100);
		unoButton.setColor(Color.WHITE);
		unoButton.setFillColor(Color.YELLOW);
		drawCard = new GButton("DRAW CARD", MainApplication.WINDOW_WIDTH - 795, MainApplication.WINDOW_HEIGHT - 595, 150, 100);
		drawCard.setColor(Color.WHITE);
		drawCard.setFillColor(Color.RED);
		player1 = new Player(0);
		player2 = new Player(1);
		deck = new Dealer(108);
		for(int i = 0; i < 7; i++) {
			player1.addToHand(deck.deal());
			player2.addToHand(deck.deal());
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
				if(i == 5) {
					cardY = 400;
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
		displayCards(player1);
		
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
//		if(obj == ) {
//			
//		}
		
	}
}
