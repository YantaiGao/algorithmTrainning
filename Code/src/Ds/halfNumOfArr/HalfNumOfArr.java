package Ds.halfNumOfArr;

/**
 * 求数组中出现次数超过一半的元素，有则返回该数，没有则返回-1
 * 思路：
 * 一：
 * 	将数组进行排序，如果存在次数超过一半的元素，则最中间位置的数一定是这个数。
 *  这样做的前提是数组中一定存在出现次数超过一半的元素
 *  排序的时间复杂度是：O(n*logn) 
 *  
 * 二：
 * 	经过推理可知，出现次数超过一半的元素的出现次数，比其他所有元素的出现次数的和还要多。
 *  则使用以下算法：
 *  	遍历这个数组，记录两个值，一个是数组中的元素的值value，一个是次数count。
 *  	当下一个元素与当前保存的元素相同，则 count+1，否则count-1;
 *  	若是count的值等于0，则将value的值更新为新值，并设count=1
 *  	到最后如果存在次数出现超过一半的元素，则count的值一定大于0，value中保存的值就是我们要找的元素。
 *  	特别注意：最后不能根据count是不是等于几来判断，因此只能根据最后的到的值去数组中验证这个数真的出现次数超过一半，需要遍历一下数组
 *  	时间复杂度：O(n);空间复杂度O(1)
 *  
 * @author Administrator
 *
 */
public class HalfNumOfArr {

	public static void main(String[] args) {
		
		int[] arr = {3,1,2,3,4,5,3,2,3,2,3,4,3,3,1,3,3};
		
		int[] arr1 = {1,2,3};//这是一个bug案例，若是直接使用count!=0来判断，可能就会出错
		
//		int res = findHalfNumOfArr(arr);
	
		int res = findHalfNumOfArr(arr1);
		
		if (res==-1) {
			System.out.println("不存在出现次数超过一半的元素。");
		}else {
			System.out.println("出现次数超过一半的元素为：" + "\t" + res);
		}
		
		
		
	}

	private static int findHalfNumOfArr(int[] arr) {
		int value=arr[0];
		int count = 1;
		//遍历数组
		for (int i = 1; i < arr.length; i++) {
			//次数为0，更新新的数据和长度
			if (count==0) {
				value = arr[i];
				count = 1;
			}else if (arr[i] == value) {
				count++;
			}else {
				count--;
			}
		}
		//这样判断是不对的，当3个元素的时候count最后可能为1
//		if (count != 0) {
//			return value;
//		}else {
//			return -1;
//		}
		
		if(IsMoreThanHalf(arr,value)){
			return value;
		}else {
			return -1;
		}
	}

	
	/**
	 * 必须使用这个来判断是不是超过一半
	 */
	private static boolean IsMoreThanHalf(int[] arr, int value) {
		int len =  arr.length;
		int time = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				time++;
			}
		}
		if (2 * time <= len) {
			return false;
		}else {
			return true;
		}
	}
}
