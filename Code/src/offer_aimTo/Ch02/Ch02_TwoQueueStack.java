package offer_aimTo.Ch02;

import java.util.LinkedList;

public class Ch02_TwoQueueStack {

	/**
	 * 两个队列实现一个栈
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		
		myStack.myPush(1);
		myStack.myPush(2);
		myStack.myPush(3);
		System.out.println("123入栈后：");
		myStack.transMyStack();
		myStack.myPop(3);
		System.out.println("3出栈后：");
		myStack.transMyStack();
		myStack.myPush(4);
		myStack.myPush(5);
		System.out.println("45入栈后：");
		myStack.transMyStack();
	}

}

class MyStack{
	
	LinkedList<Integer> queue1 = new LinkedList<>();
	LinkedList<Integer> queue2 = new LinkedList<>();
	
	/**
	 *出栈:
	 *如果q1 = q2 = null，空栈不能出栈
	 *如果q1!=null,q1中元素出队到q2,直到剩下最后一个元素，出队即出栈
	 *如果q1 == null,q2不为空，将q2所有元素出队到对1，直到最后一个元素，出队即出栈
	 */
	public void myPop(int val) {

		if (queue1.isEmpty() && queue2.isEmpty()) {
			System.out.println("空栈，无法出栈");
		}
		
		if (!queue1.isEmpty()) {
			
			while (queue1.size() > 1) {
				Integer temp = queue1.poll();
				queue2.add(temp);
			}
			//出栈
			System.out.println("出栈：" + queue1.poll());
			
		}else {
		
			while (queue2.size() > 1) {
				Integer temp = queue2.poll();
				queue1.add(temp);
			}
			//出栈
			System.out.println("出栈：" + queue2.poll());
			
		}
		
	}
	/**
	 * 入栈:
	 * 直接入队queue1
	 * 
	 * @param val
	 */
	public void myPush(int val) {
		queue1.add(new Integer(val));
	}
	
	/**
	 * 遍历栈中元素：
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
