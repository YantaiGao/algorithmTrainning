package Ds.heapSort;

import java.util.Arrays;

public class HeapSortTest {

	public static void main(String[] args) {
		
		int[] a = {11,23,13,47,15,187,-1,36,97,25};
		 
		HeapSortTest hs = new HeapSortTest();
		//print
		System.out.println("Before:");
		hs.print(a);
		//建堆
		hs.buildHeap(a);
		//排序
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
			//如果左右节点都存在，找到左右节点最大的与当前节点比较，否则直接比较左节点与当前节点
			if ( right <= a.length -1) {
				if (a[left] > a[right]) {
					if (a[left] > a[index]) {
						exchangeElement(a,index,left);
						//调整左子树
						adjustHeap(a, left);
					}
				}else {
					if (a[right] > a[index]) {
						exchangeElement(a,index,right);
						//调整右子树
						adjustHeap(a, right);
					}
				}
			}else {
				if (left <= a.length-1 && a[left] > a[index]) {
					exchangeElement(a,index,left);
					//调整左子树
					adjustHeap(a, left);
				}
			}
			
	}

	private void sort(int[] a) {
		int[] b = a;
		for (int i = b.length-1; i >= 0; i--) {
			int temp = b[i];//保存下来最后一个
			a[i] = b[0];//最大的放入有序区
			b[0] = temp;//将最后一个放到最前边来  注意这里不能用 b[0] = b[i]; a b第一次运行的时候指向的是同一个数组 
			b = Arrays.copyOf(b, i); 
			//重新建堆
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
