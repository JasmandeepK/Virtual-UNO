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
}