package starter;

public class UnoCard {
	ColorType type;
	CardValue value;
	
	public UnoCard(ColorType a, CardValue b) {
		type = a;
		value = b;
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