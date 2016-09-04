package Ds.sort;
/**
 * ������
 * 1:����
 * ��1����Ϊ����Ѻ�С����
 * ��2����һ����ȫ������
 * ��3��������������
 * 		a)ÿ���ڵ��ֵ�����������丸�ڵ㣨�Դ����Ϊ����
 * ˼�룺
 * S1:����ʼ�ļ���[1...n]��Ϊһ������ѣ�{��ʼ���������Ѷ�Ϊ���Ԫ��}
 * S2:���ؼ������ļ�¼R[1]�����Ѷ����������������һ����¼R[n]������
 * �ɴ˵õ��µ�������R[1..n-1]��������R[n]��������R[1..n-1].keys��R[n].key
 * S3:�������µĸ����ܻ�Υ������ѵ����ʣ��Ե�ǰ�����R[1,n-1]���е���
 * ����ѭ��ֱ��������ֻ��һ��Ԫ��
 * 
 * �����ѣ�
 * ��	len/2---0	���ε���
 * 
 * 1�����룺�������Ҫ������λ��
 * 2���ж����Һ����Ƿ���ڣ���������ڣ��ҵ����Һ��������ģ�������ڸ��ڵ�͸��ڵ㽻��������ֻ�������ӣ���ֻ�Ƚ����Ӻ͵�ǰ�ڵ�
 * 
 * 2��ʱ�临�Ӷ�
 * ��1������ O(n)
 * ��2������logn
 * ��3����ʱ�临�Ӷȣ�nlogn
 * 
 * 3:�ռ临�Ӷ�
 * ��1��O(1)ÿ�ζ�һ��Ԫ�ؽ��в�����ֻ��Ҫһ������
 * 
 * 4���ȶ��ԣ�
 * ���ȶ�������
 * 
 * @author Administrator
 *
 */
public class No_5HeapSort {

	public static void main(String[] args) {
		
		int[] arr = {11,23,13,47,15,187,-1,36,97,25};
		No_5HeapSort heapSort = new No_5HeapSort();
		//����ǰ��
		System.out.println("����ǰ��");
		heapSort.print(arr);
		//���ѣ�
		heapSort.buildHeap(arr);
		//���������ν����һ��Ԫ�أ����һ��Ԫ�ؽ���������֮�����µ����ѣ�ֱ�������л�ʣ���һ��Ԫ��
		for (int index = arr.length-1; index >= 1; index--) {
			//ÿ�ν��� ���һ��Ԫ�� �ͶѶ�Ԫ��
			exchangeIndexAndZero(arr,0,index);
//			arr = exchangeIndexAndZero(arr,0,index);
			//������
			adjustHeap(arr,index,0);
		}
		//�����
		System.out.println("�����");
		heapSort.print(arr);
		
	}
	
	
	private static int[] exchangeIndexAndZero(int[] arr, int i, int index) {
		int temp = arr[i];
		arr[i] = arr[index];
		arr[index] = temp;
		return arr;
	}


	/**
	 * ���ѷ�����
	 * ��len/2---0���ε�����
	 * @param arr
	 */
	private void buildHeap(int[] arr) {
		for (int i = arr.length/2; i >= 0; i--) {
			adjustHeap(arr,arr.length,i);
		}
	}
	/**
	 * �����ѵķ�����
	 * @param arr
	 * @param heapSize
	 * @param index
	 */
	private static void adjustHeap(int[] arr, int heapSize, int index) {
		//ע���±�
		int left = 2*index+1;
		int right = 2*index+2;
		int lagest = index;
		//���Ӵ��ڣ����Ҵ���index
		if (left < heapSize && arr[left] > arr[index]) {
			lagest = left;
		}
		//�Һ��Ӵ��ڣ����Ҵ������ڵ����ֵ
		if (right < heapSize && arr[right] > arr[lagest]) {
			lagest = right;
		}
		//˵�� index �������ģ���Ҫ����
		if (index != lagest) {
			//����λ��
			exchangeIndexAndZero(arr,index,lagest);
			//ע����ʱ��  �Ѵ�С���䣬����largestλ��Ϊ���Һ��ӵ�λ�ã����������Һ��ӵ��Ӷ�
			adjustHeap(arr, heapSize, lagest);
		}
	}
	/**
	 * ���߷�������ӡ����
	 * @param arr
	 */
	private void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + "\t");
		}
	}

}
