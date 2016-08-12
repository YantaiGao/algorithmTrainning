package offer_aimTo;

public class Ch01_FindTheLastK {

	/**
	 * ������ĵ�����K���ڵ�
	 * ˼·��
	 * ʹ������ָ�룬��һ��ָ������k-1����Ȼ������ָ��һ���ߣ�ֱ�����ߵ�ָ���ߵ�������յ㡣
	 * @author gyt
	 * @param args
	 */
	public static void main(String[] args) {
		int k = 0;
		ListNode first = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		ListNode six = new ListNode(6);
		first.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		
		ListNode res = null;
		res = findLastK(first,k);
		if (res!=null) {
			System.out.println(res.value);	
		}else {
			System.out.println("kԽ�� ���� kΪ0");
		}
	}

	private static ListNode findLastK(ListNode first, int k) {
		
		if (first == null) {
			throw new NullPointerException();
		}else {
			if (k == 0) {
				return null;
			}
		}
		ListNode resNode = null;
		ListNode flag1 = first ,flag2 = flag1;
		
		for (int i = 0; i < k-1; i++) {
			if (flag2.next!=null) {
				flag2 = flag2.next;			
			}else {
				System.out.println("Խ��");
				return null;
			}
	
		}
		while (flag2.next != null) {
			flag1 = flag1.next;
			flag2 = flag2.next;
		}
		resNode = flag1;
		return resNode;
	}
}

class ListNode{
	int value;
	ListNode next;
	public ListNode(int value) {
		this.value = value;	
	}
}