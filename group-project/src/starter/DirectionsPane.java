//This file creates the information in the directions page

//Was unable to get multiline
package starter;

import java.awt.Color;
import acm.graphics.GLabel;


import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import acm.graphics.*;
import javafx.scene.text.Text;

public class DirectionsPane extends GraphicsPane {
	private MainApplication program;
	
	private GButton backButton;
	private GLabel backLabel;
	private GLabel DirectionsLabel;
	private GLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12, label13;
	
	public DirectionsPane(MainApplication app) {
		super();
		program = app;
		
		//Directions label 
		DirectionsLabel = new GLabel("UNO DIRECTIONS: ", 560, 100);
		DirectionsLabel.setFont("TimesRoman-Bold-70");
		DirectionsLabel.setColor(Color.RED);
		
		//Back button and label
		backButton = new GButton("", 810, 800, 180, 75);
		backButton.setFillColor(Color.ORANGE);
		backLabel = new GLabel("BACK", 830, 855);
		backLabel.setFont("TimesRoman-Bold-48");
		backLabel.setColor(Color.WHITE);
		
		label1 = new GLabel ("Both players start off with seven hands. The top card of the deck is where all the cards will be played. Player 1 will begin the game.", 150, 200);
		label2= new GLabel ("On a players turn they must do one of the following:", 150, 250);
		label3= new GLabel ("    -Play a card that matches the top card of the deck in color, number, or symbol.", 150, 280);
		label4= new GLabel ("    -Play a WILD or WILD draw 4 card", 150, 310);
		label5= new GLabel ("    -Click the draw card button", 150, 340);
		label6= new GLabel ("Once a player has one card left they must click the UNO button first before playing their last card.", 150, 380);
		label7= new GLabel ("If they fail to do that they will be given two cards and it will be the next players turn", 150, 410);
		label8= new GLabel ("Action Cards: ", 150, 460);
		label9= new GLabel ("    -REVERSE: the play is reversed back to the person that placed the card ", 150, 490); 
		label10= new GLabel ("   -SKIP: Next player misses a turn (for 1v1 is works the same as a reverse card)", 150, 520);
		label11= new GLabel ("   -DRAW TWO: The other player will be given two cards ", 150, 550);  
		label12= new GLabel ("   -WILD: Can be placed on top of any card. The person that plays it can change the color of the deck.", 150, 580); 
		label13= new GLabel ("   -WILD DRAW 4: The person that plays it can change the color of the deck and the other player will be given 4 cards.", 150, 610);
		
		label1.setFont("TimesRoman-Bold-20");
		label1.setColor(Color.black);
		
		label2.setFont("TimesRoman-Bold-20");
		label2.setColor(Color.black);
		
		label3.setFont("TimesRoman-Bold-20");
		label3.setColor(Color.black);
		
		label4.setFont("TimesRoman-Bold-20");
		label4.setColor(Color.black);
		
		label5.setFont("TimesRoman-Bold-20");
		label5.setColor(Color.black);
		
		label6.setFont("TimesRoman-Bold-20");
		label6.setColor(Color.black);
		
		label7.setFont("TimesRoman-Bold-20");
		label7.setColor(Color.black);
		
		label8.setFont("TimesRoman-Bold-20");
		label8.setColor(Color.black);
		
		label9.setFont("TimesRoman-Bold-20");
		label9.setColor(Color.black);
		
		label10.setFont("TimesRoman-Bold-20");
		label10.setColor(Color.black);
		
		label11.setFont("TimesRoman-Bold-20");
		label11.setColor(Color.black);
		
		label12.setFont("TimesRoman-Bold-20");
		label12.setColor(Color.black);
		
		label13.setFont("TimesRoman-Bold-20");
		label13.setColor(Color.black);

	}
	
	@Override
	public void showContents() {
		program.add(backButton);
		program.add(backLabel);
		program.add(DirectionsLabel);
		program.add(label1);
		program.add(label2);
		program.add(label3);
		program.add(label4);
		program.add(label5);
		program.add(label6);
		program.add(label7);
		program.add(label8);
		program.add(label9);
		program.add(label10);
		program.add(label11);
		program.add(label12);
		program.add(label13);

	}

	@Override
	public void hideContents() {
		program.remove(backButton);
		program.remove(backLabel);
		program.remove(DirectionsLabel);
		program.remove(label1);
		program.remove(label2);
		program.remove(label3);
		program.remove(label4);
		program.remove(label5);
		program.remove(label6);
		program.remove(label7);
		program.remove(label8);
		program.remove(label9);
		program.remove(label10);
		program.remove(label11);
		program.remove(label12);
		program.remove(label13);


	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == backButton) {
			program.switchToMenu();	
		}
		if (obj == backLabel) {
			program.switchToMenu();	
		}
	}

}
