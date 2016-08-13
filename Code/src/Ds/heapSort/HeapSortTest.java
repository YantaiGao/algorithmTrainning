package Ds.heapSort;

import java.util.Arrays;

public class HeapSortTest {

	public static void main(String[] args) {
		
		int[] a = {11,23,13,47,15,187,-1,36,97,25};
		 
		HeapSortTest hs = new HeapSortTest();
		//print
		System.out.println("Before:");
		hs.print(a);
		//����
		hs.buildHeap(a);
		//����
		hs.sort(a);
		//print
		System.out.println("After:");
		hs.print(a);
	}

	private void buildHeap(int[] a) {
		for (int i = a.length/2 - 1; i >= 0 ; i--) {
			adjustHeap(a,i);
		}
	}

	private void adjustHeap(int[] a,int index) {
			int left = 2 * index +1;
			int right = 2 * index +2;
			//������ҽڵ㶼���ڣ��ҵ����ҽڵ������뵱ǰ�ڵ�Ƚϣ�����ֱ�ӱȽ���ڵ��뵱ǰ�ڵ�
			if ( right <= a.length -1) {
				if (a[left] > a[right]) {
					if (a[left] > a[index]) {
						exchangeElement(a,index,left);
						//����������
						adjustHeap(a, left);
					}
				}else {
					if (a[right] > a[index]) {
						exchangeElement(a,index,right);
						//����������
						adjustHeap(a, right);
					}
				}
			}else {
				if (left <= a.length-1 && a[left] > a[index]) {
					exchangeElement(a,index,left);
					//����������
					adjustHeap(a, left);
				}
			}
			
	}

	private void sort(int[] a) {
		int[] b = a;
		for (int i = b.length-1; i >= 0; i--) {
			int temp = b[i];//�����������һ��
			a[i] = b[0];//���ķ���������
			b[0] = temp;//�����һ���ŵ���ǰ����  ע�����ﲻ���� b[0] = b[i]; a b��һ�����е�ʱ��ָ�����ͬһ������ 
			b = Arrays.copyOf(b, i); 
			//���½���
			buildHeap(b);
		}
	}
	
	private void print(int[] a) {
		for (int i : a) {
			System.out.print(i+"\t");
		}
		System.out.println();
	}
	

	private void exchangeElement(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
