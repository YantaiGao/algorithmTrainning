package Ds.reverseList;
/**
 * 逆转单链表：
 * 思路：
 * 将 head 的 next 置为空，然后将以后的每个元素挨个放到 head 的前面
 * 
 * @author Administrator
 *
 */
public class ReverseList {

	public static void main(String[] args) {
		
		Node head = new Node(0);
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		
		head.nextNode = n1;
		n1.nextNode = n2;
		n2.nextNode = n3;
		n3.nextNode = n4;
		n4.nextNode = n5;
		
		System.out.println("逆转前：");
		
		print(head);
		
		head = reverseList(head);
	
		System.out.println();
		System.out.println("逆转后：");
		
		
		print(head);
		
	}
	
	private static void print(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.val+"\t");
			temp = temp.nextNode;
		}
	}

	/**
	 * Java单链表的逆转：
	 * 
	 * p指针指向 head，q指向head.next
	 * 将p的next置空，
	 * 然后依次将p插入到p的前边去
	 * 
	 * @param head
	 */
	
	private static Node reverseList(Node head) {
		
		Node p = head;
		Node q = head.nextNode;
		
		//注意：这一个一定要有，用来割开头结点和后边的节点，否则会出现环
		p.nextNode = null;
		
		while (q != null) {
			//将q的next缓存起来，然后next指向p,就完成了逆转
			Node temp = q.nextNode;
			q.nextNode = p;
			//为了下一步逆转和返回正确的逆转后的指针p需要指向新的头节点
			p = q;
			q = temp;
		}
		
		return p;
	}

}

class Node{

	int val;
	Node nextNode;

	public Node(int val){
		this.val = val;
	}
	
}
