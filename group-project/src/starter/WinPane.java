package starter;

import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class WinPane extends GraphicsPane {
	private MainApplication program;
	private GLabel winLabel;
	private GLabel thanks;
	private GImage balloon1;
	private GImage balloon2;
	private GImage balloon3;
	
	public WinPane(MainApplication app) {
		super();
		program = app;
		
		winLabel = new GLabel(program.getWinningPlayerName() + " Wins! Congratulations!!!!", 600, 200);
		winLabel.setFont("TimesRoman-Bold-50");
		thanks = new GLabel(" Thanks for Playing UNO", 650, 500);
		thanks.setFont("TimesRoman-Bold-50");
		balloon1 = new GImage("balloons.webp", 200, 200);
		balloon1.setSize(500, 500);
	}
	
	@Override
	public void showContents() {
		// TODO Auto-generated method stub
		program.add(balloon1);
		program.add(winLabel);
		program.add(thanks);
		
	}

	@Override
	public void hideContents() {
		// TODO Auto-generated method stub
		program.remove(balloon1);
		program.remove(winLabel);
		program.remove(thanks);
	}
}
