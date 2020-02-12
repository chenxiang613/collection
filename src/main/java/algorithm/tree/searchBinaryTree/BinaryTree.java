package algorithm.tree.searchBinaryTree;

import java.util.ArrayList;
import java.util.List;


public class BinaryTree {
	private TreeNode root =null;
	
	public static void main(String[] args) {
		int[] array = {21,29,30,10};
		
		List treeNodeList = new ArrayList<TreeNode>();
		for (int i : array) {
			System.out.println(i);
			treeNodeList.add(new TreeNode(i));
		}
		
//		BinaryTree tree = new BinaryTree();
//		TreeNode treeNode = tree.createTree();
//		TreeNode foundNode = tree.getTreeNodeByData(treeNode,"A");
//		if(foundNode != null)
//			System.out.println(foundNode.toString());
//		int r = tree.getHeight(foundNode);
//		System.out.println(r);
	}
	
	public void addNode(TreeNode treeNode){
		if(root == null){
			root = treeNode;
			return;
		}
	}
	
	public TreeNode getTreeNodeByData(TreeNode treeNode,String data){
		if(treeNode == null){
			return null;
		}else{
			TreeNode node1 = getTreeNodeByData(treeNode.getLeftChild(),data);
			TreeNode node2 = getTreeNodeByData(treeNode.getRightChild(),data);
			if(node1 != null ){
				treeNode = node1;
			}
			if(node2 != null ){
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
			preorderTree(treeNode.getLeftChild());
			preorderTree(treeNode.getRightChild());
		}
	}
	
	public void midorderTree(TreeNode treeNode){
		if(treeNode == null){
			return;
		}else{
			preorderTree(treeNode.getLeftChild());
			System.out.print(treeNode.getData() + " ");
			preorderTree(treeNode.getRightChild());
		}
	}
	
	public void afterorderTree(TreeNode treeNode){
		if(treeNode == null){
			return;
		}else{
			preorderTree(treeNode.getLeftChild());
			preorderTree(treeNode.getRightChild());
			System.out.print(treeNode.getData() + " ");
			
		}
	}
	
	public int getHeight(TreeNode treeNode){
		if(treeNode == null){
			return 0;
		}else{
			int left = getHeight(treeNode.getLeftChild()) + 1;
			int right = getHeight(treeNode.getRightChild()) + 1;
			return left>right? left:right;
		}
	}
}
