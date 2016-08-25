package offer_aimTo;

public class Ch02_QuickSortPartionForKstMax {
	/**
	 * 快速排序的partition函数，不仅可以用在快排中，还可以用来计算长度为n的数组中查找第k大的数字
	 * @param args
	 * @author Administrator
	 */
	public static void main(String[] args) {
		int[] a = {12,243,53,6,89,1234,4,10,234};
		int k = 5;
		int res;
		Ch02_QuickSortPartionForKstMax kThMax = new Ch02_QuickSortPartionForKstMax();
		//现在找的是第k小，而且应该使用k-1
		res = kThMax.findTheKthMax(a,0,a.length-1,k);
		System.out.println("第" + k +"大的数是：" + res);
	}

	private int findTheKthMax(int[] a, int left, int right, int k) {
		int p = 0;
		if (p != k) {
			p = partition(a,left,right);
			if (p < k) {
				findTheKthMax(a, p+1, right, k-p);
			}else {
				findTheKthMax(a, left, p-1, k);
			}
		}
		
		return a[k];
	}
	
	//快排的partition()方法
	private int partition(int[] a, int left, int right) {
		int temp = a[left];
		while (left < right) {
			while (left < right && a[right] >= temp)
				right--;
			if (left < right) 
				a[left++] = a[right];
			while (left < right && a[left] <= temp)
				left++;
			if (left < right) 
				a[right--] = a[left];
		}
		a[left] = temp;
		return left;
	}

}
