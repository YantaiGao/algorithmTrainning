package offer_aimTo.Ch02;

import java.util.Arrays;

public class Ch02_RebulitTwoBinTree {
	/**
	 * Ŀ�꣺ͨ��������ǰ���������и��������ؽ�������
	 * 
	 * ע�⣺����������������⣬��δ�����꣬��Ҫ��һ������
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Integer[] preOrderArr = {1,2,4,7,3,5,6,8};
		Integer[] inOrderArr = {4,7,2,1,5,3,8,6};
		Ch02_RebulitTwoBinTree bTree = new Ch02_RebulitTwoBinTree();
		//��int����ᱨ��
		bTree.rebulitTree(preOrderArr,inOrderArr);
		
	}

	/**
	 * Ŀ�꣺
	 * �����ȸ������е�һ���ڵ㣬�ҵ�����Ȼ��ȥ�������ҵ�index,��indexǰ�����������������������
	 * ע����������Ĵ���
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
	 * Ŀ�꣺��ָ��ֵ��������λ�ã������ڷ���-1����ʵ����������������ᷢ��
	 * ������������������ؽ����������У����ܰ����ظ��Ľڵ�ֵ
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
	//ע�⣺���캯����������������
	public BinaryTree(T val) {
		data = val;
		lchild = null;
		rchild = null;
	}
}