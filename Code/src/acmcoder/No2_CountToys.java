package acmcoder;

import java.util.Scanner;

/**
 * ����������
 * Ϊ�˹�������������
 * ����n����ߣ��� 1��n˳�����У�
 * ���������ǣ�1 2...n,Ȼ����һ����n-1����ߣ���Ϊn+1
 * eg��3�����
 * ������		1 2 3 4 5 6 7 8 9 10 ... 
 * ��߱�ţ�	1 2 3 2 1 1 2 3 2 1	 ...
 * ÿ����������7 ����7�ı��������߰���7�������ְֶ�Ҫ����
 * ������n,m,k
 * ��x
 * nΪ���������mΪ���m����ߣ�kΪ���m��������ְֵĵ�k������
 * xΪ������ʱʵ���Ѿ������˼���
 * 
 * @author lenovo
 *
 */
public class No2_CountToys {

	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);
		while (true) {
			int n = sin.nextInt();
			int m = sin.nextInt();
			int k = sin.nextInt();
			if (n==0 && m==0 && k==0) {
				break;
			}
			No2_CountToys toys = new No2_CountToys();
			int res = toys.numInFact(n,m,k);
			System.out.println(res);
		}
	}
	/**
	 * ˼·��
	 * �������m��
	 * ��1��ʼ�����m����ʱʵ����������
	 * �ж�������ǲ�����Ҫ����,
	 * ��Ҫ���ƣ���countTime����+1
	 * ֱ������Ϊk������x
	 * 
	 */
	private static int numInFact(int n, int m, int k) {
		int temp = 0;
		int infactNum = 0;
		while (temp != k) {
			
		}
		return infactNum;
	}
}
