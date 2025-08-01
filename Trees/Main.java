package pack.DSA.Week7.Trees;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
//		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
//		tree.populate(s);
//		tree.prettyDisplay();
		
//		BinarySearchTree tree = new BinarySearchTree();
		
//		int[] nums = {5, 5, 5, 5, 5, 5};
//		tree.populate(s);
		
//		tree.display();
//		
//		System.out.println("In-Order: ");
//		tree.inOrder();
//		System.out.println("\nPre-Order: ");
//		tree.preOrder();
//		System.out.println("\nPost-Order: ");
//		tree.postOrder();
		
		InvertABinaryTree ivTree = new InvertABinaryTree();
		
		TreeNode tree = new TreeNode();
		
		tree = new TreeNode(1);
		
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(5);
		
		tree.right.left = new TreeNode(6);
		tree.right.right = new TreeNode(7);
		
		System.out.println(ivTree.invertBinaryTree(tree));
		
		s.close();
	}
}
