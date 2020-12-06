package starter;
public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 1800;
	public static final int WINDOW_HEIGHT = 900;
	public static final String MUSIC_FOLDER = "sounds";
	private static final String[] SOUND_FILES = { "r2d2.mp3", "somethinlikethis.mp3" };

	private SomePane somePane;
	private MenuPane menu;
	private UsernamePane usernameScreen;
	private UsernamePane2 usernameScreen2;
	private UnoPane unoPane;
	private WinPane winPane;
	private int count;

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
		System.out.println("Hello, world!");
		somePane = new SomePane(this);
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
	
	public void setPlayer1HasUno(boolean bool) {
		unoPane.getPlayer1().setHasUno(bool);
	}
	
	public void setPlayer2HasUno(boolean bool) {
		unoPane.getPlayer2().setHasUno(bool);
	}
	
	public String getWinningPlayerName() {
		return unoPane.getWinningPlayerName();
	}
	
	public void switchToMenu() {
		//playRandomSound();
		count++;
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
	
	public void switchToSome() {
		//playRandomSound();
		switchToScreen(somePane);
	}

	private void playRandomSound() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.playSound(MUSIC_FOLDER, SOUND_FILES[count % SOUND_FILES.length]);
	}
}
