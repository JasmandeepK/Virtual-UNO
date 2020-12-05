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
	
	public void setCoordinates(int[] location) {
		coordinates = location;
	}
	
	public int[] getCoordinates() {
		return coordinates;
	}
	
	public ColorType getColorType() {
		return type;
	}
	
	public CardValue getCardValue() {
		return value;
	}
}