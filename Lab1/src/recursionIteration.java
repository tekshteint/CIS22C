/*
 * Lab 1: Iteration vs Recursion demo lab
 * 
 * @authors: Tom Ekshtein, Dhruv Susheelkar
 */

import java.util.Scanner;
import java.lang.Math;

public class recursionIteration {
	static final int SORT_MAX_SIZE = 16;
	
	public static void main(String args[]) {
		int SORT_MAX_SIZE = 16;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Array Length (up to 16): ");

		int arrLength = scan.nextInt();
		if (arrLength > SORT_MAX_SIZE) {
			arrLength = SORT_MAX_SIZE;
		}
		int[] arr = new int[arrLength];
		System.out.println("Enter array contents using spaces to separate numbers (1-9999 inclusive): ");
		for (int i = 0; i < arrLength; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		//call to iterative function
		if (IsArrayPrimeIter(arr, arrLength)) {
			System.out.println("Prime array using iteration");
		}
		else {
			System.out.println("Not prime array using iteration");
		}
		if (IsArrayPrimeRecur(arr, arrLength)) {
			System.out.println("Prime array using recursion.");
		}
		else {
			System.out.println("Not prime array using recursion.");
		}
	}
	/*
	 * This algorithm checks if all the numbers in a given array are prime through iteration
	 * Pre: arr - a non empty array of integers where each element is from 1-9999
	 * 		size - array size
	 * Post: 
	 * Return: true or false
	 * 
	 * pseudocode:
	 * loop arr:
	 * 			loop j until size of arr[i]:
	 * 				if arr[i] is 2 or arr[i] % j is 0:
	 * 					return false
	 * return true
	 */
	public static boolean IsArrayPrimeIter(int[] arr, int size) {
		System.out.println("Entering IsArrayPrimeIter");
		boolean primeFlag = true;
		for (int i = 0; i < size; i++) {
			for (int j = 2; j < arr[i]; j++) {
				if(arr[i] == 1) {
					primeFlag = false;
					break;
				} //condition if number is 2
				else if(arr[i] == 2) {} //condition if number is 2
				else if (arr[i] % j == 0) {
					primeFlag = false;
					break;
				}
			}
		}
		System.out.println("Leaving IsArrayPrimeIter");
		return primeFlag;
	}
	/*
	 * This algorithm recursively checks if every element of an array is a prime number
	 * Pre: arr - a non empty array of integers where each element is from 1-9999
	 * 		size - array size
	 * Post: 
	 * Return: true if every element is prime, false otherwise
	 * 
	 * pseudocode:
	 * if arr is empty:
	 * 		return true
	 * else if element is divisible by a divisor of 2:
	 * 		return false
	 * return true if every element is prime. return false otherwise
	 * 
	 */
	public static boolean IsArrayPrimeRecur(int[] arr, int size) {
		System.out.println("Entering IsArrayPrimeRecur");
		if(size == 0) {
			System.out.println("Leaving IsArrayPrimeRecur");
			return true;
		}
		else if (!(isPrimeRecur(arr[size-1], 2))) {
			System.out.println("Leaving IsArrayPrimeRecur");
			return false;
		}
		return IsArrayPrimeRecur(arr, size-1);
	}
	/*
	 * Wrapper method for isArrayPrimeRecur using 6k+1 or 6k-1 to find prime numbers
	 * Pre: num - element of arr
	 * 		divisor - check to see if num is divisible by this number
	 * Post: 
	 * Return: true or false
	 * 
	 * pseudocode:
	 * if num is 0 or 1:
	 * 		return false
	 * if num is 2 or 3:
	 * 		return true
	 * if num works with 6k +/- 1:
	 * 		return true
	 * if num < (6k+1)+1:
	 * 		return true
	 * if divisor < sqrt(num):
	 * 		return false
	 * return true if every element is prime. return false otherwise
	 */
	public static boolean isPrimeRecur(int num, int divisor) {
		if(divisor == 2) {
			System.out.println("Entering IsPrimeRecur");
		}
		if (num == 0 || num == 1) {
			System.out.println("Leaving IsPrimeRecur");
			return false;
		}
		else if (num == 2 || num == 3) {
			System.out.println("Leaving IsPrimeRecur");
			return true;
		}
		else if (num == (6 * (divisor)+1) || num == (6 * (divisor)-1)) {
			System.out.println("Leaving IsPrimeRecur");
			return true;
		}
		else if (num < (6 * (divisor+1)+1)) {
			System.out.println("Leaving IsPrimeRecur");
			return true;
		}
		else if (divisor > Math.sqrt(num)) {
			return false;
		}
		return isPrimeRecur(num, divisor + 1);
	}
}