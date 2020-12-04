package starter;

import acm.graphics.GImage;

public class UnoPane extends GraphicsPane {
	private MainApplication program;
	private GButton unoButton;
	private Player player1;
	private Player player2;
	private Dealer deck;
	private boolean player1Turn = true;
	
	public UnoPane(MainApplication app) {
		super();
		program = app;
		
		unoButton = new GButton("UNO", MainApplication.WINDOW_WIDTH - 105, MainApplication.WINDOW_HEIGHT - 105, 100, 100);
		player1 = new Player(0);
		player2 = new Player(1);
		deck = new Dealer(108);
		for(int i = 0; i <5; i++) {
			player1.addToHand(deck.deal());
			player2.addToHand(deck.deal());
		}
	}
	
	@Override
	public void showContents() {
		// TODO Auto-generated method stub
		program.add(unoButton);
		
		for(int i = 0; i < player1.getPlayerHand().length; i++) {
			if(player1.getPlayerHand()[i] != null) {
				String filepath = player1.getPlayerHand()[i].getColorType().getColor() + "/" + player1.getPlayerHand()[i].getCardValue().getValue() + ".png";
				GImage card = new GImage(filepath, i*50,100);
				program.add(card);
			}
		}
		
	}

	@Override
	public void hideContents() {
		// TODO Auto-generated method stub
		
	}

}
