package pack.DSA.Week7.Trees;

public class TreeNode{
	int value;
	TreeNode left, right;
	
	TreeNode(){}
	TreeNode(int val){this.value = val;}
	TreeNode(int val, TreeNode left, TreeNode right){
		this.left = left;
		this.right = right;
		this.value = val;
	}
}
