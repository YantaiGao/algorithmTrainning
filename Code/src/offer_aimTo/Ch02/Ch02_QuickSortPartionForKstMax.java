package offer_aimTo.Ch02;

public class Ch02_QuickSortPartionForKstMax {
	/**
	 * 快速排序的partition函数，不仅可以用在快排中，还可以用来计算长度为n的数组中查找第k大的数字
	 * 
	 * 数组长度为len，第k大，
	 * eg:Len = 10,第一大应返回，a[9]
	 * 返回的是：len-k
	 * 即找到index为len-k的数
	 * 
	 * @param args
	 * @author Administrator
	 */
	public static void main(String[] args) {
		int[] a = {12,243,53,6,89,1234,4,10,324};
		
		for (int k = 1; k <= a.length; k++) {

			int res;
			Ch02_QuickSortPartionForKstMax kThMax = new Ch02_QuickSortPartionForKstMax();

			//特别需要注意的是：使用快排算法，前边是0，后边界是len-1
			res = kThMax.findTheKthMax(a,0,a.length-1,a.length-k);
			
			System.out.println("第" + k +"大的数是：" + res);
	
		}

	}

	/**
	 * 注意：当第一次传过来的数是len-k的时候，每次就找index==k,就好了
	 * @param a
	 * @param left
	 * @param right
	 * @param k
	 * @return
	 */
	private int findTheKthMax(int[] a, int left, int right, int k) {
		int p = 0;
		if (left < right) {
			p = partition(a,left,right);
			if (p == k) {
				return a[p];
			} else if (p > k) {
				findTheKthMax(a, left, p-1, k);
			}else {
				findTheKthMax(a, p+1, right, k);
			}
		}
		
		return a[k];
	}
	
	//快排的partition()方法——完全相同
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
