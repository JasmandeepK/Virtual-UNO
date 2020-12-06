package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.*;

import acm.program.*;
import acm.graphics.*;

public class MenuPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GButton playButton;
	private GLabel playLabel;
	private GLabel welcomeLabel;
	private GImage card1;
	private GImage card2;
	private GImage card3;
	private GImage card4;
	private GImage card5;
	
	public MenuPane(MainApplication app) {
		super();
		program = app;
		
		//play button
		playButton = new GButton("", 825, 600, 158, 65);
		playButton.setFillColor(Color.YELLOW);
		
		//play label on top of play button
		playLabel = new GLabel("PLAY", 837, 650);
		playLabel.setFont("TimesRoman-Bold-50");
		playLabel.setColor(Color.WHITE);
		
		//welcome label
		welcomeLabel = new GLabel("WELCOME TO VIRTUAL UNO", 150, 150);
		welcomeLabel.setFont("TimesRoman-Bold-100");
		welcomeLabel.setColor(Color.RED);
		
		//cards
		card1 = new GImage("Wild/+4.png", 350, 200);
		card1.setSize(400, 570);
		card2 = new GImage("Blue/+2.png", 525, 195);
		card2.setSize(400, 580);
		card3 = new GImage("Green/1.png", 700, 200);
		card3.setSize(400, 570);
		card4 = new GImage("Yellow/3.png", 875, 200);
		card4.setSize(400, 570);
		card5 = new GImage("Red/reverse.png", 1050, 200);
		card5.setSize(400, 570);
	}

	@Override
	public void showContents() {
		program.add(card1);
		program.add(card2);
		program.add(card3);
		program.add(card4);
		program.add(card5);
		program.add(playButton);
		program.add(playLabel);
		program.add(welcomeLabel);
	}

	@Override
	public void hideContents() {
		program.remove(playButton);
		program.remove(playLabel);
		program.remove(welcomeLabel);
		program.remove(card1);
		program.remove(card2);
		program.remove(card3);
		program.remove(card4);
		program.remove(card5);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == playButton) {
			program.switchToFirstUser();
		}
		if (obj == playLabel) {
			program.switchToFirstUser();
		}
	}
}
