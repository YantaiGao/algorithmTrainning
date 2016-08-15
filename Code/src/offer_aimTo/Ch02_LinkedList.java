package offer_aimTo;

import java.util.Stack;

public class Ch02_LinkedList {
	/**
	 * ������ز���
	 * 1�����
	 * 2��ɾ��������
	 * 3����β��ͷ��ӡ����
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
		
		System.out.println("\n" + "��β��ͷ��ӡ����");
		head.printListFromTail_Stack(head);
		System.out.println("\n" + "�ݹ鷽����");
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
	 * 1����ͷ��β���ʣ���ջ��ȫ��ѹջ֮���ٳ�ջ
	 * 2���ݹ鱾���Ͼ���ջ������ʹ�õݹ�ķ�ʽ����
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
			//ע�⣺��ջ��pop();
			//peek()�����������ʵ�һ���ڵ㣬���Ҳ�ɾ��
			//temp = stack.peek();
			temp = stack.pop();
			System.out.print(temp.val + "\t");
		}
	}
	
	/**
	 * ע��ݹ��д��
	 * ˼·��ÿ����һ���ڵ㣬�ȵݹ����������һ���ڵ㣬������ڵ㱾��
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
	 * ɾ������Ҫע�⣺
	 * 1��ͷ���Ϊ��
	 * 2��ͷ������Ҫ�ҵĽڵ�
	 * 3����ͨ�ڵ��ɾ��
	 * @param head
	 * @param val
	 * @return
	 */
	public Linked_List deleteNode(Linked_List head, int val) {
		//ͷ���Ϊ�գ�ֱ�ӷ���
		if (head == null) {
			return null;
		}

		if (head.val == val) {
			//����head��next�Ƿ�Ϊnull��head = next
			head = head.next;
		}else {
			//��Ҫע����һ���֣�����
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
