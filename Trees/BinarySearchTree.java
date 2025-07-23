package pack.DSA.Week7.Trees;

public class BinarySearchTree {
	
	public class Node{
		private int value, height;
		private Node left, right;
		
		public Node(int val) {
			value = val;
		}
		
		public int getValue() {
			return value;
		}
	}
	
	private Node root;
	public BinarySearchTree() {}
	
	public int height(Node node) {
		if(node == null)
			return -1;
		return node.height;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void insert(int val) {
		root = insert(val, root);
	}
	
	private Node insert(int value, Node node) {
		if(node == null)
			return node = new Node(value);
		if(value < node.value) {
			node.left = insert(value, node.left);
		}
		if(value > node.value) {
			node.right = insert(value, node.right);
		}
//		New node inserted so increase the height by comparing the height of the 2 child nodes                  
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		return node;
	}
	
	public void populate(int[] nums) {
		for(int idx = 0; idx < nums.length; idx++) {
			insert(nums[idx]); 
		}
	}
	
	public void populateSorted(int[] nums) {
		populateSorted(nums, 0, nums.length);
	}
	
	private void populateSorted(int[] nums, int start, int end) {
		if(start >= end)
			return;
		int mid = start + (end - start) / 2;
		this.insert(nums[mid]);
		populateSorted(nums, start, mid);
		populateSorted(nums, mid + 1, end);
	}
	
	public void display() {
		display(this.root , "Root Node: ");
	}
	
	private void display(Node node, String details) {
		if(node == null)
			return;
		System.out.println(details + node.getValue());
		
		display(node.left, "Left Child of " + node.getValue() + ": ");
		display(node.right, "Right Child of " + node.getValue() + ": ");
	}
	
	public boolean isBalanced() {
		return balanced(root);
	}
	
	private boolean balanced(Node node) {
		if(node == null)
			return true;
		return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);                     
	}
}















