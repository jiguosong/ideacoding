package list;

public class myownStack<E> {
	private int top = -1;
	private int CAP = 0;
	private E[] array = null;

	@SuppressWarnings("unchecked")
	myownStack(int cap) {
		this.top = -1;
		this.CAP = cap;
		this.array = (E[]) new Object[CAP];
	}
	
	public E pop() {
		if (top == -1) {
			return null;
		} else {
			E tmp = array[top];
			top--;
			return tmp;
		}
	}
	
	public void push(E e) {
		if (this.isFull()) return;
		top++;
		array[top] = e;
	}
	
	public boolean isFull() {
		return (top == CAP);
	}

	public boolean isEmpy() {
		return (top == -1);
	}

	public int size() {
		return top+1;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		myownStack<Integer> stack = new myownStack<Integer>(10);
		stack.push(1);
		stack.push(3);
		stack.push(2);
		stack.push(4);
		
		while (!stack.isEmpy()) {
			int p = stack.pop();
			System.out.println(p);
		}		

	}

}
