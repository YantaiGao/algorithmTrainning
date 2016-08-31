package offer_aimTo.Ch02;

/**
 * ����������
 * 
 * ��ת���飺
 * ��һ�����������ʼ������Ԫ�طŵ������ĩβ����Ϊ�������ת��
 * Eg��3,4,5,1,2 ��1,2,3,4,5��һ����ת
 * ����һ�� ��ת���飬���������Сֵ��
 * 
 * ˼·��
 * �������飬����С��Ԫ�أ����Ӷ�ΪO(n)
 * ����ʹ�ö��ֲ��ң����͸��Ӷ�O(lgn)
 * 
 * ���ⰸ����
 * 0,1,2,3,4,5
 * 1,1,1,1,1,1
 * @author lenovo
 *
 */
public class Ch02_XZArraySmallest {

	public static void main(String[] args) {

		int[] arr = {3,4,5,1,2};
//		int[] arr = {1,1,1,1,1};
//		int[] arr = {0,1,2,3,4};//���bug��û���
		Ch02_XZArraySmallest xuanzhuanArr = new Ch02_XZArraySmallest();
		int small = xuanzhuanArr.smallest(arr);
		System.out.println("��С��Ԫ���ǣ�" + small);
	}

	private int smallest(int[] arr) {
		
		int low = 0;
		int high = arr.length-1;
		int res = -1;
		
		while (arr[low] >= arr[high]) {
		
			//�ҵ��ˣ���ֹ����
			if ((high-low) == 1) {
				res = arr[high];
				break;
			}
			
			int mid = (low+high)/2;
			
			//���������low=high=mid��ʱ��ֻ��˳�����
			if (arr[low] == arr[high] && arr[low] == arr[mid]) {
				res =  INMID(arr);
			}
			
			if (arr[mid] >= arr[low]) {
				//ע����ʱ������+1���±ߵ�Ҳ�����ټ�һ����Ϊ���ܻ�Խ����С��Ԫ��
				low = mid;
			}else if (arr[mid] <= arr[high]) {
				high = mid;
			}
			
		}
		return res;
	}

	private int INMID(int[] arr) {
		int min = arr[0];
		for (int i : arr) {
			if (i<min) 
				min = i;
		}
		return min;
	}

}
