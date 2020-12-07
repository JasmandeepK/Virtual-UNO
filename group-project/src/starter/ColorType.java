/**
 * This file is a class for the color type for the card type.
 * There are 5 color types: red, green, blue, yellow, and wild.
 * 
 * @author Jasmandeep Kaur, Thyphien Son, Gwendolyn Howes, Samantha Sousa
 *
 */

package starter;

public class ColorType {
	private int color;
	
	ColorType(int num){
		color = num;
	}
	
	//sets a number based on color
	public void setColor(int num) {
		this.color = num;
	}
	
	//returns the color in string form
	public String getColor() {
		if(color == 0) {
			return "Red";
		}
		else if(color == 1) {
			return "Yellow";
		}
		else if(color == 2) {
			return "Blue";
		}
		else if(color == 3) {
			return "Green";
		}
		else if(color == 4){
			return "Wild";
		}
		return "n/a";
	}
}
