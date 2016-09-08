package Ds.reverseList;
/**
 * ��ת������
 * ˼·��
 * �� head �� next ��Ϊ�գ�Ȼ���Ժ��ÿ��Ԫ�ذ����ŵ� head ��ǰ��
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
		
		System.out.println("��תǰ��");
		
		print(head);
		
		head = reverseList(head);
	
		System.out.println();
		System.out.println("��ת��");
		
		
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
	 * Java���������ת��
	 * 
	 * pָ��ָ�� head��qָ��head.next
	 * ��p��next�ÿգ�
	 * Ȼ�����ν�p���뵽p��ǰ��ȥ
	 * 
	 * @param head
	 */
	
	private static Node reverseList(Node head) {
		
		Node p = head;
		Node q = head.nextNode;
		
		//ע�⣺��һ��һ��Ҫ�У������ͷ���ͺ�ߵĽڵ㣬�������ֻ�
		p.nextNode = null;
		
		while (q != null) {
			//��q��next����������Ȼ��nextָ��p,���������ת
			Node temp = q.nextNode;
			q.nextNode = p;
			//Ϊ����һ����ת�ͷ�����ȷ����ת���ָ��p��Ҫָ���µ�ͷ�ڵ�
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
