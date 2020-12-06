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
		if(value == 0) {
			return "0";
		}
		else if(value == 1) {
			return "1";
		}
		else if(value == 2) {
			return "2";
		}
		else if(value == 3) {
			return "3";
		}
		else if(value == 4) {
			return "4";
		}
		else if(value == 5) {
			return "5";
		}
		else if(value == 6) {
			return "6";
		}
		else if(value == 7) {
			return "7";
		}
		else if(value == 8) {
			return "8";
		}
		else if(value == 9) {
			return "9";
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
