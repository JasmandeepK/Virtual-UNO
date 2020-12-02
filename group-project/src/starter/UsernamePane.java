package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.*;

import acm.program.*;
import acm.graphics.*;

public class UsernamePane extends GraphicsPane {
	private MainApplication program;
	
	private GButton nextButton;
	private GLabel nextLabel;
	private GLabel prompt;
	
	public UsernamePane(MainApplication app) {
		super();
		program = app;
		
		//next label
		nextButton = new GButton("", 325, 300, 100, 50);
		nextButton.setFillColor(Color.YELLOW);
		
		//next label on top of next button
		nextLabel = new GLabel("NEXT", 345, 335);
		nextLabel.setFont("TimesRoman-Bold-24");
		nextLabel.setColor(Color.WHITE);
		
	}

	@Override
	public void showContents() {
		program.add(nextButton);
		program.add(nextLabel);
	}

	@Override
	public void hideContents() {
		program.remove(nextButton);
		program.remove(nextLabel);
		//program.remove(prompt);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == nextButton) {
			program.switchToSome();
		}
		if (obj == nextLabel) {
			program.switchToSome();
		}
	}
}
