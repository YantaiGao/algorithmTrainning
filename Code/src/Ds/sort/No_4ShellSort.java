package Ds.sort;
/**
 * 
 * @author Administrator
 *	
 * ϣ������
 * ���������һ�֣�
 * �����ż�¼��Ϊһ���������飬��ÿ��ʹ��ֱ�Ӳ��������㷨������������d���𽥼�С��ÿ������Խ��Խ�ֱ࣬��d=1���������ݾ�������ģ��㷨��ֹ��
 * 
 * ��ȡһ��������d1<n��
 * ������������d1������Ԫ�ط�һ�飬���ڽ���ֱ�Ӳ�������
 * Ȼ��ȡd2<d1���ظ�������������������
 * ֱ��di=1�������м�¼�Ž�һ����������Ϊֹ��
 * 
 * d��ȡֱֵ��Ӱ�����㷨��Ч�ʣ�
 * �򵥵�ȡ����
 * d1 = len/2���Ժ�ÿ�ζ��� d/2,ֱ��d==1
 * 
 * 
 * �ȶ��ԣ�
 * ���ȶ��ڷ���󣬾����������򣬿��ܻ�ʹԭ����˳�����ı�
 * 
 * ʱ�临�Ӷȣ�
 *  n^1.3����.
 * 
 */
public class No_4ShellSort {

	public static void main(String[] args) {
		int[] a = {49,38,65,97,76,13,27,49,55,4};
		No_4ShellSort sort = new No_4ShellSort();
		
		a = sort.shellSort(a);
		
		for (int i : a) {
			System.out.print(i + "\t");
		}
	}

	private int[] shellSort(int[] a) {

		//����d����len/2��1
		for (int d=a.length/2; d > 0; d=d/2) {
			
			//���ƶ���ÿһ��d�Ĳ���
			
			//��Ҫ������ÿ��d��0-��d-1����d������ĵ�һ��Ԫ�أ�
			//���ղ�������Ӧ����ÿ����Ԫ�أ���ǰ�����в�������
			//ʵ����: �Ǵӵ�d��Ԫ�ص����һ��Ԫ�ض���Ҫ���в������򣬶��һ���֮��ľ��붼��d
			//��������ڲ�ѭ���Ǵ�d�����һ��Ԫ���ҵ����ʵĲ���λ��
			for (int i = d; i < a.length; i++) {
				//����i��Ԫ��,a[i],�ҵ���ȷ�Ĳ���λ��
				int j = 0;
				int temp = a[i];
				//�Ӻ���ǰȥ������������λ�ã�
				//j>=d����Ϊÿ��ĵ�һ������Ҫ��λ��
				for (j = i; j >= d; j=j-d) {
					//tempС�����ƣ�֮�����ܸ�������Ϊa[i]�Ѿ�������
					//�ر�ע�⣺������Ҫʹ��temp���бȽ�
					if (temp < a[j-d]) {
						a[j] = a[j-d];
					}else {
						//ǰ��������ģ��ٱȽ�û�����壬�Ѿ��ҵ�λ��
						break;
					}
				}
				a[j] = temp;
			}
			
		}
		
		return a;
	}
}