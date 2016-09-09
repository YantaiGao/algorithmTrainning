package Ds.topK;

/**
* TopK问题：
* 
* (1)大数据情景下：
* 
*  采用大根堆或者小根堆，
*  特别注意：当需要topK大的时候，使用小根堆；当需要topK小的时候，使用大根堆。
*  
*  以topK大为例:
*     1：先建立一个小根堆，
*     2：扫描剩下的N-k个元素，
*        对每个元素，
*        如果大于小根堆的根节点，则覆盖根节点为该数据，并调整至小根堆
*        如果小于根节点，无变化。  
* 	
*  时间复杂度：O(nlogk),每次调整堆的时间复杂度为O(logk),一共大约n个元素
*  
*     
*/
public class TopK {

	public static void main(String[] args) {
		
		int[] arr = {30,4,5,23,8,12,44,89,123,432};
		int k = 3;
		int[] res = getTopKByHeap(arr,k);
		
		System.out.println("Top " + k + "情况如下：");
		
		for (int i : res) {
			System.out.print(i + "\t");
		}
		
	}

	private static int[] getTopKByHeap(int[] arr, int k) {
		
		//创建一个K的小根堆
		int[] heap = createHeap(arr,k);
		
		for (int i = k; i < arr.length; i++) {
			if (arr[i]>heap[0]) {
				insert(heap,arr[i]);
			}
		}
		return null;
	}
	/**
	 * 依次将元素插入到堆中
	 * @param heap
	 * @param i
	 */
	private static void insert(int[] heap, int i) {
		
	}

	/**
	 * 创建一个大小为k的堆
	 * @param arr
	 * @param k
	 * @return
	 */
	private static int[] createHeap(int[] arr, int k) {
		return null;
	}

}
