package Currency;


public class Dollar extends Currency {
	private String name = "Dollar";

	public Dollar() {
		super();
	}
	public Dollar(int whole, int fraction) {
		super(whole,fraction);
	}
	public Dollar(double newCurrency) {
		super(newCurrency);
	}
	public Dollar(Currency newCurr) {
		super(newCurr);
	}
	
	/*
	 * toString: This function converts the current currency to a string
	 * using the whole, a decimal point, the fraction, and the name (dollar)
	 */
	public String toString() {
		return getWhole() + "." + getFraction() + " " + name;
	}
}

