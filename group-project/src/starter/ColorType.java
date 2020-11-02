package starter;

public enum ColorType {
	RED, GREEN, BLUE, YELLOW, WILD;
	
	public String toString() {
		switch(this) {
			case RED: return "red";
			case GREEN: return "green";
			case BLUE: return "blue";
			case YELLOW: return "yellow";
			case WILD: return "wild";
		}
		return "n/a";
	}
}
