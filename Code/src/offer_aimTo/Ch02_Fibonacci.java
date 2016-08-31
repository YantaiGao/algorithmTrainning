package offer_aimTo;

/**
 * ��쳲��������е�n��,���ߴ�ӡǰn��
 * �����Ŀ
 * (1) ������̨��
 * (2) ���η��鸲�����⣺
 * 	��һ����Ϊ1����Ϊ2����1*1���򹹳ɵľ����Դ�Ϊͼ��������һ��2*8�ľ���
 *  ����һ�θ��ǣ�������Ϊf(8)=f(7)+f(6)
 *  ������θ���.doc
 * ��ʽ��
 * f(0)=0;
 * f(1)=1;
 * f(n)=f(n-1)+f(n-2)
 * 
 * ��ͨ˼·���ݹ飬���ϵ���
 * ���ǣ����ֵݹ鷽ʽ���кܶ��ظ�����
 * eg:
 * f(10) = f(9)+f(8)
 * f(9) = f(8)+f(7)
 * f(8) = f(7)+f(6)
 * 
 * �Ż�˼·��
 * �����ظ����㣬���µ��ϼ���
 * 
 * @author lenovo
 *
 */
public class Ch02_Fibonacci {

	public static void main(String[] args) {
		int n = 50;
		int res;
		Ch02_Fibonacci fibo = new Ch02_Fibonacci();
//		for (int i = 0; i <= n; i++) {
//			res = fibo.findN(i);
//			System.out.print(res+"\t");	
//			if (i%10 == 0 && i!=0) {
//				System.out.println();
//			}
//		}
		
		long res2 = 0;
		for (int i = 0; i <= n; i++) {
			res2 = fibo.findNFromDown(i);
			System.out.print(res2 + "\t");
			if (i%10 == 0 && i!=0) {
				System.out.println();
			}
		}
	}

	/**
	 * ��ͳ�ĵݹ飬���ϵ��µݹ�
	 * ����⣬���ǵ�Ч���ظ������
	 * @param n
	 * @return
	 */
	private int findN(int n) {
		if (n==0) {
			return 0;
		}else if(n==1){
			return 1;
		}else {
			return findN(n-1)+findN(n-2);
		}
	}

	/**
	 * �Ż�1��
	 * ������ϵ��µ��ظ����㣬���µ��ϼ���
	 * ʱ�临�Ӷ�o(n)
	 * @param n
	 * @return
	 */
	private long findNFromDown(int n) {
		if (n==0) {
			return 0;
		}else if(n==1){
			return 1;
		}else {
			
			long fibo1 = 1;
			long fibo2 = 0;
			
			long fiboN = 0;
			
			for (int i = 0; i < n; i++) {
				fiboN = fibo1 + fibo2;
				fibo2 = fibo1;
				fibo1 = fiboN;
			}
			
			return fiboN;
		}
		
	}
}
