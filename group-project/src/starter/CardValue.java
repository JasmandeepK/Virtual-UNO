package starter;

public class CardValue {
	private int value;
	
	CardValue(int num) {
		value = num;
	}
	public void setValue(int num) {
		this.value = num;
	}
	
	public String getValue() {
		if(value >= 0 && value <= 9) {
			return Integer.toString(value);
		}
		else if(value == 10) {
			return "+2";
		}
		else if(value == 11) {
			return "reverse";
		}
		else if(value == 12) {
			return "skip";
		}
		else if(value == 13){
			return "Wild";
		}
		else if (value == 14) {
			return "+4";
		}
		return "n/a";
	}
}
