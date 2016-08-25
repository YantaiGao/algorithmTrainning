package Ds.sort;
/**
 * @author Administrator
 * ���ţ�
 *  �ⲿ��һ���ݹ鷽����
 *  ���ȣ��ҵ�����λ��p��ʹ������ߵ����ݶ�С��a[p],�ұߵ����ݶ�����a[p]
 *  Ȼ�����������߲��ֵݹ���ÿ����㷨
 *  
 *  ÿ�����ҵ�a[p]�����յ�λ�á�
 *  
 *  ���ԱȽ���Ҫ�ľ���partition������ ����±ߵĴ����еķ�����
 *  
 *  ���ȶ��㷨
 *  
 *  ʱ�临�Ӷȣ�
 *  һ����Ҫn�֣����ÿ�ֶ���Ҫ�����������Ƿְ�ģ���������ǣ�nlogn
 *  
 */
public class No_3QuickSort {

	public static void main(String[] args) {
		int[] a = {49,38,65,97,76,13,27,49};
		int left = 0;
		
		//ע�⣺right��len-1
		int right = a.length-1;
		
		quickSort(a,left,right);
		for (int i : a) {
			System.out.print(i + "\t");
		}
		
	}

	private static void quickSort(int[] a, int left, int right) {
		
		int p;
		/**
		 * ע�⣺����ж���������Ҫ�У�����
		 */
		if (left < right) {
			p = partition(a,left,right);
//			p = partition_new(a,left,right);
			quickSort(a,left,p-1);
			quickSort(a,p+1,right);
		}
		
	}
	
	/**
	 * ԭʼ��:
	 * @param a
	 * @param left
	 * @param right
	 * @return
	 * 49,38,65,97,76,13,27,49
	 * ��һ�����飺
	 * 49,38,65,97,76,13,27,49��left=0 right=7 p=a[0]=49��
	 * �Ӻ���ǰ�� < P�ģ��ҵ��󽻻�
	 * 27,38,65,97,76,13,49,49����ʱ��27 < p������27 49��right = 6,left++��= 1��
	 * ��ǰ����� > p�ģ��ҵ��󽻻�
	 * 27,38,49,97,76,13,65,49����ʱ�� 65 > p������ 49 65 left = 2,right--��= 5 ��
	 * һֱ����������ȥ��ֱ��left = right
	 * ��һ�ֽ�����ǣ�
	 * 27,38,13,49,76,97,65,49
	 * 
	 */
	private static int partition(int[] a, int left, int right) {
		
		int p = a[left];
		
		while(left < right){
			//�Ӻ���ǰ�����һֱ���ڵ���p��rightλ��ָ���ǰ��
			while (left < right && a[right] >= p) 
				right--;
			if (left < right) {
				//����a[right]��a[left]��left++
				int temp = a[right];
				a[right] = a[left];
				a[left] = temp;
				left++;
			}
			//��ǰ������һֱС�ڵ���p��leftλ��ָ��ͺ���
			while (left < right && a[left] <= p) 
				left++;
			if (left < right) {
				//����a[left]��a[right]��right--
				int temp = a[right];
				a[right] = a[left];
				a[left] = temp;
				right--;
			}
		}
		
		//����left==right,����ȷ�������λ��
		return left;
	}

	/**
	 * �Ż��棺
	 * ÿ�ν�����ʱ�򣬲�����������Ϊp��ʼֵ�Ѿ��������������������л���һ��λ�ã�������������
	 * @param a
	 * @param left
	 * @param right
	 * @return
	 * 
	 * 49,38,65,97,76,13,27,49
	 * ��һ�����飺
	 * 49,38,65,97,76,13,27,49��left=0 right=7 p=a[0]=49��
	 * �Ӻ���ǰ�� < P�ģ��ҵ���ֵ��ȥ��ԭ��λ���ϵ������ǲ��䣬�ȴ��´θ��Ǿ���
	 * 27,38,65,97,76,13,27,49����ʱ��27 < p��27����49(��Ϊ49�Ѿ�������Ϊp)��right = 6,left++��= 1��
	 * ��ǰ����� > p�ģ��ҵ��󽻻�
	 * 27,38,65,97,76,13,65,49����ʱ�� 65 > p,65ֱ�Ӹ���a[right](��Ϊ27�Ѿ���Ū��ǰ��ȥ��); left = 2,right--��= 5 ��
	 * �Ӻ���ǰ 
	 * 27,38,13,97,76,13,65,49(13����65)
	 * ��ǰ���
	 * 27,38,13,97,76,97,65,49(97����13)
	 * �Ӻ���ǰ��ֱ��right = 3�� = left
	 * 27,38,13,97,76,97,65,49
	 * 
	 * 
	 * һֱ����������ȥ��ֱ��left = right
	 * ��ʱ����Ϊ��
	 * 27,38,13,97,76,97,65,49
	 * 
	 * ��ʱӦ�ð�49�ŵ� 3��λ����ȥ��
	 * 
	 * ��һ�ֽ�����ǣ�
	 * 27,38,13,49,76,97,65,49
	 * 
	 */
	private static int partition_new(int[] a, int left, int right) {
		int p = a[left];
		while (left < right) {
			while (left < right && a[right] >= p) 
				right--;
			if (left < right) {
				a[left++] = a[right];
			}
			while (left < right && a[left] <= p) 
				left++;
			if (left < right) {
				a[right--] = a[left];
			}
		}
		//��ʱ��һ��Ҫ��p�ŵ��ҵ���λ����ȥ
		a[left] = p;
		//���ػ��ֵ�λ��
		return left;
	}
}
