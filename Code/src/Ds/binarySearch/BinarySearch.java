package Ds.binarySearch;

/**
 * 二分查找
 * 时间复杂度：O(lgn)
 * 注意：while中的终止条件是left<=high即可
 * @author lenovo
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		
		int[] array = new int[20];
		for (int i = 0; i < array.length; i++) {
			array[i] = i+20;
			System.out.print(array[i]+"\t");
		}
		System.out.println();
		int x = 41;
		int res = -1;
		BinarySearch bs = new BinarySearch();
		res = bs.binarySearch(array,x);
		if (res!=-1) {
			System.out.println(x+"的Loc："+res);
		}else {
			System.out.println(x+"不存在");
		}
		
	}

	private int binarySearch(int[] array, int x) {
		int low = 0;
		int high = array.length - 1;
		while ((low<=high)) {
			int middle = (low+high)/2;
			if (array[middle] == x) {
				return middle;
			}else if (array[middle] > x) {
				high = middle-1;
			}else {
				low = middle+1;
			}
		}
		return -1;
	}


}
