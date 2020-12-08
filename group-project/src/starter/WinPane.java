//This class displays the win screen
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
		
		//win label
		winLabel = new GLabel("Congratulations!!!! You Won!!!!", 600, 200);
		winLabel.setFont("TimesRoman-Bold-50");
		
		//thanks label thanks players for playing
		thanks = new GLabel(" Thanks for Playing UNO", 650, 500);
		thanks.setFont("TimesRoman-Bold-50");
		
		//balloon adds an image of balloons
		balloon = new GImage("balloons.png", 200, 0);
		balloon.setSize(1400, 900);
	}
	
	@Override
	public void showContents() {
		program.add(balloon);
		program.add(winLabel);
		program.add(thanks);
		
	}

	@Override
	public void hideContents() {
		program.remove(balloon);
		program.remove(winLabel);
		program.remove(thanks);
	}
}
