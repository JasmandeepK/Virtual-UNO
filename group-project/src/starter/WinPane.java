package starter;

import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class WinPane extends GraphicsPane {
	private MainApplication program;
	private GLabel winLabel;
	private GButton playAgain;
	
	public WinPane(MainApplication app) {
		super();
		program = app;
		
		playAgain = new GButton("Play Again", 200, 200, 200, 200);
		
	}
	
	@Override
	public void showContents() {
		// TODO Auto-generated method stub
		program.add(playAgain);
		
	}

	@Override
	public void hideContents() {
		// TODO Auto-generated method stub
		program.remove(playAgain);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == playAgain) {
			program.switchToMenu();
		}
	}
}
