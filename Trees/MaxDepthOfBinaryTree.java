package pack.DSA.Week7.Trees;

public class MaxDepthOfBinaryTree {

	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
		
		return postOrder(root);
	}
	
	public int postOrder(TreeNode node) {
		if(node == null) return 0;
		
		int left = postOrder(node.left);
		int right = postOrder(node.right);
		
		return 1 + Math.max(left, right);
	}
}
