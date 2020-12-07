//This file creates the opening screen of the program.
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
	private GButton dirButton;
	private GLabel playLabel;
	private GLabel dirLabel;
	private GLabel welcomeLabel;
	private GImage card1;
	private GImage card2;
	private GImage card3;
	private GImage card4;
	private GImage card5;
	public static final int cardSizeX = 400;
	public static final int cardSizeY = 570;
	public static final int cardPosY = 210;

	
	public MenuPane(MainApplication app) {
		super();
		program = app;
		
		//play button
		playButton = new GButton("", 815, 600, 170, 75);
		playButton.setFillColor(Color.YELLOW);
		
		//play label on top of play button
		playLabel = new GLabel("PLAY", 830, 655);
		playLabel.setFont("TimesRoman-Bold-52");
		playLabel.setColor(Color.WHITE);
		
		dirButton = new GButton("", 740, 800, 315, 75);
		dirButton.setFillColor(Color.ORANGE);
		
		//play label on top of play button
		dirLabel = new GLabel("DIRECTIONS", 750, 855);
		dirLabel.setFont("TimesRoman-Bold-48");
		dirLabel.setColor(Color.WHITE);
		
		//welcome label
		welcomeLabel = new GLabel("WELCOME TO VIRTUAL UNO", 170, 150);
		welcomeLabel.setFont("TimesRoman-Bold-100");
		welcomeLabel.setColor(Color.RED);
		
		//cards
		card1 = new GImage("Wild/+4.png", 350, cardPosY);
		card1.setSize(cardSizeX, cardSizeY + 2);
		card2 = new GImage("Blue/+2.png", 525, cardPosY - 5);
		card2.setSize(cardSizeX, cardSizeY + 12);
		card3 = new GImage("Green/1.png", 700, cardPosY);
		card3.setSize(cardSizeX, cardSizeY);
		card4 = new GImage("Yellow/3.png", 875, cardPosY);
		card4.setSize(cardSizeX, cardSizeY);
		card5 = new GImage("Red/reverse.png", 1050, cardPosY);
		card5.setSize(cardSizeX, cardSizeY);
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
		program.add(dirButton);
		program.add(dirLabel);
		program.add(welcomeLabel);
	}

	@Override
	public void hideContents() {
		program.remove(playButton);
		program.remove(playLabel);
		program.add(dirButton);
		program.add(dirLabel);
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
