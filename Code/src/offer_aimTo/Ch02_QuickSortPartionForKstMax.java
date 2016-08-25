package offer_aimTo;

public class Ch02_QuickSortPartionForKstMax {
	/**
	 * ���������partition�����������������ڿ����У��������������㳤��Ϊn�������в��ҵ�k�������
	 * @param args
	 * @author Administrator
	 */
	public static void main(String[] args) {
		int[] a = {12,243,53,6,89,1234,4,10,234};
		int k = 5;
		int res;
		Ch02_QuickSortPartionForKstMax kThMax = new Ch02_QuickSortPartionForKstMax();
		//�����ҵ��ǵ�kС������Ӧ��ʹ��k-1
		res = kThMax.findTheKthMax(a,0,a.length-1,k);
		System.out.println("��" + k +"������ǣ�" + res);
	}

	private int findTheKthMax(int[] a, int left, int right, int k) {
		int p = 0;
		if (p != k) {
			p = partition(a,left,right);
			if (p < k) {
				findTheKthMax(a, p+1, right, k-p);
			}else {
				findTheKthMax(a, left, p-1, k);
			}
		}
		
		return a[k];
	}
	
	//���ŵ�partition()����
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
