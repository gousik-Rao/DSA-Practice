package pack.DSA.Week7.Trees;

public class InvertABinaryTree extends BinaryTree<TreeNode>{

	public TreeNode invertBinaryTree(TreeNode node) {
		if(node == null)
			return node;
		
		// Using Post-Order Traversal
		TreeNode left = invertBinaryTree(node.left);
		TreeNode right = invertBinaryTree(node.right);
		
		node.left = right;
		node.right = left;
		
		return node;
	}
}
