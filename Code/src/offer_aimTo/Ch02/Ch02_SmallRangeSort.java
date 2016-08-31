package offer_aimTo.Ch02;

public class Ch02_SmallRangeSort {

	/**
	 * 应用场景：
	 * 对公司员工的年龄进行排序，要求在O(n)时间内完成，可以使用辅助空间O(n)
	 * 
	 * 思路：
	 * 可以使用以空间换时间的方式，以本题为例，age范围为1-100，设置一个辅助数组，其中记录该年龄的次数也就是人数，最后对ages数组赋值即可
	 * 
	 * 注意：
	 * 这个题，使用数组下标表示年龄值，因为年龄是连续的整数，在其他应用场景中对于一般的值，可以使用Map<K,V>K对应值，V对应该值的次数
	 * 需要对有限的值域进行排序，这个排序要在small之前，及List<Map<K,V>>中，Map是按序排好的，将待排的大数组依次Map中V+1记录次数即可
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] ages = new int[1000];
		//随机生成年龄为1到100的整数
		for (int i = 0; i < ages.length; i++) {
			int age = (int)(Math.random()*100+1);
			ages[i] = age;
		}
		Ch02_SmallRangeSort smallSort = new Ch02_SmallRangeSort();
		ages = smallSort.sortSmallRange(ages,ages.length);
		//输出结果
		int j = 0;
		for (int i : ages) {
			System.out.print(i+"\t");
			//50个数换行
			if ((++j) % 50 == 0) {
				System.out.println();
			}
		}
	}

	private int[] sortSmallRange(int[] ages,int length) {
		//定义一个长度为100的数组，年龄为1到100，初始值均为0，表示人数为0
		int[] timeOfAge = new int[100];
		for (int i = 0; i < timeOfAge.length; i++) {
			timeOfAge[i] = 0;
		}
		//依次处理数组中数据
		for (int i = 0; i < length; i++) {
			//实际值
			int index = ages[i];
			//值对应的次数记录+1
			timeOfAge[index-1]++;
		}
		//对原数组进行排序
		int index=0;
		//i+1就是年龄值
		for (int i = 0; i < timeOfAge.length; i++) {
			//取出其中每个年龄对应的次数
			for (int j = 0; j < timeOfAge[i]; j++) {
				ages[index++] = i+1;
			}
		}
		return ages;
	}

}
