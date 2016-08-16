package offer_aimTo;

import java.util.Stack;

public class Ch02_TwoStackQueue {
	/**
	 * Ŀ�꣺ʹ������ջʵ�ֶ���
	 * ˼·��
	 * Stack1��Stack2
	 * ÿ����һ��Ԫ�أ�Ҫ��ջ��������Stack1��Ԫ�س�ջ��temp stack Stack2�У�Ȼ����Ԫ��T ѹ��ջStack1��Ȼ��Stack2�����е�Ԫ�س�ջ�뵽Stack1��
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//������ӵ�Ԫ��
		Integer[] queueElement = {1,2,3,4,5,6};
		Ch02_TwoStackQueue queue = new Ch02_TwoStackQueue();
		Stack<Integer> stack = queue.inQueue(queueElement);
		queue.outQueue(stack);
	}

	private <T> void outQueue(Stack<T> stack) {
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + "\t");
		}
	}

	private <T> Stack<T> inQueue(T[] queueElement) {
		Stack<T> stack = new Stack<T>();
		Stack<T> tempStack = new Stack<T>();
		if (queueElement.length > 0) {
			for (T t : queueElement) {
				while (!stack.isEmpty()) {
					//ȫ����ջ��ѹ����ʱջ
					T popT = stack.pop();
					tempStack.push(popT);
				}
				//��Ԫ����ջ
				stack.push(t);
				//����temp��Ԫ�س�ջ��ѹ��stack��
				while (!tempStack.isEmpty()) {
					T tempT = tempStack.pop();
					stack.push(tempT);
				}
			}
			return stack;
		}
		return null;
	}
	
	
}
