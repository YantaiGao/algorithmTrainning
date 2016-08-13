package Ds.binaryTreeTraversal;

import java.util.ArrayList;


public class BinaryTreeTraversal {

	/**
	 * @param args
	 * �����������ݴ���������У�Ȼ��ʹ�����ֱ����ֱ����
	 * ���������ǣ���ȫ�������Ĳ�α���
	 * 
	 */
	
	public static void main(String[] args) {
		
		//���Ľڵ�����Ϊ��ֵ
		//ʹ��int[] btreeT.createBinTree(intArray,intNodesList)�����������Ϊ�����������T�����ͱ�����һ�µ�
		//int[] intArray = {1,2,3,4,5,6,7,8,9,10};
		Integer[] intArray = {1,2,3,4,5,6,7,8,9,10};
		//���Ľڵ�����Ϊ�ַ�
		String[] strings = {"A","B","C","D","E","F","G"};
		
		BinaryTreeTraversal btreeT = new BinaryTreeTraversal();
		//����ʹ��stringֵ�������в���
		ArrayList<Node<String>> stringNodesList = new ArrayList<Node<String>>();
		//����������
		btreeT.createBinTree(strings,stringNodesList);
		Node<String> root = stringNodesList.get(0);
		btreeT.printArray(strings);
		System.out.println("�ݹ��ȸ�������");
		btreeT.preOrderTraver(root);
		System.out.println();
		System.out.println("�ݹ��и�������");
		btreeT.inOrderTraver(root);
		System.out.println();
		System.out.println("�ݹ���������");
		btreeT.postOrderTraver(root);
		
		System.out.println();//�ָ���
		
		//ʹ��intֵ�������в���
		ArrayList<Node<Integer>> intNodesList = new ArrayList<Node<Integer>>();
		//����������
		btreeT.createBinTree(intArray,intNodesList);
		Node<Integer> intRoot = intNodesList.get(0);
		btreeT.printArray(intArray);
		System.out.println("�ݹ��ȸ�������");
		btreeT.preOrderTraver(intRoot);
		System.out.println();
		System.out.println("�ݹ��и�������");
		btreeT.inOrderTraver(intRoot);
		System.out.println();
		System.out.println("�ݹ���������");
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
	 * ���ͷ�������ӡ�������͵�����
	 * @param t
	 */
	private <T> void printArray(T[] t) {
		System.out.print("��ʼ���飺");
		for (T t2 : t) {
			System.out.print(t2+"   ");
		}
		//�ָ���
		System.out.println();
	}
	/**
	 * ���ͷ��������ݴ������������� ����Node�ڵ�
	 * Ȼ���������
	 * 
	 * Ŀ����ڵ�bug:û�п���ֻ��һ���ڵ���߿��������
 	 * 
 	 * @param t
	 * @param c
	 */
	private <T> void createBinTree(T[] t,ArrayList<Node<T>> list) {
		//��������Ԫ��ת��ΪNode�ڵ�,���Һ���Ĭ��Ϊnull
		for (int i = 0; i < t.length; i++) {
			list.add(new Node<T>(t[i]));
		}
		//������������ֻҪ���Һ��Ӵ��ڣ��ͽ������ҽڵ�
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
 * �����࣬���Ľڵ���Ϣ�������������ݣ���ֹ��string ����int
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
