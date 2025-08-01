package pack.DSA.Week7.Trees;

import java.util.Objects;

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
	
	@Override
	public String toString() {
		return "TreeNode [value=" + value + ", left=" + left + ", right=" + right + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(left, right, value);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		TreeNode other = (TreeNode) obj;
		return Objects.equals(left, other.left) && Objects.equals(right, other.right) && value == other.value;
	}
}
