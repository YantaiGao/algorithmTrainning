package offer_aimTo.Ch02;

/**
 * 问题描述：
 * 
 * 旋转数组：
 * 将一个有序数组最开始的若干元素放到数组的末尾，称为数组的旋转。
 * Eg：3,4,5,1,2 是1,2,3,4,5的一个旋转
 * 输入一个 旋转数组，求数组的最小值。
 * 
 * 思路：
 * 遍历数组，求最小的元素，复杂度为O(n)
 * 可以使用二分查找，降低复杂度O(lgn)
 * 
 * 特殊案例：
 * 0,1,2,3,4,5
 * 1,1,1,1,1,1
 * @author lenovo
 *
 */
public class Ch02_XZArraySmallest {

	public static void main(String[] args) {

		int[] arr = {3,4,5,1,2};
//		int[] arr = {1,1,1,1,1};
//		int[] arr = {0,1,2,3,4};//这个bug还没解决
		Ch02_XZArraySmallest xuanzhuanArr = new Ch02_XZArraySmallest();
		int small = xuanzhuanArr.smallest(arr);
		System.out.println("最小的元素是：" + small);
	}

	private int smallest(int[] arr) {
		
		int low = 0;
		int high = arr.length-1;
		int res = -1;
		
		while (arr[low] >= arr[high]) {
		
			//找到了，终止条件
			if ((high-low) == 1) {
				res = arr[high];
				break;
			}
			
			int mid = (low+high)/2;
			
			//特殊情况：low=high=mid的时候，只能顺序查找
			if (arr[low] == arr[high] && arr[low] == arr[mid]) {
				res =  INMID(arr);
			}
			
			if (arr[mid] >= arr[low]) {
				//注意这时候不能再+1，下边的也不能再减一，因为很能会越过最小的元素
				low = mid;
			}else if (arr[mid] <= arr[high]) {
				high = mid;
			}
			
		}
		return res;
	}

	private int INMID(int[] arr) {
		int min = arr[0];
		for (int i : arr) {
			if (i<min) 
				min = i;
		}
		return min;
	}

}
