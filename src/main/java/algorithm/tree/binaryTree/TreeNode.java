package algorithm.tree.binaryTree;

class TreeNode {
	private int index;
	private TreeNode lChild;
	private TreeNode rChild;
	private String data;
	
	
	
	public TreeNode( int index, String data, TreeNode lChild,TreeNode rChild) {
		super();
		this.index = index;
		this.lChild = lChild;
		this.rChild = rChild;
		this.data = data;
	}
	
	public TreeNode(int index, String data) {
		super();
		this.index = index;
		this.data = data;
	}
	public TreeNode getlChild() {
		return lChild;
	}
	public void setlChild(TreeNode lChild) {
		this.lChild = lChild;
	}
	public TreeNode getrChild() {
		return rChild;
	}
	public void setrChild(TreeNode rChild) {
		this.rChild = rChild;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "TreeNode [index=" + index + ", data=" + data + "]";
	}
	
	
}
