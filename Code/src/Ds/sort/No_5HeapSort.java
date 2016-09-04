package Ds.sort;
/**
 * 堆排序
 * 1:介绍
 * （1）分为大根堆和小根堆
 * （2）是一棵完全二叉树
 * （3）满足如下属性
 * 		a)每个节点的值，都不大于其父节点（以大根堆为例）
 * 思想：
 * S1:将初始文件，[1...n]建为一个大根堆，{初始无序区，堆顶为最大元素}
 * S2:将关键字最大的记录R[1]（即堆顶）和无序区的最后一个记录R[n]交换，
 * 由此得到新的无序区R[1..n-1]和有序区R[n]，且满足R[1..n-1].keys≤R[n].key
 * S3:交换后，新的根可能会违反大根堆的性质，对当前无序堆R[1,n-1]进行调整
 * ……循环直到无序区只有一个元素
 * 
 * 调整堆：
 * 从	len/2---0	依次调整
 * 
 * 1：输入：数组和需要调整的位置
 * 2：判断左右孩子是否存在，如果都存在，找到左右孩子中最大的，如果大于根节点和根节点交换，若是只存在左孩子，则只比较左孩子和当前节点
 * 
 * 2：时间复杂度
 * （1）建堆 O(n)
 * （2）排序logn
 * （3）总时间复杂度：nlogn
 * 
 * 3:空间复杂度
 * （1）O(1)每次对一个元素进行操作，只需要一个辅存
 * 
 * 4：稳定性：
 * 不稳定性排序
 * 
 * @author Administrator
 *
 */
public class No_5HeapSort {

	public static void main(String[] args) {
		
		int[] arr = {11,23,13,47,15,187,-1,36,97,25};
		No_5HeapSort heapSort = new No_5HeapSort();
		//排序前：
		System.out.println("排序前：");
		heapSort.print(arr);
		//建堆：
		heapSort.buildHeap(arr);
		//堆排序：依次将最后一个元素，与第一个元素交换，交换之后，重新调整堆，直到数组中还剩最后一个元素
		for (int index = arr.length-1; index >= 1; index--) {
			//每次交换 最后一个元素 和堆顶元素
			exchangeIndexAndZero(arr,0,index);
//			arr = exchangeIndexAndZero(arr,0,index);
			//调整堆
			adjustHeap(arr,index,0);
		}
		//排序后：
		System.out.println("排序后：");
		heapSort.print(arr);
		
	}
	
	
	private static int[] exchangeIndexAndZero(int[] arr, int i, int index) {
		int temp = arr[i];
		arr[i] = arr[index];
		arr[index] = temp;
		return arr;
	}


	/**
	 * 建堆方法：
	 * 从len/2---0依次调整堆
	 * @param arr
	 */
	private void buildHeap(int[] arr) {
		for (int i = arr.length/2; i >= 0; i--) {
			adjustHeap(arr,arr.length,i);
		}
	}
	/**
	 * 调整堆的方法：
	 * @param arr
	 * @param heapSize
	 * @param index
	 */
	private static void adjustHeap(int[] arr, int heapSize, int index) {
		//注意下边
		int left = 2*index+1;
		int right = 2*index+2;
		int lagest = index;
		//左孩子存在，而且大于index
		if (left < heapSize && arr[left] > arr[index]) {
			lagest = left;
		}
		//右孩子存在，而且大于现在的最大值
		if (right < heapSize && arr[right] > arr[lagest]) {
			lagest = right;
		}
		//说明 index 不是最大的，需要调整
		if (index != lagest) {
			//交换位置
			exchangeIndexAndZero(arr,index,lagest);
			//注意这时候  堆大小不变，但是largest位置为左右孩子的位置，即调整左右孩子的子堆
			adjustHeap(arr, heapSize, lagest);
		}
	}
	/**
	 * 工具方法，打印数组
	 * @param arr
	 */
	private void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + "\t");
		}
	}

}
