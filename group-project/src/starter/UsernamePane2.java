package starter;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;


import java.awt.*;
import java.awt.TextField;


import acm.program.*;
import acm.graphics.*;

public class UsernamePane2 extends GraphicsPane implements ActionListener {
	private MainApplication program;
	
	private GButton nextButton;
	private GLabel nextLabel;
	private GLabel prompt;
	private JTextField userInputted;
	private static final Font initFont= new Font("Arial", Font.BOLD, 25);
	private String input = "";
	public UsernamePane2(MainApplication app) {
		super();
		
		program = app;
		userInputted = new JTextField("Enter username:");
		userInputted.setFont(initFont);
		userInputted.setEnabled(true);
		userInputted.setBounds(200, 200, 500, 50);
		
		//next label
		nextButton = new GButton("", 325, 300, 100, 50);
		nextButton.setFillColor(Color.YELLOW);
		
		//next label on top of next button
		nextLabel = new GLabel("NEXT", 345, 335);
		nextLabel.setFont("TimesRoman-Bold-24");
		nextLabel.setColor(Color.WHITE);
		
		//prompt
		prompt = new GLabel("ENTER IN A USERNAME FOR PLAYER TWO:", 100,100);
		prompt.setFont("TimesRoman-Bold-30");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(userInputted.isEnabled()) {
			char key = e.getKeyChar();
			if (!(key == KeyEvent.VK_BACK_SPACE)) {
				input += key;
			}
			else {
				if (input.length()>0) {
					input = input.substring(0, input.length()-1);
				}
			}
			setName(input);
		}
	}
	private void setName(String name) {
		if(name.length()==0) {
			userInputted.setText("Enter username:");
		}
		else {
			userInputted.setText(name);
		}
	}


	@Override
	public void showContents() {
		program.add(nextButton);
		program.add(nextLabel);
		program.add(prompt);
		program.add(userInputted);
	}

	@Override
	public void hideContents() {
		program.remove(nextButton);
		program.remove(nextLabel);
		program.remove(prompt);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		program.setPlayer2Name(input);
		if (obj == nextButton) {
			program.switchToUnoPane();
		}
		if (obj == nextLabel) {
			program.switchToUnoPane();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
