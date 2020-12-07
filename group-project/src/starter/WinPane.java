package starter;

import java.awt.event.MouseEvent;

import acm.graphics.*;

public class WinPane extends GraphicsPane {
	private MainApplication program;
	private GLabel winLabel;
	private GLabel thanks;
	private GImage balloon;
	
	public WinPane(MainApplication app) {
		super();
		program = app;
		
		winLabel = new GLabel("Congratulations!!!! You Won!!!!", 600, 200);
		winLabel.setFont("TimesRoman-Bold-50");
		thanks = new GLabel(" Thanks for Playing UNO", 650, 500);
		thanks.setFont("TimesRoman-Bold-50");
		balloon = new GImage("balloons.png", 200, 0);
		balloon.setSize(1400, 900);
	}
	
	@Override
	public void showContents() {
		// TODO Auto-generated method stub
		program.add(balloon);
		program.add(winLabel);
		program.add(thanks);
		
	}

	@Override
	public void hideContents() {
		// TODO Auto-generated method stub
		program.remove(balloon);
		program.remove(winLabel);
		program.remove(thanks);
	}
}
