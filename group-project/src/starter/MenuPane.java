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
	
	public MenuPane(MainApplication app) {
		super();
		program = app;
		playButton = new GButton("", 200, 200, 100, 50);
		playButton.setFillColor(Color.YELLOW);
		playLabel = new GLabel("PLAY", 220, 235);
		playLabel.setFont("TimesRoman-Bold-24");
		playLabel.setColor(Color.WHITE);
		
	}

	@Override
	public void showContents() {
		program.add(playButton);
		program.add(playLabel);
	}

	@Override
	public void hideContents() {
		program.remove(playButton);
		program.remove(playLabel);
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
