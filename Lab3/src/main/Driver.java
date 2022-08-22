/* A currency simulation to demonstrate Classes, Inheritance, and Polymorphism
 * using Singly Linked Lists, Stacks, and Queues.
 * 
 * Authors: Tom Ekshtein, Dhruv Susheelkar
 * Team 12
 * 
 */

package main;

import Currency.*;
import ADT.*;
public class Driver {

	public static void main(String[] args) {
		System.out.println("Welcome to Tom Ekshtein and Dhruv Susheelkar's currency simulator using\nLinked Lists, Stacks, and Queues.");
		Currency[] references = new Currency[20];
		references[0] = new Dollar(57.12);
		references[1] = new Dollar(23.44);
		references[2] = new Dollar(87.43);
		references[3] = new Dollar(68.99);
		references[4] = new Dollar(111.22);
		references[5] = new Dollar(44.55);
		references[6] = new Dollar(77.77);
		references[7] = new Dollar(18.36);
		references[8] = new Dollar(543.21);
		references[9] = new Dollar(20.21);
		references[10] = new Dollar(345.67);
		references[11] = new Dollar(36.18);
		references[12] = new Dollar(48.48);
		references[13] = new Dollar(101.00);
		references[14] = new Dollar(11.00);
		references[15] = new Dollar(21.00);
		references[16] = new Dollar(51.00);
		references[17] = new Dollar(1.00);
		references[18] = new Dollar(251.00);
		references[19] = new Dollar(151.00);
		
		SinglyLinkedList<Currency> sll = new SinglyLinkedList<>();
		Queue<Currency> queue = new Queue<>();
		Stack<Currency> stack = new Stack<>();
		linkedListOperations(sll,references);
		stackOperations(stack,references);
		queueOperations(queue,references);
		
		sll.clearAll();
		queue.clearAll();
		stack.clearAll();
		
		System.out.println("That's all for now, see you next lab!");
		
	}
	
	public static void linkedListOperations(SinglyLinkedList<Currency> sll, Currency[] arr) {
		System.out.println("----------------------");
		System.out.println("  Singly Linked List");
		System.out.println("----------------------");
		//part a
		sll.append(arr[6]);
		sll.append(arr[5]);
		sll.append(arr[4]);
		sll.append(arr[3]);
		sll.append(arr[2]);
		sll.append(arr[1]);
		sll.append(arr[0]);
		
		//part b
		Dollar searchVal = new Dollar(87.43);
		for (int i = 0; i < 2; i++) {
			if (sll.findCurrency(searchVal) != -1) {
				System.out.println(searchVal.toString()+" Found at index " + sll.findCurrency(searchVal));
			} else {
				System.out.println(searchVal.toString()+" Not found");
			}
			searchVal.setWhole(44);
			searchVal.setFraction(56);
		}
		
		//part c
		searchVal.setWhole(111);
		searchVal.setFraction(22);
		sll.removeCurrency(searchVal);
		sll.removeCurrency(2);
		
		//part d
		System.out.println(sll.printList());		
		//part e
		sll.append(arr[8]);
		sll.append(arr[9]);
		sll.append(arr[10]);
		sll.append(arr[11]);
		
		//part f
		sll.removeCurrency(sll.getCount() % 6);
		sll.removeCurrency(sll.getCount() / 7);
		
		//part g
		System.out.println(sll.printList());		
	}

	public static void stackOperations(Stack<Currency> stack, Currency[] arr) {
		System.out.println("----------------------");
		System.out.println("        Stacks");
		System.out.println("----------------------");
		//part a
		stack.push(arr[13]);
		stack.push(arr[14]);
		stack.push(arr[15]);
		stack.push(arr[16]);
		stack.push(arr[17]);
		stack.push(arr[18]);
		stack.push(arr[19]);
		
		//part b
		System.out.println(stack.peek().toString());
		System.out.println(stack.printList());		
		//part c
		stack.pop();
		stack.pop();
		stack.pop();
		
		//part d
		System.out.println(stack.printList());
		
		//part e
		stack.push(arr[0]);
		stack.push(arr[1]);
		stack.push(arr[2]);
		stack.push(arr[3]);
		stack.push(arr[4]);
		
		//part f
		stack.pop();
		stack.pop();
		
		//part g
		System.out.println(stack.printList());	}
	
	public static void queueOperations(Queue<Currency> queue, Currency[] arr) {
		System.out.println("----------------------");
		System.out.println("        Queues");
		System.out.println("----------------------");
		
		//part a
		queue.enqueue(arr[5]);
		queue.enqueue(arr[7]);
		queue.enqueue(arr[9]);
		queue.enqueue(arr[11]);
		queue.enqueue(arr[13]);
		queue.enqueue(arr[15]);
		queue.enqueue(arr[17]);
		
		//part b
		System.out.println(queue.peekFront());
		System.out.println(queue.peekRear());
		
		//part c
		queue.dequeue();
		queue.dequeue();
		
		//part d
		System.out.println(queue.printList());		
		//part e
		queue.enqueue(arr[10]);
		queue.enqueue(arr[11]);
		queue.enqueue(arr[12]);
		queue.enqueue(arr[13]);
		queue.enqueue(arr[14]);
		
		//part f
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		
		//part g
		System.out.println(queue.printList());
		}
	
}
