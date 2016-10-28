package Ds.binaryTree;

import java.util.LinkedList;

class BinaryTree{
	int data;
	BinaryTree lefTree;
	BinaryTree rightTree;
	public BinaryTree() {
		
	}
	public BinaryTree(int data) {
		this.data = data;
	}
	
}
/**
 * @author ����̫
 * 2016-10-28
 * 
 * ����
 * ������������
 * 
 * ����һ��
 * ʹ�õݹ�ķ�������������������ȣ�Ȼ��������
 * 
 * ��������
 * �ǵݹ鷽�������ò�α�����
 * ÿһ��ʹ��һ�����У�ÿ����һ����ȼ�1
 * 
 */
public class BinaryTreeDeep {

	public static void main(String[] args) {
	
		BinaryTree root = new BinaryTree(1);
		BinaryTree rl2 = new BinaryTree(2);
		BinaryTree rl3 = new BinaryTree(3);
		BinaryTree rl4 = new BinaryTree(4);
		BinaryTree rl5 = new BinaryTree(5);
		BinaryTree rl6 = new BinaryTree(6);
		BinaryTree rl7 = new BinaryTree(7);
		BinaryTree rl8 = new BinaryTree(8);
		BinaryTree rl9 = new BinaryTree(9);
		//����һ�����Ϊ5�Ķ�����
		root.lefTree = rl2;
		root.rightTree = rl3;
		rl2.lefTree = rl4;
		rl2.rightTree = rl5;
		rl3.lefTree = rl6;
		rl3.rightTree = rl7;
		rl7.lefTree = rl8;
		rl8.rightTree = rl9;
		
		int deep = findDeep(root);
		
		System.out.println("�����Ϊ�� " + deep);
		
		int deepth = findDeepNoDG(root);
		
		System.out.println("�ǵݹ鷽����ã������Ϊ�� " + deepth);
		
	}
	/**
	 * �ǵݹ鷽�������ĸ߶�
	 * ʹ�ò�α�����ÿ�ν�һ���������У�
	 * ���ӵ�ʱ�򣬽����ӷ�������У�
	 * ��Ҫ��סÿ���ж��ٽڵ㣬ÿ����һ���+1
	 * @param root
	 * @return
	 */
	private static int findDeepNoDG(BinaryTree root) {
		int level = 0;
		LinkedList<BinaryTree> queue = new LinkedList<>();
		//���
		queue.offer(root);
		
//		while (queue != null) {		�ر�ע�⣺�ж�Ϊ�գ�����ʹ�� == null���жϣ�����
		while (!queue.isEmpty()) {
				
			//size��¼�ӳ���;outNum��¼�Ѿ����ӵ�Ԫ�ظ���
			int size = queue.size();
			int outNum = 0;
			
			while (outNum < size) {
				//����
				BinaryTree currTree = queue.poll();
				//�������������������У����ǲ���Ӱ��ӳ����ӳ��Ѿ���¼��
				if (currTree.lefTree != null) {
					queue.offer(currTree.lefTree);
				}
				if (currTree.rightTree != null) {
					queue.offer(currTree.rightTree);
				}
				outNum++;
			}
			//������һ�㣬����+1
			level++;
		}
		return level;
	}

	/**
	 * �ݹ����������
	 * @param root
	 * @return
	 */
	private static int findDeep(BinaryTree root) {
		
		int leftDeep = 0;
		int rightDeep = 0;
		
		if (root == null) {
			return 0;
		}
		if (root.lefTree != null) {
			leftDeep = findDeep(root.lefTree);
		}
		if (root.rightTree != null) {
			rightDeep = findDeep(root.rightTree);
		}
		//ע���������ط���Ҫ+1
//		return leftDeep > rightDeep ? leftDeep + 1 : rightDeep + 1;
		return Math.max(leftDeep+1, rightDeep+1);
	}

}
