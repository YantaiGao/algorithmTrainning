package Ds.sort;
/**
 * 
 * @author Administrator
 *	
 * 希尔排序：
 * 插入排序的一种，
 * 将待排记录分为一定的增量组，对每组使用直接插入排序算法排序，随着增量d的逐渐减小，每组数据越来越多，直到d=1，整个数据就是有序的，算法终止。
 * 
 * 先取一个正整数d1<n，
 * 把所有序号相隔d1的数组元素放一组，组内进行直接插入排序；
 * 然后取d2<d1，重复上述分组和排序操作；
 * 直至di=1，即所有记录放进一个组中排序为止。
 * 
 * d的取值直接影响了算法的效率：
 * 简单的取法：
 * d1 = len/2，以后每次都是 d/2,直到d==1
 * 
 * 
 * 稳定性：
 * 不稳定在分组后，经过组内排序，可能会使原来的顺序发生改变
 * 
 * 时间复杂度：
 *  n^1.3左右.
 * 
 */
public class No_4ShellSort {

	public static void main(String[] args) {
		int[] a = {49,38,65,97,76,13,27,49,55,4};
		No_4ShellSort sort = new No_4ShellSort();
		
		a = sort.shellSort(a);
		
		for (int i : a) {
			System.out.print(i + "\t");
		}
	}

	private int[] shellSort(int[] a) {

		//控制d，从len/2到1
		for (int d=a.length/2; d > 0; d=d/2) {
			
			//控制对于每一个d的操作
			
			//重要：对于每个d，0-（d-1）是d个分组的第一个元素，
			//按照插入排序，应该是每组内元素，从前向后进行插入排序，
			//实际上: 是从第d个元素到最后一个元素都需要进行插入排序，而且互相之间的距离都是d
			//所以这个内层循环是从d到最后一个元素找到合适的插入位置
			for (int i = d; i < a.length; i++) {
				//给第i个元素,a[i],找到正确的插入位置
				int j = 0;
				int temp = a[i];
				//从后向前去有序数组中找位置，
				//j>=d是因为每组的第一个不需要找位置
				for (j = i; j >= d; j=j-d) {
					//temp小，后移，之所以能覆盖是因为a[i]已经保存了
					//特别注意：这里需要使用temp进行比较
					if (temp < a[j-d]) {
						a[j] = a[j-d];
					}else {
						//前边是有序的，再比较没有意义，已经找到位置
						break;
					}
				}
				a[j] = temp;
			}
			
		}
		
		return a;
	}
}
