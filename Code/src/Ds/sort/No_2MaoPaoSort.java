package Ds.sort;

/**
 * @author Administrator
 * 
 *  ð�����򣺣��谴��С������
 *  ÿ�֣���ͷ��ʼ���αȽ����ڵ�Ԫ�أ������һ���ȵڶ����󣬾ͽ���
 *  ������һ��֮�����ߵ�������Ԫ�أ���һ�ֵ�ʱ���Ǵ�ͷ��β���������Ƚϣ�ֻ�ǲ��ٵ�β��ȥ����һ��ȷ��������Ԫ��
 *  
 *  ֻ�д��ڻ���С�ڽ��������ȶ����㷨
 *  
 *  ʱ�临�Ӷȣ�
 *  ��������ǣ�
 *  ��һ�ֽ���n-1�����һ�ֽ���1��
 *  1+2+3+...+ n-1
 *  (1+n-1)*n/2 
 *  ʱ�临�Ӷ���n^2
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
		
		//�ⲿѭ������:�����Ƶ��ǳ��ȣ�
		//n-1�֣���һ����a.length����Ӧ���Ǵ�ͷ��βȫ���ĳ��ȣ�
		//�Ժ�ÿ�ֳ��ȼ�һ���Ժ�ÿ�ζ���һ������Ϊÿ�������ȷ��һ����󣨻�����С����
		
		//����ע����ǣ�����i�����a.length - 1��ʼ��������Ϊ�ں���� j + 1
		for (int i = a.length - 1; i > 0; i--) {
			//����ÿ��ѭ������ͷ��β�����Ƚϣ�����ǰ�ߵıȺ�ߵĴ󣨻���С���򽻻�
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
