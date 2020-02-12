package algorithm.tree.binaryTree;


public class BinaryTree {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		//https://blog.csdn.net/u013066244/article/details/78845549
		TreeNode treeNode = tree.createTree();
		TreeNode foundNode = tree.getTreeNodeByData(treeNode,"A");
		if(foundNode != null)
			System.out.println(foundNode.toString());
		int r = tree.getHeight(foundNode);
		System.out.println(r);
	}
	
	public TreeNode createTree(){
		TreeNode cNode = new TreeNode(3,"C");
		TreeNode dNode = new TreeNode(4,"D");
		TreeNode eNode = new TreeNode(5,"E");
		TreeNode fNode = new TreeNode(6,"F");
		TreeNode iNode = new TreeNode(9,"I");
		TreeNode jNode = new TreeNode(10,"J");
		cNode.setlChild(fNode);
		dNode.setrChild(iNode);
		iNode.setrChild(jNode);
		TreeNode bNode = new TreeNode(2,"B",dNode,eNode);
		TreeNode aNode = new TreeNode(1,"A",bNode,cNode);
		return aNode;
	}
	
	public TreeNode getTreeNodeByData(TreeNode treeNode,String data){
		if(treeNode == null){
			return null;
		}else{
			TreeNode node1 = getTreeNodeByData(treeNode.getlChild(),data);
			TreeNode node2 = getTreeNodeByData(treeNode.getrChild(),data);
			if(node1 != null && node1.getData().equals(data)){
				treeNode = node1;
			}
			if(node2 != null && node2.getData().equals(data)){
				treeNode = node2;
			}
			return treeNode;
		}
	}
	
	public void preorderTree(TreeNode treeNode){
		if(treeNode == null){
			return;
		}else{
			System.out.print(treeNode.getData() + " ");
			preorderTree(treeNode.getlChild());
			preorderTree(treeNode.getrChild());
		}
	}
	
	public void midorderTree(TreeNode treeNode){
		if(treeNode == null){
			return;
		}else{
			preorderTree(treeNode.getlChild());
			System.out.print(treeNode.getData() + " ");
			preorderTree(treeNode.getrChild());
		}
	}
	
	public void afterorderTree(TreeNode treeNode){
		if(treeNode == null){
			return;
		}else{
			preorderTree(treeNode.getlChild());
			preorderTree(treeNode.getrChild());
			System.out.print(treeNode.getData() + " ");
			
		}
	}
	
	public int getHeight(TreeNode treeNode){
		if(treeNode == null){
			return 0;
		}else{
			int left = getHeight(treeNode.getlChild()) + 1;
			int right = getHeight(treeNode.getrChild()) + 1;
			return left>right? left:right;
		}
	}
}
