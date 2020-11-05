package starter;

public class UnoCard {
	ColorType type;
	CardValue value;
	
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