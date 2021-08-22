
import java.util.*;
class Node {
	int data;
	Node next;
	Node prev;
	Node(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}


public class MiddleOfStack {
	public static void main(String[] args) {
		myStack ms = new myStack();
		ms.push(1);
		ms.push(2);
		ms.push(3);
		ms.push(4);
		ms.push(5);
		ms.push(6);
		ms.printData();
		System.out.println();
		System.out.println("Middle is: "+ms.mid());
		
		System.out.println("Popped element is: "+ms.pop());
		ms.printData();
		System.out.println();
		System.out.println("Middle is: "+ms.mid());
		
		System.out.println("Popped element is: "+ms.pop());
		ms.printData();
		System.out.println();
		System.out.println("Middle is: "+ms.mid());
		
		System.out.println("Popped element is: "+ms.pop());
		ms.printData();
		System.out.println();
		System.out.println("Middle is: "+ms.mid());
	}
}
class myStack {
	Node dNode = new Node(-1);
	Node head = dNode;
	Node mid = dNode;
	int cnt = 0;
	
	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		newNode.prev = null;
		head.prev = newNode;
		head = newNode;
		cnt++;
		if(cnt == 1)
			mid = newNode;
		else if(cnt % 2 == 0)
			mid = mid.prev;	
	}
	
	public int pop() {
		if(cnt == 0)
			return -1;
		int x = head.data;
		head = head.next;
		if(head != null)
			head.prev = null;
		cnt--;
		if(cnt % 2 == 1)
			mid = mid.next;
		return x;
	}
	
	public int mid() {
		if(cnt == 0)
			return -1;
		else
			return mid.data;
	}
	
	public void printData() {
		Node curr = head;
		if(cnt == 0) {
			System.out.println("Stack is empty");
			return;
		}
		for(int i = 0; i < cnt; i++) {
			System.out.print(curr.data+" ");
			curr = curr.next;
		}
	}
}
