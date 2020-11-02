/**
 * This file is an enum class for the color type for the card type.
 * There are 5 color types: red, green, blue, yellow, and wild.
 * 
 * @author Jasmandeep Kaur, Thyphien Son, Gwendolyn Howes, Samantha Sousa
 *
 */

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
