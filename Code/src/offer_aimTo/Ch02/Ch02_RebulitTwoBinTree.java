package offer_aimTo.Ch02;

import java.util.Arrays;

public class Ch02_RebulitTwoBinTree {
	/**
	 * 目标：通过给定的前根遍历和中根遍历，重建二叉树
	 * 
	 * 注意：这个程序现在有问题，尚未处理完，需要进一步处理
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Integer[] preOrderArr = {1,2,4,7,3,5,6,8};
		Integer[] inOrderArr = {4,7,2,1,5,3,8,6};
		Ch02_RebulitTwoBinTree bTree = new Ch02_RebulitTwoBinTree();
		//用int数组会报错
		bTree.rebulitTree(preOrderArr,inOrderArr);
		
	}

	/**
	 * 目标：
	 * 根据先根遍历中第一个节点，找到根，然后去中序中找到index,则index前的是左子树，后的是右子树
	 * 注意结束条件的处理：
	 * @param preOrderArr
	 * @param inOrderArr
	 */
	private <T> BinaryTree<T> rebulitTree(T[] preOrderArr, T[] inOrderArr) {
			
		BinaryTree<T> root = new BinaryTree<T>(preOrderArr[0]);
		int index = getIndex(inOrderArr,preOrderArr[0]);
		
		T[] lpreArr = Arrays.copyOfRange(preOrderArr, 1, index+1);
		T[] rpreArr = Arrays.copyOfRange(preOrderArr, index+1, preOrderArr.length);
		
		T[] linArr = Arrays.copyOfRange(inOrderArr, 0, index);
		T[] rinArr = Arrays.copyOfRange(inOrderArr, index+1, inOrderArr.length);
		
		BinaryTree<T> lchild = rebulitTree(lpreArr, linArr);
		BinaryTree<T> rchild = rebulitTree(rpreArr, rinArr);
		
		root.rchild = rchild;
		root.lchild = lchild;
		
		return root;	
	}

	/**
	 * 目标：求指定值在数组中位置，不存在返回-1，其实不存在这种情况不会发生
	 * 这个方法决定了这种重建方法的树中，不能包含重复的节点值
	 * @param inOrderArr
	 * @param val
	 * @return
	 */
	private <T> int getIndex(T[] inOrderArr,T val) {
		for (int i = 0; i < inOrderArr.length; i++) {
			if (inOrderArr[i] == val) {
				return i;
			}
		}
		return -1;
	}

}
class BinaryTree<T>{
	T data;
	BinaryTree<T> lchild;
	BinaryTree<T> rchild;
	//注意：构造函数中类名不带泛型
	public BinaryTree(T val) {
		data = val;
		lchild = null;
		rchild = null;
	}
}