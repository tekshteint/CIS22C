/* A currency simulation to demonstrate Classes, Inheritance, and Polymorphism
 * 
 * Authors: Tom Ekshtein, Dhruv Susheelkar
 * Team 12
 * 
 */

import java.util.Scanner;

public class lab2main {
	public static void main(String[] args) {
		Currency[] references = new Currency[2];
		references[0] = new Pound();
		references[1] = new Dollar();
		char keycode = 'p';
		char type = 'n';
		double user_input = 1.1;
		String doublecheck = " ";
		Scanner IN = new Scanner(System.in);
		//we
		while(keycode != 'q') {
			System.out.print("Choose an operation: ");
			System.out.println("a: add\ns: subtract");
			System.out.println("Then choose p for pound and d for dollar.");
			System.out.println("Input the number of currency");
			System.out.println("Then verify by typing pound or dollar.");
			keycode = IN.next().charAt(0);
			if(keycode == 'q') {
				System.out.println("Program ended");
				IN.close();
				break;
			}
			type = IN.next().charAt(0);
			user_input = IN.nextDouble();
			doublecheck = IN.next();
			IN.nextLine();
			if(type != doublecheck.charAt(0)) {
				if(keycode == 'a') {
					System.out.println("Invalid Addition");
				}
				else {
					System.out.println("Invalid Subtraction");
				}
			}
			else if(user_input < 0) {
				System.out.println("Invalid Input");
			}
			else if(keycode == 'a') { //addition here
				if(type == 'p') {
					Pound temp = new Pound(user_input);
					references[0].add(references[0],temp);
				}
				else if(type == 'd') {
					Dollar temp = new Dollar(user_input);
					references[1].add(references[1],temp);
				}
				else {	//if the types do not match
					System.out.println("Invalid Addition");
				}
			}
			else if(keycode == 's') { //subtraction here
				if(type == 'p') { //pound
					Pound temp = new Pound(user_input);
					if(references[0].isGreater(references[0],temp) || references[0].isEqual(references[0],temp)) {
						references[0].subtract(references[0],temp);
					}
					else {	//checks if 2nd value is more
						System.out.println("Invalid Subtraction");
					}

				}
				else if(type == 'd') {	//dollars
					Dollar temp = new Dollar(user_input);
					if(references[1].isGreater(references[1],temp) || references[1].isEqual(references[1],temp)) {
						references[1].subtract(references[1],temp);
					}
					else { //checks if 2nd value is more
						System.out.println("Invalid Subtraction");
					}

				}
				else {	//type does not match
					System.out.println("Invalid Subtraction");
				}
			}
			else {	//user did not input properly
				System.out.println("Invalid Input");
			}
			System.out.print(references[0].toString() + " "); //keep these both at end of program
			System.out.println(references[1].toString() + "\n");
			

		}
	}

}
