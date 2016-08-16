package offer_aimTo;

import java.util.Stack;

public class Ch02_TwoStackQueue {
	/**
	 * Ŀ�꣺ʹ������ջʵ�ֶ���
	 * ˼·��
	 * (1):
	 * Stack1��Stack2
	 * ÿ����һ��Ԫ�أ�Ҫ��ջ��������Stack1��Ԫ�س�ջ��temp stack Stack2�У�Ȼ����Ԫ��T ѹ��ջStack1��Ȼ��Stack2�����е�Ԫ�س�ջ�뵽Stack1��
	 * 
	 * (2):
	 * �����ʱ�����ջStack1��
	 * ɾ������Ԫ�ص�ʱ�򣬾����ж�Stack2�Ƿ�Ϊ�գ�
	 * 		Ϊ�գ���Stack1��Ԫ��ȫ����ջ��ѹ��Stack2��Ȼ��Stack2��ջһ��ɾ����
	 * 		��Ϊ��Stack2ֱ�ӳ�ջɾ��
	 * @param args
	 */
	public static void main(String[] args) {
		//������ӵ�Ԫ��
		Integer[] queueElement = {1,2,3,4,5,6};
		Ch02_TwoStackQueue queue = new Ch02_TwoStackQueue();
		Stack<Integer> stack = queue.inQueue(queueElement);
		queue.outQueue(stack);
		//��������
		String[] strArr = {"A","B","C","D"};
		String[] strArr2 = {"E","F"};
		Stack<String> stack1 = queue.InQueue(strArr);
		Stack<String> stack2 = new Stack<String>();
		queue.DeQueue(stack1,stack2);
		queue.InQueue(strArr2);
		queue.printQueue(stack1);
		queue.printQueue(stack2);
	}


	/**
	 * ջ����ʹ�ü��ϵķ�ʽ����
	 * @param stack2
	 */
	private void printQueue(Stack<String> stack2) {
		for (String string : stack2) {
			System.out.print(string + "\t");
		}
	}


	/**
	 * ����һ��
	 * @param stack
	 */
	private <T> void outQueue(Stack<T> stack) {
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + "\t");
		}
		System.out.println();
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
	
	/**
	 * ˼·2��
	 * ��ջ��ʱ��ֱ����ջ�Ϳ���
	 */
	private <T> Stack<T> InQueue(T[] queueElement) {
		if (queueElement.length > 0) {
			Stack<T> stack = new Stack<T>();
			for (T t : queueElement) {
				stack.push(t);	
			}
			return stack;
		}
		return null;
	}
	/**
	 * ����
	 * @param stack1
	 * @param string
	 */
	private <T> void DeQueue(Stack<T> stack1, Stack<T> stack2) {
		if (!stack2.isEmpty()) {
			//�ǿ�ֱ�ӳ�ջ
			stack2.pop();
		}else {
			//stack2 == null,��stack1������Ԫ�س�ջ��ѹ��stack2��
			while (!stack1.isEmpty()) {
				T item = stack1.pop();
				stack2.push(item);
			}
			//Ȼ���ջ
			stack2.pop();
		}
	}
	
	
}
