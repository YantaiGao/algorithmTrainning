package offer_aimTo;

import java.util.Stack;

public class Ch02_LinkedList {
	/**
	 * 链表相关操作
	 * 1：添加
	 * 2：删除！！！
	 * 3：从尾到头打印链表
	 */
	public static void main(String[] args) {
		Linked_List head = null;
		head = addLinkedList(head,23);
		
		head.addLinkedList(head, 24);
		head.addLinkedList(head, 25);
		head.addLinkedList(head, 26);
		head.addLinkedList(head, 27);
		
		System.out.println("After add:");
		head.printList(head);
		
		head = head.deleteNode(head,25);
		System.out.println("\n" + "After del:");
		head.printList(head);
		
		System.out.println("\n" + "从尾到头打印链表：");
		head.printListFromTail_Stack(head);
		System.out.println("\n" + "递归方法：");
		head.printListFromTail_Digui(head);
	}

	private static Linked_List addLinkedList(Linked_List head, int val) {
		Linked_List newNode = new Linked_List(val);
		if (head == null) {
			head = newNode;
			return head;
		}else {
			Linked_List temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			return head;
		}
	}

}

class Linked_List{
	int val;
	Linked_List next;
	public Linked_List(int val) {
		this.val = val;
	}

	public void printList(Linked_List head) {
		if (head == null) {
			System.out.println("NULL");
		}else {
			while (head != null) {
				System.out.print(head.val + "\t");
				head = head.next;
			}
		}
	}
	/**
	 * 1：从头到尾访问，入栈，全部压栈之后，再出栈
	 * 2：递归本质上就是栈，可以使用递归的方式访问
	 * 
	 * @param head
	 */
	public void printListFromTail_Stack(Linked_List head) {
		Stack<Linked_List> stack = new Stack<Linked_List>();
		while (head != null) {
			stack.push(head);
			head = head.next;
		}
		while(!stack.isEmpty()){
			Linked_List temp;
			//注意：出栈用pop();
			//peek()方法用来访问第一个节点，而且不删除
			//temp = stack.peek();
			temp = stack.pop();
			System.out.print(temp.val + "\t");
		}
	}
	
	/**
	 * 注意递归的写法
	 * 思路：每访问一个节点，先递归输出它的下一个节点，再输出节点本身
	 * @param head
	 */
	public void printListFromTail_Digui(Linked_List head) {
		if (head != null) {
			if (head.next != null) {
				printListFromTail_Digui(head.next);
			}
		}
		System.out.print(head.val + "\t");
	}

	public Linked_List addLinkedList(Linked_List head, int val) {
		Linked_List newNode = new Linked_List(val);
		if (head == null) {
			head = newNode;
			return head;
		}else {
			Linked_List temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			return head;
		}
	}
	/**
	 * 删除方法要注意：
	 * 1：头结点为空
	 * 2：头结点就是要找的节点
	 * 3：普通节点的删除
	 * @param head
	 * @param val
	 * @return
	 */
	public Linked_List deleteNode(Linked_List head, int val) {
		//头结点为空，直接返回
		if (head == null) {
			return null;
		}

		if (head.val == val) {
			//不管head的next是否为null，head = next
			head = head.next;
		}else {
			//需要注意这一部分！！！
			Linked_List temp = head;
			while (temp.next != null && temp.next.val != val) {
				temp = temp.next;
			}
			if (temp.next != null && temp.next.val == val) {
				temp.next = temp.next.next;
			}
		}
		return head;
	}


}
