//This class hold uno cards with the valus and color
package starter;

public class UnoCard {
	private ColorType type;
	private CardValue value;
	private int[] coordinates = new int[4];
	
	public static void main(String[] args) {
		UnoCard someCard =  new UnoCard(1, 4);
		System.out.println(someCard.getColorType().getColor());
		System.out.println(someCard.getCardValue().getValue());
	}
	
	public UnoCard(int a, int b) {
		type = new ColorType(a);
		value = new CardValue(b);
	}
	
	//sets the location of the card on the screen
	public void setCoordinates(int[] location) {
		coordinates = location;
	}
	
	//gets the location of the cards
	public int[] getCoordinates() {
		return coordinates;
	}
	
	//gets the color of the cards
	public ColorType getColorType() {
		return type;
	}
	
	//gets the value of the cards
	public CardValue getCardValue() {
		return value;
	}
}