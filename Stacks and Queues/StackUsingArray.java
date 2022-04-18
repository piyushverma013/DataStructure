
public class StackUsingArray {
	   private int size;
	   private int[] arr;
	   private int top;
	   
	   public StackUsingArray(int size) {
	      this.size = size;
	      arr = new int[size];
	      top = -1;
	   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackUsingArray theStack = new StackUsingArray(4);
		theStack.push(5);
		theStack.push(50);
		theStack.push(10);
		theStack.push(1);
		theStack.push(2);
		System.out.println("Stack is: ");
		for(int i : theStack.arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		System.out.println(theStack.pop());
		System.out.println(theStack.pop());
		
		theStack.push(13);
		System.out.println("Stack is popping: ");
		while(!theStack.isEmpty()) {
			System.out.print(theStack.pop()+" ");
		}
		System.out.println();
		
		
	}
	
	public void push(int a) {
		if(isFull()) {
			System.out.println("Stack is full");
			return;
		}
		arr[++top] = a;
		return;
	}
	
	public int pop() {
		if(top == -1) {
			System.out.println("Stack is Empty");
			return -1;
		}
		return arr[top--];
	}
	
	public boolean isFull() {
		if(top+1 == arr.length)
			return true;
		else
			return false;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public int size() {
		return top+1;
	}
}
