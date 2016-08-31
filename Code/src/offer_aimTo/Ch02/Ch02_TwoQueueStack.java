package offer_aimTo.Ch02;

import java.util.LinkedList;

public class Ch02_TwoQueueStack {

	/**
	 * ��������ʵ��һ��ջ
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		
		myStack.myPush(1);
		myStack.myPush(2);
		myStack.myPush(3);
		System.out.println("123��ջ��");
		myStack.transMyStack();
		myStack.myPop(3);
		System.out.println("3��ջ��");
		myStack.transMyStack();
		myStack.myPush(4);
		myStack.myPush(5);
		System.out.println("45��ջ��");
		myStack.transMyStack();
	}

}

class MyStack{
	
	LinkedList<Integer> queue1 = new LinkedList<>();
	LinkedList<Integer> queue2 = new LinkedList<>();
	
	/**
	 *��ջ:
	 *���q1 = q2 = null����ջ���ܳ�ջ
	 *���q1!=null,q1��Ԫ�س��ӵ�q2,ֱ��ʣ�����һ��Ԫ�أ����Ӽ���ջ
	 *���q1 == null,q2��Ϊ�գ���q2����Ԫ�س��ӵ���1��ֱ�����һ��Ԫ�أ����Ӽ���ջ
	 */
	public void myPop(int val) {

		if (queue1.isEmpty() && queue2.isEmpty()) {
			System.out.println("��ջ���޷���ջ");
		}
		
		if (!queue1.isEmpty()) {
			
			while (queue1.size() > 1) {
				Integer temp = queue1.poll();
				queue2.add(temp);
			}
			//��ջ
			System.out.println("��ջ��" + queue1.poll());
			
		}else {
		
			while (queue2.size() > 1) {
				Integer temp = queue2.poll();
				queue1.add(temp);
			}
			//��ջ
			System.out.println("��ջ��" + queue2.poll());
			
		}
		
	}
	/**
	 * ��ջ:
	 * ֱ�����queue1
	 * 
	 * @param val
	 */
	public void myPush(int val) {
		queue1.add(new Integer(val));
	}
	
	/**
	 * ����ջ��Ԫ�أ�
	 * 
	 */
	public void transMyStack() {
		
		for(int i = 0;i<queue2.size();i++){
			System.out.println(queue2.get(i));
		}
		
		for(int i = 0;i<queue1.size();i++){
			System.out.println(queue1.get(i));
		}
		
	}
}
