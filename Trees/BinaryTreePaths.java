package pack.DSA.Week7.Trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

	public List<String> binaryTreePaths(TreeNode root){
		List<String> res = new ArrayList<>();
		if(root == null) return res;
		
		pathTraverse(res, new StringBuilder(), root);
		
		return res;
	}
	
	private void pathTraverse(List<String> res, StringBuilder path
										, TreeNode root){
		if(root == null) return;
		
		int len = path.length();
		path.append(root.value);
		
		if(root.left == null && root.right == null) {
			res.add(path.toString());
		}
		
		else {
			path.append("->");
			pathTraverse(res, path, root.left);
			pathTraverse(res, path, root.right);
		}
		
		path.setLength(len);
		return;
	}
}
