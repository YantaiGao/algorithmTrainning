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
		
		//最终的结果
		String resultStr = "";
		//format俩数字，使长度相同
		a = formatNumber(a,len);
		b = formatNumber(b,len);
		//两位数直接计算
		if (len <= SIZE) {
			return ""+(Integer.parseInt(a) * Integer.parseInt(b));
		}
		//将a,b分别分为两部分
		int len1 = len / 2;
		int len2 = len - len1;
		String A = a.substring(0,len1);
		String B = a.substring(len1);
		String C = b.substring(0,len1);
		String D = b.substring(len1);
		//乘法法则，分块处理
		int lenM = Math.max(len1, len2);
		String AC = bigIntMultiply(A, C, len1);
		String AD = bigIntMultiply(A, D, lenM);
		String BC = bigIntMultiply(B, C, lenM);
		String BD = bigIntMultiply(B, D, len2);
		//处理BD，得到低位和进位(需要注意的是使用len2控制进位)
		String[] sBD = dealString(BD,len2);
		//处理AD+BC的和(两个字符串按位加)
		String ADBC = addition(AD,BC);
		//加上BD的进位
		if (!"0".equals(sBD[1])) {
			ADBC = addition(ADBC,sBD[1]);
		}
		//得到AD+BC的进位(使用lenM控制进位)
		String[] sADBC = dealString(ADBC,lenM);
		//AC加上AD+BC的进位
		if (!"0".equals(sADBC[1])) {
			AC = addition(AC,sADBC[1]);
		}
		//最终结果
		resultStr = AC + sADBC[0] + sBD[0];
		return resultStr;
	}
	
	private static String addition(String str1, String str2) {
		//最后的结果
		String reString = "";
		//两个字符串位数要相同
		int lenM = Math.max(str1.length(), str2.length());
		str1 = formatNumber(str1, lenM);
		str2 = formatNumber(str2, lenM);
		//按位加，进位存储在flag中
		int flag = 0;
		//从最后一位，从后向前，逐位相加
		for (int i = lenM-1; i >= 0; i--) {
			//subString(begin,end)是从begin开始，包括begin,但是不包括end
			//subString(index)是从index到end包括index
			int  t = flag + Integer.parseInt(str1.substring(i, i+1)) + Integer.parseInt(str2.substring(i, i+1));
			if(t > 9){
				//最多进1
				flag = 1;
				t =  t - 10;
			}else {
				flag = 0;
			}
			//拼接字符串
			reString = "" + t + reString;
		}
		//最后一个产生进位
		if(flag == 1){
			reString = "" + flag + reString;
		}
		return reString;
	}

	//N位整数相乘，低位保留N位数字串，剩下的高位进位
	private static String[] dealString(String str1, int len) {
		String[] strings = {str1,"0"};
		if (len < str1.length()) {
			int t = str1.length() - len;
			strings[0] = str1.substring(t);
			strings[1] = str1.substring(0, t);
		}else {
			//要保证结果的len和传入的length相同
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
