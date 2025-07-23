package pack.DSA.Week7.Trees;

import java.util.Scanner;

public class BinaryTree<T> {
	public BinaryTree() {}
	
//	Inner class
	private static class Node{
		int val;
		Node left, right;
		
		public Node(int val) {
			this.val = val;
		}
	}
	private Node root;
	
	public void populate(Scanner scan) {
		System.out.println("Enter the root node value: ");
		int val = scan.nextInt();
		root = new Node(val);
		populate(scan, root);
	}
	
	private void populate(Scanner s, Node node) {
		System.out.println("Do you want to enter left of " + node.val + ": ");
		String left = s.next();
		if("y".equalsIgnoreCase(left) || "yes".equalsIgnoreCase(left)) {
			System.out.println("Enter the value of the left of " + node.val + ": "); 
			int val = s.nextInt();
			node.left = new Node(val);
			populate(s, node.left);
		}
		
		System.out.println("Do you want to enter right of " + node.val + ": ");
		String right = s.next();
		if("y".equalsIgnoreCase(right) || "yes".equalsIgnoreCase(right))  {
			System.out.println("Enter the value of the right of " + node.val + ": ");                          
			int val = s.nextInt();
			node.right = new Node(val);
			populate(s, node.right);
		}
	}
	
	public void display() {
		display(root, "");
	}
	
	private void display(Node node, String indent) {
		if(node == null)
			return;
		System.out.println(indent + node.val);
		display(node.left, indent + "\t");
		display(node.right, indent + "\t");
	}
	
	public void prettyDisplay() {
		prettyDisplay(root, 0);
	}
	
	private void prettyDisplay(Node node, int level) {
		if(node == null)
			return;
		
		prettyDisplay(node.right, level + 1);
		if(level != 0) {
			for(int idx = 0; idx < level - 1; idx++) {
				System.out.print("|\t");
			}
			System.out.println("|-------->" + node.val);
		}else {
			System.out.println(node.val);
		}
		
		prettyDisplay(node.left, level + 1);
	}
	
	public void preOrder() {
		preOrder(root);
	}
	private void preOrder(Node node) {
		if(node == null)
			return;
		System.out.print(node.val + " -> ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public void inOrder() {
		inOrder(root);
	}
	private void inOrder(Node node) {
		if(node == null)
			return;
		inOrder(node.left);
		System.out.print(node.val + " -> ");
		inOrder(node.right);
	}
	
	public void postOrder() {
		postOrder(root);
	}
	private void postOrder(Node node) {
		if(node == null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.val + " -> ");
	}
}






