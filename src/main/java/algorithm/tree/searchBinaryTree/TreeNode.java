package algorithm.tree.searchBinaryTree;

public class TreeNode {
	private int key;
	private TreeNode leftChild;
	private TreeNode rightChild;
	private int data;
	
	
	
	public TreeNode( int index, int data, TreeNode lChild,TreeNode rChild) {
		super();
		this.key = index;
		this.leftChild = lChild;
		this.rightChild = rChild;
		this.data = data;
	}
	
	public TreeNode(int data, TreeNode lChild,TreeNode rChild) {
		super();
		this.leftChild = lChild;
		this.rightChild = rChild;
		this.data = data;
	}
	
	public TreeNode(int data) {
		super();
		this.data = data;
	}
	
	public TreeNode(int index, int data) {
		super();
		this.key = index;
		this.data = data;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}

	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}

	public int getIndex() {
		return key;
	}

	public void setIndex(int index) {
		this.key = index;
	}


	
	
}
