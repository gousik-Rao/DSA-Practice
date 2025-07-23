package pack.DSA.Week7.Trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraverse {

	public List<List<Integer>> levelOrderTraversal(TreeNode root){
		Deque<TreeNode> deq = new LinkedList<>();
		List<List<Integer>> res = new ArrayList<>();
		
		if(root == null) return res;
		
		deq.offerLast(root);
		
		while(!deq.isEmpty()) {
			int levelNumber = deq.size();
			List<Integer> subTree = new ArrayList<>();
			
			for(int idx = 0; idx < levelNumber; idx++) {
				TreeNode node = deq.removeFirst();
				if(node.left != null) deq.offerLast(node.left);
				if(node.right != null) deq.offerLast(node.right);               
				subTree.add(node.value);
			}
			res.add(subTree);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		LevelOrderTraverse lt = new LevelOrderTraverse();
		
		TreeNode node = new TreeNode(1);
		
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		
		System.out.println(lt.levelOrderTraversal(node));
	}
}
