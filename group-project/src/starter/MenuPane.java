package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.*;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class MenuPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GButton playButton;
	private GLabel playLabel;
	private GLabel welcomeLabel;
	
	public MenuPane(MainApplication app) {
		super();
		program = app;
		
		//play button
		playButton = new GButton("", 350, 300, 100, 50);
		playButton.setFillColor(Color.YELLOW);
		
		//play label on top of play button
		playLabel = new GLabel("PLAY", 370, 335);
		playLabel.setFont("TimesRoman-Bold-24");
		playLabel.setColor(Color.WHITE);
		
		//welcome label
		welcomeLabel = new GLabel("WELCOME TO VIRTUAL UNO", 50, 50);
		welcomeLabel.setFont("TimesRoman-Bold-50");
		welcomeLabel.setColor(Color.RED);
	}

	@Override
	public void showContents() {
		program.add(playButton);
		program.add(playLabel);
		program.add(welcomeLabel);
	}

	@Override
	public void hideContents() {
		program.remove(playButton);
		program.remove(playLabel);
		program.remove(welcomeLabel);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == playButton) {
			program.switchToSome();
		}
		if (obj == playLabel) {
			program.switchToSome();
		}
	}
}
