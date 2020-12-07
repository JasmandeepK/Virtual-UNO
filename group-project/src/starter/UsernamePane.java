package starter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JTextField;

import java.awt.*;


import acm.graphics.*;

public class UsernamePane extends GraphicsPane implements ActionListener {
	private MainApplication program;
	
	private GButton nextButton;
	private GLabel nextLabel;
	private GLabel prompt;
	private JTextField userInputted;
	private static final Font initFont= new Font("Arial", Font.BOLD, 50);
	private String input = "";	
	public UsernamePane(MainApplication app) {
		super();
		
		program = app;
		userInputted = new JTextField("Enter username:");
		userInputted.setFont(initFont);
		userInputted.setEnabled(true);
		userInputted.setBounds(400, 300, 1000, 100);
		
		//next label
		nextButton = new GButton("", 825, 600, 150, 70);
		nextButton.setFillColor(Color.YELLOW);
		
		//next label on top of next button
		nextLabel = new GLabel("NEXT", 837, 650);
		nextLabel.setFont("TimesRoman-Bold-50");
		nextLabel.setColor(Color.WHITE);
		
		//prompt
		prompt = new GLabel("ENTER IN A USERNAME FOR PLAYER ONE:", 150,150);
		prompt.setFont("TimesRoman-Bold-70");
		
		
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
		program.remove(userInputted);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		program.setPlayer1Name(input);
		System.out.println(program.getPlayer1Name());
		if (obj == nextButton) {
			program.switchToSecondUser();
		}
		if (obj == nextLabel) {
			program.switchToSecondUser();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
