public class Model {
	
	private View view;
	private String toConvert = "";
	
	Model(View view) {
		this.view = view;
	}
	
	public void updateText(char c) {
	}
	
	public void clearText() {
	}
	
	public void convert(int n) {
	}
	
	public int toDecimal(String num, int pow) {
		int total = 0;
		for(int i = 0; i < num.length(); i++) {
			int convertedNum = Character.getNumericValue(num.charAt(num.length() - i - 1));
			total += convertedNum * ((int) Math.pow(pow, i));
		}
		return total;
	}
	
}