package offer_aimTo.Ch02;

public class Ch02_SmallRangeSort {

	/**
	 * Ӧ�ó�����
	 * �Թ�˾Ա���������������Ҫ����O(n)ʱ������ɣ�����ʹ�ø����ռ�O(n)
	 * 
	 * ˼·��
	 * ����ʹ���Կռ任ʱ��ķ�ʽ���Ա���Ϊ����age��ΧΪ1-100������һ���������飬���м�¼������Ĵ���Ҳ��������������ages���鸳ֵ����
	 * 
	 * ע�⣺
	 * ����⣬ʹ�������±��ʾ����ֵ����Ϊ������������������������Ӧ�ó����ж���һ���ֵ������ʹ��Map<K,V>K��Ӧֵ��V��Ӧ��ֵ�Ĵ���
	 * ��Ҫ�����޵�ֵ����������������Ҫ��small֮ǰ����List<Map<K,V>>�У�Map�ǰ����źõģ������ŵĴ���������Map��V+1��¼��������
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] ages = new int[1000];
		//�����������Ϊ1��100������
		for (int i = 0; i < ages.length; i++) {
			int age = (int)(Math.random()*100+1);
			ages[i] = age;
		}
		Ch02_SmallRangeSort smallSort = new Ch02_SmallRangeSort();
		ages = smallSort.sortSmallRange(ages,ages.length);
		//������
		int j = 0;
		for (int i : ages) {
			System.out.print(i+"\t");
			//50��������
			if ((++j) % 50 == 0) {
				System.out.println();
			}
		}
	}

	private int[] sortSmallRange(int[] ages,int length) {
		//����һ������Ϊ100�����飬����Ϊ1��100����ʼֵ��Ϊ0����ʾ����Ϊ0
		int[] timeOfAge = new int[100];
		for (int i = 0; i < timeOfAge.length; i++) {
			timeOfAge[i] = 0;
		}
		//���δ�������������
		for (int i = 0; i < length; i++) {
			//ʵ��ֵ
			int index = ages[i];
			//ֵ��Ӧ�Ĵ�����¼+1
			timeOfAge[index-1]++;
		}
		//��ԭ�����������
		int index=0;
		//i+1��������ֵ
		for (int i = 0; i < timeOfAge.length; i++) {
			//ȡ������ÿ�������Ӧ�Ĵ���
			for (int j = 0; j < timeOfAge[i]; j++) {
				ages[index++] = i+1;
			}
		}
		return ages;
	}

}
