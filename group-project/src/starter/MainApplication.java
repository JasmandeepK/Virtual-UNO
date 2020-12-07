package starter;
public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 1800;
	public static final int WINDOW_HEIGHT = 900;

	private MenuPane menu;
	private UsernamePane usernameScreen;
	private UsernamePane2 usernameScreen2;
	private DirectionsPane directionsScreen;
	private UnoPane unoPane;
	private WinPane winPane;
	private SwitchPane switchPane;
	private Player player1 = new Player(0);
	private Player player2 = new Player(1);
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
		menu = new MenuPane(this);
		usernameScreen = new UsernamePane(this);
		usernameScreen2 = new UsernamePane2(this);
		directionsScreen = new DirectionsPane(this);
		unoPane = new UnoPane(this);
		winPane = new WinPane(this);
		switchPane = new SwitchPane(this);
		switchToMenu();
	}
	
	public String getPlayer1Name() {
		return unoPane.getPlayer1().getPlayerName();
	}
	
	public void setPlayer1Name(String name) {
		player1.setName(name);
	}
	
	public void setPlayer2Name(String name) {
		player2.setName(name);
	}
	
	public Player getPlayer1() {
		return player1;
	}
	
	public Player getPlayer2() {
		return player2;
	}
	
	public void switchToMenu() {
		switchToScreen(menu);
	}
	
	public void switchToDirections() {
		switchToScreen(directionsScreen);
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
	
	public void switchToSwitchPane() {
		switchToScreen(switchPane);
	}
}
