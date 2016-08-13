package Ds.grayCode;
import java.util.Scanner;


public class GrayCode {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String n = scanner.nextLine();
		int N = Integer.parseInt(n);
		long now = System.currentTimeMillis();
		StringBuffer[] gray_code = getGrayCode(N);
		long cost = System.currentTimeMillis()- now;
		
		for (int i = 0; i < gray_code.length; i++) {
			System.out.println(gray_code[i]);
		}
		
		System.out.println("Cost "+cost+ "\t"+ "ms");
	}

	private static StringBuffer[] getGrayCode(int n) {
		int length = (int) Math.pow(2, n);
		StringBuffer[] gray_codes = new StringBuffer[length];
		if (n == 1) {
			gray_codes[0] = new StringBuffer("0");
			gray_codes[1] = new StringBuffer("1");
		}else {
			StringBuffer[] lastGray_codes = getGrayCode(n-1);
			for (int i = 0; i < lastGray_codes.length; i++) {
				
				gray_codes[i] = new StringBuffer(lastGray_codes[i]);
				gray_codes[gray_codes.length - i -1]  = new StringBuffer(lastGray_codes[i]);
				
				gray_codes[i] = gray_codes[i].insert(0, "0");
				gray_codes[gray_codes.length - i -1] = gray_codes[gray_codes.length - i -1].insert(0, "1");
				
			}
		}
		return gray_codes;
	}
}
