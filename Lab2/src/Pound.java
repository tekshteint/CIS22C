/* A currency simulation to demonstrate Classes, Inheritance, and Polymorphism
 * 
 * Authors: Tom Ekshtein, Dhruv Susheelkar
 * Team 12
 * 
 */

public class Pound extends Currency {
	private String name = "Pound";
	public Pound() {
		super();
	}
	public Pound(int whole, int fraction) {
		super(whole,fraction);
	}
	public Pound(double newCurrency) {
		super(newCurrency);
	}
	public Pound(Currency newCurr) {
		super(newCurr);
	}
	
	/*
	 * toString: This function converts the current currency to a string
	 * using the whole, a decimal point, the fraction, and the name (pound)
	 */
	public String toString() {
		return getWhole() + "." + getFraction() + " " + name;
	}
}
