package starter;

public class UnoCard {
	ColorType type;
	CardValue value;
	
	public static void main(String[] args) {
		UnoCard someCard =  new UnoCard(1, 4);
		System.out.println(someCard.getColorType().getColor());
		System.out.println(someCard.getCardValue().getValue());
	}
	
	public UnoCard(int a, int b) {
		type = new ColorType(a);
		value = new CardValue(b);
	}
	
	public ColorType getColorType() {
		return type;
	}
	
	public CardValue getCardValue() {
		return value;
	}

	public int cardColorCodeConvert() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int cardTypeCodeConvert() {
		// TODO Auto-generated method stub
		return 0;
	}
}