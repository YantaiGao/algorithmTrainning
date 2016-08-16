package offer_aimTo;

import java.util.Stack;

public class Ch02_TwoStackQueue {
	/**
	 * 目标：使用两个栈实现队列
	 * 思路：
	 * Stack1、Stack2
	 * 每新来一个元素，要入栈，则将所有Stack1中元素出栈到temp stack Stack2中，然后将新元素T 压入栈Stack1，然后将Stack2中所有的元素出栈入到Stack1中
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//即将入队的元素
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
					//全部出栈，压入暂时栈
					T popT = stack.pop();
					tempStack.push(popT);
				}
				//新元素入栈
				stack.push(t);
				//所有temp中元素出栈，压入stack中
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
