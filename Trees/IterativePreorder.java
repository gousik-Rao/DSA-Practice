package pack.DSA.Week7.Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class IterativePreorder {

	static public List<Integer> iterativePreOrder(TreeNode root){
		List<Integer> res = new ArrayList<>();
		if(root == null) return res;
		
		Deque<TreeNode> deq = new ArrayDeque<>();
		deq.offerFirst(root);
		
		while(!deq.isEmpty()) {
			TreeNode topNode = deq.removeLast();
			if(topNode.right != null) deq.offerLast(topNode.right);
			if(topNode.left != null) deq.offerLast(topNode.left);
			
			res.add(topNode.value);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		
		root.left = new TreeNode(9);
		root.right = new TreeNode(10);
		
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(1);
		
		System.out.println(iterativePreOrder(root));
	}
}
