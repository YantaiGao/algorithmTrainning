package offer_aimTo.Ch01;

public class Ch01_StringToNum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str = "1230";
		//str = "--21";//这个就会崩溃
		int res = strToNum(str);
		System.out.println("Res == " + "\t" + res);
		
	}

	private static int strToNum(String str) {
		
		int res = 0;
		
		boolean negative = false;
		
		int  i=0 ,len = str.trim().length();
		
		int digit;
		
		if (len > 0) {
			
			if (str.charAt(0) == '-') {
				negative = true;
				i++;
			}
			
			while (i<len) {
				digit = Character.digit(str.charAt(i++), 10);
				res = res * 10;
				res += digit;
			}
			
			if (!negative) {
				return res;
			}else {
				return -res;
			}
			
			
		}else {
			System.out.println("空指针");
			throw new NullPointerException();
		}
	}
}
