package LeetCode;

/**
 * 
 * @author gyt
 *	
 *	You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *	Output: 7 -> 0 -> 8
 *
 *	class ListNode was Given
 *
 *	Pay attention to test case lisk follows:
 *	[1][9,9];[2,3,4][6,7]
 *	
 */

class ListNode {
	int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Num2AddTwoNumbers {
	
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	
    	ListNode resListNode = new ListNode(0);
        ListNode temp1 = l1,temp2 = l2,temp3 = resListNode; //pay action to define of temp3 
        int carry = 0;
        while(temp1 != null  || temp2 != null || carry != 0){ //while carry == 1 can't finsh loop although both temp1 && temp2 are null
            int x = (temp1 != null)? temp1.val:0;
            int y = (temp2 != null)? temp2.val:0;
            temp3.next = new ListNode( (x + y + carry) % 10);//pay acction to here
            if(x + y + carry >= 10){
                carry = 1;
            }else{
                carry = 0;
            }
            if(temp1 != null){	//in case NullPointerException
            	temp1 = temp1.next;
            }
            if(temp2 != null){
            	temp2 = temp2.next;
            }
            temp3 = temp3.next;
        }
        
        return resListNode.next;
    }
	
	public static void main(String[] args) {
		
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
//		(l1.next).next = new ListNode(3);
		
		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
		(l2.next).next = new ListNode(4);
		
		ListNode res = addTwoNumbers(l1, l2);
		
		while (res != null) {
			
			System.out.println(res.val);
			res = res.next;
		}
	}

}

