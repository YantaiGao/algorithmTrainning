package Ds.sort;

/**
 * @author Administrator
 * 
 * ��������
 * 	˼�룺
 * 	�����������ݷֳ������֣�һ����������ģ����ϵĽ���һ���ֲ��뵽��������ĺ��ʵ�λ��
 *  ÿһ����һ������������ݣ�������ؼ��ֵĲ��뵽�����򲿷��ʵ�λ����
 * 	
 * 	�㷨˼·�������С������
 * 	���һ��Ԫ��������ģ�ÿ�ν���Ԫ�شӺ���ǰ��λ�ã�С���򽻻����ҵ�����λ�ò���
 * 		
 *
 */

public class No_1ChaRuSort {

	public static void main(String[] args) {
		int[] a = {3,23,6,45,2,89,100,4,66};
		No_1ChaRuSort sort = new No_1ChaRuSort();
		
		a = sort.charuSort(a);
		
		for (int i : a) {
			System.out.print(i + "\t");
		}
	}

	private int[] charuSort(int[] a) {
		
		//�ӵڶ���Ԫ�����β�����������
		for (int i = 1; i < a.length-1; i++) {
			//ÿ�δӺ���ǰ��λ��
			for (int j = i; j < 0; j--) {
				if (a[i] < a[j]) {
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
		}
		return a;
	}

}
