package Ds.sort;
/**
 * @author Administrator
 * 快排：
 *  外部是一个递归方法：
 *  首先，找到划分位置p，使数组左边的数据都小于a[p],右边的数据都大于a[p]
 *  然后在左右两边部分递归调用快排算法
 *  
 *  每轮能找到a[p]的最终的位置。
 *  
 *  所以比较重要的就是partition方法， 详见下边的代码中的分析。
 *  
 *  不稳定算法
 *  
 *  时间复杂度：
 *  一共需要n轮，最差每轮都需要交换，但是是分半的，所以最差是：nlogn
 *  
 */
public class No_3QuickSort {

	public static void main(String[] args) {
		int[] a = {49,38,65,97,76,13,27,49};
		int left = 0;
		
		//注意：right是len-1
		int right = a.length-1;
		
		quickSort(a,left,right);
		for (int i : a) {
			System.out.print(i + "\t");
		}
		
	}

	private static void quickSort(int[] a, int left, int right) {
		
		int p;
		/**
		 * 注意：这个判断条件必须要有！！！
		 */
		if (left < right) {
			p = partition(a,left,right);
//			p = partition_new(a,left,right);
			quickSort(a,left,p-1);
			quickSort(a,p+1,right);
		}
		
	}
	
	/**
	 * 原始版:
	 * @param a
	 * @param left
	 * @param right
	 * @return
	 * 49,38,65,97,76,13,27,49
	 * 第一轮详情：
	 * 49,38,65,97,76,13,27,49（left=0 right=7 p=a[0]=49）
	 * 从后向前找 < P的，找到后交换
	 * 27,38,65,97,76,13,49,49（这时候27 < p，交换27 49，right = 6,left++后= 1）
	 * 从前向后找 > p的，找到后交换
	 * 27,38,49,97,76,13,65,49（这时候 65 > p，交换 49 65 left = 2,right--后= 5 ）
	 * 一直这样进行下去，直到left = right
	 * 第一轮结果就是：
	 * 27,38,13,49,76,97,65,49
	 * 
	 */
	private static int partition(int[] a, int left, int right) {
		
		int p = a[left];
		
		while(left < right){
			//从后向前，如果一直大于等于p，right位置指针就前移
			while (left < right && a[right] >= p) 
				right--;
			if (left < right) {
				//交换a[right]和a[left]，left++
				int temp = a[right];
				a[right] = a[left];
				a[left] = temp;
				left++;
			}
			//从前向后，如果一直小于等于p，left位置指针就后移
			while (left < right && a[left] <= p) 
				left++;
			if (left < right) {
				//交换a[left]和a[right]，right--
				int temp = a[right];
				a[right] = a[left];
				a[left] = temp;
				right--;
			}
		}
		
		//最终left==right,返回确定的这个位置
		return left;
	}

	/**
	 * 优化版：
	 * 每次交换的时候，并不交换，因为p初始值已经被记下来，所以数组中会有一个位置，可以用来缓存
	 * @param a
	 * @param left
	 * @param right
	 * @return
	 * 
	 * 49,38,65,97,76,13,27,49
	 * 第一轮详情：
	 * 49,38,65,97,76,13,27,49（left=0 right=7 p=a[0]=49）
	 * 从后向前找 < P的，找到后赋值过去，原来位置上的数还是不变，等待下次覆盖就行
	 * 27,38,65,97,76,13,27,49（这时候27 < p，27覆盖49(因为49已经被保存为p)，right = 6,left++后= 1）
	 * 从前向后找 > p的，找到后交换
	 * 27,38,65,97,76,13,65,49（这时候 65 > p,65直接覆盖a[right](因为27已经被弄到前边去了); left = 2,right--后= 5 ）
	 * 从后向前 
	 * 27,38,13,97,76,13,65,49(13覆盖65)
	 * 从前向后
	 * 27,38,13,97,76,97,65,49(97覆盖13)
	 * 从后向前，直到right = 3， = left
	 * 27,38,13,97,76,97,65,49
	 * 
	 * 
	 * 一直这样进行下去，直到left = right
	 * 这时候结果为：
	 * 27,38,13,97,76,97,65,49
	 * 
	 * 此时应该把49放到 3的位置上去：
	 * 
	 * 第一轮结果就是：
	 * 27,38,13,49,76,97,65,49
	 * 
	 */
	private static int partition_new(int[] a, int left, int right) {
		int p = a[left];
		while (left < right) {
			while (left < right && a[right] >= p) 
				right--;
			if (left < right) {
				a[left++] = a[right];
			}
			while (left < right && a[left] <= p) 
				left++;
			if (left < right) {
				a[right--] = a[left];
			}
		}
		//这时候一定要把p放到找到的位置上去
		a[left] = p;
		//返回划分的位置
		return left;
	}
}
