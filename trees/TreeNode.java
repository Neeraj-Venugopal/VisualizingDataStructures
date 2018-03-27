package trees;

public class TreeNode {

	TreeNode left;
	TreeNode right;
	int data;
	
	
	public TreeNode(int data){
		this.left = null;
		this.right = null;
		this.data = data;
	}
	
	public TreeNode(){
		this.left =null;
		this.right = null;
		this.data = 0;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	
}
