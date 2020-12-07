//This class is the comes in between each player's turn
package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.*;

public class SwitchPane extends GraphicsPane{
	MainApplication program;
	private GLabel prompt;
	private GButton ready;
	
	public SwitchPane(MainApplication app) {
		super();
		program = app;
		ready = new GButton("Ready", 825, 600, 250, 170);
		ready.setFillColor(Color.YELLOW);
		ready.setColor(Color.WHITE);
		
		//welcome label
		prompt = new GLabel("Is the next player ready?", 300, 150);
		prompt.setFont("TimesRoman-Bold-100");
		prompt.setColor(Color.RED);
	}
	
	@Override
	public void showContents() {
		// TODO Auto-generated method stub
		program.add(prompt);
		program.add(ready);
	}

	@Override
	public void hideContents() {
		// TODO Auto-generated method stub
		program.remove(prompt);
		program.remove(ready);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == ready) {
			program.switchToUnoPane();
		}
	}

}
