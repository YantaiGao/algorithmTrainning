package offer_aimTo;

import java.util.Stack;

public class Ch02_TwoStackQueue {
	/**
	 * 目标：使用两个栈实现队列
	 * 思路：
	 * (1):
	 * Stack1、Stack2
	 * 每新来一个元素，要入栈，则将所有Stack1中元素出栈到temp stack Stack2中，然后将新元素T 压入栈Stack1，然后将Stack2中所有的元素出栈入到Stack1中
	 * 
	 * (2):
	 * 插入的时候就入栈Stack1；
	 * 删除队首元素的时候，就先判断Stack2是否为空，
	 * 		为空，将Stack1中元素全部出栈，压入Stack2，然后Stack2出栈一个删除，
	 * 		不为空Stack2直接出栈删除
	 * @param args
	 */
	public static void main(String[] args) {
		//即将入队的元素
		Integer[] queueElement = {1,2,3,4,5,6};
		Ch02_TwoStackQueue queue = new Ch02_TwoStackQueue();
		Stack<Integer> stack = queue.inQueue(queueElement);
		queue.outQueue(stack);
		//方法二：
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
	 * 栈可以使用集合的方式遍历
	 * @param stack2
	 */
	private void printQueue(Stack<String> stack2) {
		for (String string : stack2) {
			System.out.print(string + "\t");
		}
	}


	/**
	 * 方法一：
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
	
	/**
	 * 思路2：
	 * 入栈的时候直接入栈就可以
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
	 * 出队
	 * @param stack1
	 * @param string
	 */
	private <T> void DeQueue(Stack<T> stack1, Stack<T> stack2) {
		if (!stack2.isEmpty()) {
			//非空直接出栈
			stack2.pop();
		}else {
			//stack2 == null,将stack1中所有元素出栈，压入stack2中
			while (!stack1.isEmpty()) {
				T item = stack1.pop();
				stack2.push(item);
			}
			//然后出栈
			stack2.pop();
		}
	}
	
	
}
