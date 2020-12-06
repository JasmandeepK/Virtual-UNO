package starter;

import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class WinPane extends GraphicsPane {
	private MainApplication program;
	private GLabel winLabel;
	private GLabel thanks;
	
	public WinPane(MainApplication app) {
		super();
		program = app;
		
		winLabel = new GLabel(program.getWinningPlayerName() + " Wins! Congratulations!!!!", 600, 200);
		winLabel.setFont("TimesRoman-Bold-50");
		thanks = new GLabel(" Thanks for Playing UNO", 650, 500);
		thanks.setFont("TimesRoman-Bold-50");
		
		
	}
	
	@Override
	public void showContents() {
		// TODO Auto-generated method stub
		program.add(winLabel);
		program.add(thanks);
		
	}

	@Override
	public void hideContents() {
		// TODO Auto-generated method stub
		program.remove(winLabel);
		program.remove(thanks);
	}
}
