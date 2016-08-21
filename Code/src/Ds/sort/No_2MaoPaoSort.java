package Ds.sort;

/**
 * @author Administrator
 * 
 *  冒泡排序：（设按从小到大序）
 *  每轮，从头开始依次比较相邻的元素，如果第一个比第二个大，就交换
 *  经过第一次之后最后边的是最大的元素，下一轮的时候还是从头到尾继续两两比较，只是不再到尾，去掉上一轮确定的最大的元素
 *  
 *  只有大于或者小于交换，是稳定性算法
 *  
 *  时间复杂度：
 *  最差的情况是：
 *  第一轮交换n-1次最后一轮交换1次
 *  1+2+3+...+ n-1
 *  (1+n-1)*n/2 
 *  时间复杂度是n^2
 *
 */
public class No_2MaoPaoSort {

	public static void main(String[] args) {
		No_2MaoPaoSort sort = new No_2MaoPaoSort();
		
		int[] a = {3,23,6,45,2,89,100,4,66};
		
		a = sort.maopaoSort(a);
		
		for (int i : a) {
			System.out.print(i + "\t");
		}
	}

	private int[] maopaoSort(int[] a) {
		if (a == null || a.length < 2) {
			return a;
		}
		
		//外部循环控制:（控制的是长度）
		//n-1轮，第一次是a.length，即应该是从头到尾全部的长度，
		//以后每轮长度减一，以后每次都少一个是因为每轮排序会确定一个最大（或者最小）的
		
		//必须注意的是：这里i必须从a.length - 1开始，这是因为在后边有 j + 1
		for (int i = a.length - 1; i > 0; i--) {
			//对于每轮循环，从头到尾两两比较，若是前边的比后边的大（或者小）则交换
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp; 
				}
			}
		}
		return a;
	}

}
