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
		
		//从第二个元素依次插入有序数组
		for (int i = 1; i < a.length-1; i++) {
			//每次从后向前找位置
			for (int j = i; j < 0; j--) {
				if (a[i] < a[j]) {
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
		}
		return a;
	}

}
