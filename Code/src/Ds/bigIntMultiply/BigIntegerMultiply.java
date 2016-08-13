package Ds.bigIntMultiply;

import java.util.Scanner;


public class BigIntegerMultiply {

	private static final int SIZE = 2; 
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String A = scanner.nextLine();
		
		scanner = new Scanner(System.in);
		String B = scanner.nextLine();
		
		System.out.println(A + "*" + B +" = "+ bigIntMultiply(A,B,Math.max(A.length(), B.length())));
	}

	private static String bigIntMultiply(String a, String b, int len) {
		
		//���յĽ��
		String resultStr = "";
		//format�����֣�ʹ������ͬ
		a = formatNumber(a,len);
		b = formatNumber(b,len);
		//��λ��ֱ�Ӽ���
		if (len <= SIZE) {
			return ""+(Integer.parseInt(a) * Integer.parseInt(b));
		}
		//��a,b�ֱ��Ϊ������
		int len1 = len / 2;
		int len2 = len - len1;
		String A = a.substring(0,len1);
		String B = a.substring(len1);
		String C = b.substring(0,len1);
		String D = b.substring(len1);
		//�˷����򣬷ֿ鴦��
		int lenM = Math.max(len1, len2);
		String AC = bigIntMultiply(A, C, len1);
		String AD = bigIntMultiply(A, D, lenM);
		String BC = bigIntMultiply(B, C, lenM);
		String BD = bigIntMultiply(B, D, len2);
		//����BD���õ���λ�ͽ�λ(��Ҫע�����ʹ��len2���ƽ�λ)
		String[] sBD = dealString(BD,len2);
		//����AD+BC�ĺ�(�����ַ�����λ��)
		String ADBC = addition(AD,BC);
		//����BD�Ľ�λ
		if (!"0".equals(sBD[1])) {
			ADBC = addition(ADBC,sBD[1]);
		}
		//�õ�AD+BC�Ľ�λ(ʹ��lenM���ƽ�λ)
		String[] sADBC = dealString(ADBC,lenM);
		//AC����AD+BC�Ľ�λ
		if (!"0".equals(sADBC[1])) {
			AC = addition(AC,sADBC[1]);
		}
		//���ս��
		resultStr = AC + sADBC[0] + sBD[0];
		return resultStr;
	}
	
	private static String addition(String str1, String str2) {
		//���Ľ��
		String reString = "";
		//�����ַ���λ��Ҫ��ͬ
		int lenM = Math.max(str1.length(), str2.length());
		str1 = formatNumber(str1, lenM);
		str2 = formatNumber(str2, lenM);
		//��λ�ӣ���λ�洢��flag��
		int flag = 0;
		//�����һλ���Ӻ���ǰ����λ���
		for (int i = lenM-1; i >= 0; i--) {
			//subString(begin,end)�Ǵ�begin��ʼ������begin,���ǲ�����end
			//subString(index)�Ǵ�index��end����index
			int  t = flag + Integer.parseInt(str1.substring(i, i+1)) + Integer.parseInt(str2.substring(i, i+1));
			if(t > 9){
				//����1
				flag = 1;
				t =  t - 10;
			}else {
				flag = 0;
			}
			//ƴ���ַ���
			reString = "" + t + reString;
		}
		//���һ��������λ
		if(flag == 1){
			reString = "" + flag + reString;
		}
		return reString;
	}

	//Nλ������ˣ���λ����Nλ���ִ���ʣ�µĸ�λ��λ
	private static String[] dealString(String str1, int len) {
		String[] strings = {str1,"0"};
		if (len < str1.length()) {
			int t = str1.length() - len;
			strings[0] = str1.substring(t);
			strings[1] = str1.substring(0, t);
		}else {
			//Ҫ��֤�����len�ʹ����length��ͬ
			String result = strings[0];
			for (int i = result.length(); i < len; i++) {
				result = "0" + result;
			}
			strings[0] = result;
		}
		return strings;
	}

	private static String formatNumber(String num,int len) {
		while (num.length() < len) {
			num = "0" + num;
		}
		return num;
	}

}
