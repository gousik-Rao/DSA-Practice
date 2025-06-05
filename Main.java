package pack.DSA.Week6;

import pack.DSA.Week6.Queue.QueueUsingArray;
import pack.DSA.Week6.Queue.QueueUsingLinkedList;
import pack.DSA.Week6.Queue.QueueUsingStack;
import pack.DSA.Week6.Stack.StackUsingArray;
import pack.DSA.Week6.Stack.StackUsingLinkedList;
import pack.DSA.Week6.Stack.StackUsingQueue;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {
		QueueUsingArray<Integer> qr = new QueueUsingArray<>(10);
		StackUsingArray<Integer> sr = new StackUsingArray<Integer>(10);
		
//		qr.push(90);
//		qr.push(999);
//		qr.push(10);
//		System.out.println("Queue before: " + qr);
//		
//		sr.push(78);
//		sr.push(84);
//		System.out.println("Stack before: " + sr);
//		
//		qr.pop();
//		qr.pop();
//		System.out.println("Queue after: " + qr);
//		
//		sr.pop();
//		System.out.println("Stack after: " + sr);
		
		StackUsingLinkedList<Integer> sl = new StackUsingLinkedList<Integer>();                       
		QueueUsingLinkedList<Integer> ql = new QueueUsingLinkedList<>();
		
//		sl.push(34);
//		sl.push(9);
//		sl.push(90);
//		System.out.println(sl);
//		
//		ql.push(87);
//		ql.push(4);
//		ql.push(39);
//		System.out.println(ql);
		
		StackUsingQueue<Integer> sq = new StackUsingQueue<Integer>();
		QueueUsingStack<Integer> qs = new QueueUsingStack<Integer>();
		
//		sq.push(55);
//		sq.push(78);
//		sq.push(88);
//		System.out.println(sq);
//		System.out.println(sq.top());
//		
//		qs.push(99);
//		qs.push(33);
//		qs.push(23);
//		qs.push(40);
//		System.out.println(qs);
//		System.out.println(qs.top());
//		qs.pop();
//		System.out.println(qs.top());
		
		
	}
}
