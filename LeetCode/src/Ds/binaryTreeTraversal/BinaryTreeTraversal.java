package Ds.binaryTreeTraversal;

import java.util.ArrayList;


public class BinaryTreeTraversal {

	/**
	 * @param args
	 * 将数组中数据存入二叉树中，然后使用三种遍历分别遍历
	 * 假设输入是：完全二叉树的层次遍历
	 * 
	 */
	
	public static void main(String[] args) {
		
		//树的节点数据为数值
		//使用int[] btreeT.createBinTree(intArray,intNodesList)方法会出错，因为在这个方法中T的类型必须是一致的
		//int[] intArray = {1,2,3,4,5,6,7,8,9,10};
		Integer[] intArray = {1,2,3,4,5,6,7,8,9,10};
		//树的节点数据为字符
		String[] strings = {"A","B","C","D","E","F","G"};
		
		BinaryTreeTraversal btreeT = new BinaryTreeTraversal();
		//首先使用string值的树进行测试
		ArrayList<Node<String>> stringNodesList = new ArrayList<Node<String>>();
		//构建二叉树
		btreeT.createBinTree(strings,stringNodesList);
		Node<String> root = stringNodesList.get(0);
		btreeT.printArray(strings);
		System.out.println("递归先根遍历：");
		btreeT.preOrderTraver(root);
		System.out.println();
		System.out.println("递归中根遍历：");
		btreeT.inOrderTraver(root);
		System.out.println();
		System.out.println("递归后根遍历：");
		btreeT.postOrderTraver(root);
		
		System.out.println();//分隔行
		
		//使用int值的树进行测试
		ArrayList<Node<Integer>> intNodesList = new ArrayList<Node<Integer>>();
		//构建二叉树
		btreeT.createBinTree(intArray,intNodesList);
		Node<Integer> intRoot = intNodesList.get(0);
		btreeT.printArray(intArray);
		System.out.println("递归先根遍历：");
		btreeT.preOrderTraver(intRoot);
		System.out.println();
		System.out.println("递归中根遍历：");
		btreeT.inOrderTraver(intRoot);
		System.out.println();
		System.out.println("递归后根遍历：");
		btreeT.postOrderTraver(intRoot);
				
	}
	private <T> void postOrderTraver(Node<T> root) {
		if (root == null) {
			return;
		}
		postOrderTraver(root.leftNode);
		postOrderTraver(root.rightNode);
		System.out.print(root.data + "-");
	}
	private <T> void inOrderTraver(Node<T> root) {
		if (root == null) {
			return;
		}
		inOrderTraver(root.leftNode);
		System.out.print(root.data + "-");
		inOrderTraver(root.rightNode);
	}
	private <T> void preOrderTraver(Node<T> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + "-");
		preOrderTraver(root.leftNode);
		preOrderTraver(root.rightNode);
	}
	/**
	 * 泛型方法，打印各种类型的数组
	 * @param t
	 */
	private <T> void printArray(T[] t) {
		System.out.print("初始数组：");
		for (T t2 : t) {
			System.out.print(t2+"   ");
		}
		//分隔行
		System.out.println();
	}
	/**
	 * 泛型方法，根据传入的数组的类型 构造Node节点
	 * 然后构造二叉树
	 * 
	 * 目测存在的bug:没有考虑只有一个节点或者空树的情况
 	 * 
 	 * @param t
	 * @param c
	 */
	private <T> void createBinTree(T[] t,ArrayList<Node<T>> list) {
		//将数组中元素转化为Node节点,左右孩子默认为null
		for (int i = 0; i < t.length; i++) {
			list.add(new Node<T>(t[i]));
		}
		//构建二叉树，只要左右孩子存在，就建立左右节点
		for (int i = 0; i < t.length/2; i++) {
			if (2*i+1 < t.length) {
				list.get(i).leftNode = list.get(2*i+1);
			}
			if (2*i+2 < t.length) {
				list.get(i).rightNode = list.get(2*i+2);
			}
		}
	}
}

/**
 * 
 * @author Administrator
 *
 * @param <T>
 * 
 * 泛型类，树的节点信息可以是任意数据，不止是string 或者int
 */
class Node<T>{
	
	T data;
	Node<T> rightNode;
	Node<T> leftNode;
	
	public Node(T t) {
		leftNode = null;
		rightNode = null;
		this.data = t;
	}
	
}
