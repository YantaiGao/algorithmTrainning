package Ds.sort;

/**
 * @author Administrator
 * 
 * 插入排序
 * 	思想：
 * 	将待排序数据分成两部分，一部分是有序的，不断的将另一部分插入到有序数组的合适的位置
 *  每一步将一个待排序的数据，按照其关键字的插入到已排序部分适当位置上
 * 	
 * 	算法思路：（设从小到大序）
 * 	设第一个元素是有序的，每次将新元素从后向前找位置，小于则交换，找到合适位置插入
 * 		
 *
 */

public class No_1ChaRuSort {

	public static void main(String[] args) {
		int[] a = {3,23,6,45,2,89,100,4,66};
		No_1ChaRuSort sort = new No_1ChaRuSort();
		
		a = sort.charuSort(a);
		
		for (int i : a) {
			System.out.print(i + "\t");
		}
		
	}

	private int[] charuSort(int[] a) {
		
		if (a == null || a.length < 2) {
			return a;
		}
		
		//从第二个元素依次插入有序数组	注意：i的序号是从1到小于等于a.length-1（注意：有-1所以等于号）,使用<length就可以
		//for (int i = 1; i <= a.length-1; i++) {
		for (int i = 1; i < a.length; i++) {
			//每次从后向前找位置——注意这个找位置的过程——j = i 与前一个数j-1比
			for (int j = i; j > 0; j--) {
				if (a[j-1] > a[j]) {
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}else {
					//若是已经小于，则不需要继续向前比较
					break;
				}
			}
		}
		
		return a;
		
	}

}
