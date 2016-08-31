package offer_aimTo.Ch02;

public class Ch02_QuickSortPartionForKstMax {
	/**
	 * ���������partition�����������������ڿ����У��������������㳤��Ϊn�������в��ҵ�k�������
	 * 
	 * ���鳤��Ϊlen����k��
	 * eg:Len = 10,��һ��Ӧ���أ�a[9]
	 * ���ص��ǣ�len-k
	 * ���ҵ�indexΪlen-k����
	 * 
	 * @param args
	 * @author Administrator
	 */
	public static void main(String[] args) {
		int[] a = {12,243,53,6,89,1234,4,10,324};
		
		for (int k = 1; k <= a.length; k++) {

			int res;
			Ch02_QuickSortPartionForKstMax kThMax = new Ch02_QuickSortPartionForKstMax();

			//�ر���Ҫע����ǣ�ʹ�ÿ����㷨��ǰ����0����߽���len-1
			res = kThMax.findTheKthMax(a,0,a.length-1,a.length-k);
			
			System.out.println("��" + k +"������ǣ�" + res);
	
		}

	}

	/**
	 * ע�⣺����һ�δ�����������len-k��ʱ��ÿ�ξ���index==k,�ͺ���
	 * @param a
	 * @param left
	 * @param right
	 * @param k
	 * @return
	 */
	private int findTheKthMax(int[] a, int left, int right, int k) {
		int p = 0;
		if (left < right) {
			p = partition(a,left,right);
			if (p == k) {
				return a[p];
			} else if (p > k) {
				findTheKthMax(a, left, p-1, k);
			}else {
				findTheKthMax(a, p+1, right, k);
			}
		}
		
		return a[k];
	}
	
	//���ŵ�partition()����������ȫ��ͬ
	private int partition(int[] a, int left, int right) {
		int temp = a[left];
		while (left < right) {
			while (left < right && a[right] >= temp)
				right--;
			if (left < right) 
				a[left++] = a[right];
			while (left < right && a[left] <= temp)
				left++;
			if (left < right) 
				a[right--] = a[left];
		}
		a[left] = temp;
		return left;
	}

}
