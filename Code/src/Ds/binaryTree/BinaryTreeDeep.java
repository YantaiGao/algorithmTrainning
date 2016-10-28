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
 * @author 高延太
 * 2016-10-28
 * 
 * 需求：
 * 求二叉树的深度
 * 
 * 方法一：
 * 使用递归的方法，求左右子树的深度，然后求最大的
 * 
 * 方法二：
 * 非递归方法，利用层次遍历，
 * 每一层使用一个队列，每遍历一层深度加1
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
		//构造一个深度为5的二叉树
		root.lefTree = rl2;
		root.rightTree = rl3;
		rl2.lefTree = rl4;
		rl2.rightTree = rl5;
		rl3.lefTree = rl6;
		rl3.rightTree = rl7;
		rl7.lefTree = rl8;
		rl8.rightTree = rl9;
		
		int deep = findDeep(root);
		
		System.out.println("树深度为： " + deep);
		
		int deepth = findDeepNoDG(root);
		
		System.out.println("非递归方法求得，树深度为： " + deepth);
		
	}
	/**
	 * 非递归方法求树的高度
	 * 使用层次遍历，每次将一层放入队列中，
	 * 出队的时候，将孩子放入队列中，
	 * 需要记住每层有多少节点，每遍历一层就+1
	 * @param root
	 * @return
	 */
	private static int findDeepNoDG(BinaryTree root) {
		int level = 0;
		LinkedList<BinaryTree> queue = new LinkedList<>();
		//入队
		queue.offer(root);
		
//		while (queue != null) {		特别注意：判断为空，不能使用 == null来判断！！！
		while (!queue.isEmpty()) {
				
			//size记录队长度;outNum记录已经出队的元素个数
			int size = queue.size();
			int outNum = 0;
			
			while (outNum < size) {
				//出队
				BinaryTree currTree = queue.poll();
				//含有左右子树则加入队列，但是不会影响队长，队长已经记录了
				if (currTree.lefTree != null) {
					queue.offer(currTree.lefTree);
				}
				if (currTree.rightTree != null) {
					queue.offer(currTree.rightTree);
				}
				outNum++;
			}
			//遍历完一层，层数+1
			level++;
		}
		return level;
	}

	/**
	 * 递归求树的深度
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
		//注意最后这个地方需要+1
//		return leftDeep > rightDeep ? leftDeep + 1 : rightDeep + 1;
		return Math.max(leftDeep+1, rightDeep+1);
	}

}
