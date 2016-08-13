package Ds.grayCode;
import java.util.Scanner;

public class GrayCodeString {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String n = scanner.nextLine();
		int N = Integer.parseInt(n);
		long now = System.currentTimeMillis();
		String[] gray_code = getGrayCode(N);
		long cost = System.currentTimeMillis()- now;
		
		for (int i = 0; i < gray_code.length; i++) {
			System.out.println(gray_code[i]);
		}
		
		System.out.println("Cost "+cost+ "\t"+ "ms");
	}
	/**
	 * 这个比用StringBuffer快
	 * @param n
	 * @return
	 */
	private static String[] getGrayCode(int n) {
		int length = (int) Math.pow(2, n);
		String[] gray_codes = new String[length];
		if (n == 1) {
			gray_codes[0] = "0";
			gray_codes[1] = "1";
		}else {
			String[] lastGray_codes = getGrayCode(n-1);
			for (int i = 0; i < lastGray_codes.length; i++) {
				
				gray_codes[i] = "0"+lastGray_codes[i];
				gray_codes[gray_codes.length - i -1] = "1"+lastGray_codes[i];
				
			}
		}
		return gray_codes;
	}
}
