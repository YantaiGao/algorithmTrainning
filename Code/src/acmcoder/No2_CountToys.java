package acmcoder;

import java.util.Scanner;

/**
 * ����������
 * Ϊ�˹�������������
 * ����n����ߣ��� 1��n˳�����У�
 * ���������ǣ�1 2...n,Ȼ����һ����n-1����ߣ���Ϊn+1
 * eg��3�����
 * ������		1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 ... 
 * ��߱�ţ�	1 2 3 2 1 2 3 2 1 2  3  2  1  2  3  2  1  2  3  2  1...
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
	 * ��1��ʼ����m����ʱʵ����������
	 * �ж�������ǲ�����Ҫ����,
	 * ��Ҫ���ƣ���countTime����+1
	 * ֱ������Ϊk������x
	 * 
	 * (1)������Ҫȷ��һ���ֻصĳ��� L = 2*n - 2
	 * (2)���m�ڵ�һ�ֻ��еı��-��ʵ�ʵ���
	 * 	����mΪ1����n������һ����ţ�
	 * 	�������������
	 * (3)���������һ���е�ʵ�ʵ�����һ����������
	 * (4)���ж��Ƿ����,ֱ��k��
	 * 
	 * ����Ϊ1��Ҫ��������
	 * 
	 */
	private int numInFact(int n, int m, int k) {
		//����Υ��
		if (m > n) {
			return -1;
		}
		//���ƴ���
		int temp = 0;
		//ʵ�ʵ���
		int infactNum = 0;
		//�ڶ����±ֻ꣬��m����1��n��ʱ����õ�
		int indexTwo = 0;
		//һ��round�ĳ���
		int roundLen = 0;
		//һ�����
		if (n==1 && m==1) {
			infactNum = 0;
			roundLen = 1;
		}else {
			//����n=1֮�⣬һ���ֻس���
			roundLen = 2*n-2;
			//��β��1������n��һ���ֻ���ֻ����һ�Σ��״���ž���m
			if (m == 1 || m == n) {
				//roundOne�ֻ���ֻ��һ�����֣�infactNum = m
				//roundOne�������m
				infactNum = m;
			}else {
				infactNum = m;
				indexTwo = n + (n-m);
			}
		}
		
		while (temp != k) {
			//����1��Ҫ��������
			if(n == 1 && m == 1){
				//��������
				if (infactNum % 7 == 0 || new Integer(infactNum).toString().indexOf("7") >= 0) {
					temp++;
				}
				infactNum = infactNum + roundLen;
			}else if (m == 1 || m == n) {
				//roundOne�ֻ���ֻ��һ�����֣�infactNum = m
				//��������
				if (infactNum % 7 == 0 || new Integer(infactNum).toString().indexOf("7") >= 0) {
					temp++;
				}
				infactNum = infactNum + roundLen;
			}else {
				//һ�������һ��roundOne�г������Σ����ζ�Ҫ�ж�
				//��������
				if (infactNum % 7 == 0 || new Integer(infactNum).toString().indexOf("7") >= 0) {
					temp++;
				}
				infactNum = infactNum + roundLen;
				if (indexTwo % 7 == 0 || new Integer(indexTwo).toString().indexOf("7") >= 0) {
					temp++;
				}
				indexTwo = indexTwo + roundLen;
			}
		}
		return infactNum;
	}
}
