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
		
		if (a == null || a.length < 2) {
			return a;
		}
		
		//�ӵڶ���Ԫ�����β�����������	ע�⣺i������Ǵ�1��С�ڵ���a.length-1��ע�⣺��-1���Ե��ںţ�,ʹ��<length�Ϳ���
		//for (int i = 1; i <= a.length-1; i++) {
		for (int i = 1; i < a.length; i++) {
			//ÿ�δӺ���ǰ��λ�á���ע�������λ�õĹ��̡���j = i ��ǰһ����j-1��
			for (int j = i; j > 0; j--) {
				if (a[j-1] > a[j]) {
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}else {
					//�����Ѿ�С�ڣ�����Ҫ������ǰ�Ƚ�
					break;
				}
			}
		}
		
		return a;
		
	}

}
