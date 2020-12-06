package starter;
public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 1800;
	public static final int WINDOW_HEIGHT = 900;

	private MenuPane menu;
	private UsernamePane usernameScreen;
	private UsernamePane2 usernameScreen2;
	private UnoPane unoPane;
	private WinPane winPane;

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
		menu = new MenuPane(this);
		usernameScreen = new UsernamePane(this);
		usernameScreen2 = new UsernamePane2(this);
		unoPane = new UnoPane(this);
		winPane = new WinPane(this);
		switchToMenu();
	}
	
	public void setPlayer1Name(String name) {
		unoPane.getPlayer1().setName(name);
	}
	
	public void setPlayer2Name(String name) {
		unoPane.getPlayer2().setName(name);
	}
	
	public String getWinningPlayerName() {
		return unoPane.getWinningPlayerName();
	}
	
	public void switchToMenu() {
		switchToScreen(menu);
	}
	
	public void switchToFirstUser() {
		switchToScreen(usernameScreen);
	}
	
	public void switchToSecondUser() {
		switchToScreen(usernameScreen2);
	}
	
	public void switchToUnoPane() {
		switchToScreen(unoPane);
	}
	
	public void switchToWinPane(){
		switchToScreen(winPane);
	}
}
