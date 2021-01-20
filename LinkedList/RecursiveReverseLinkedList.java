import java.util.*;

public class RecursiveReverseLinkedList {

	static class Node {
		int data;
		Node next;
		
	Node(int data)
		{
			this.data = data;
			this.next = null;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter size of Linked List ");
		int n = obj.nextInt();
		int arr[] = new int[n];
		
		System.out.println("Enter Linked List elements: ");
		Node head = null, tail = null;
		for(int i = 0; i < n; i++)
		{
			arr[i] = obj.nextInt();
			
			if(head == null) {
				head = new Node(arr[i]);
				tail = head;
			}
			else {
				tail.next = new Node(arr[i]);
				tail = tail.next;
			}
		}
		System.out.println("Linked List elements are: ");
		printList(head);
		
		Node ans = reverseList(head);
		System.out.println();
		
		System.out.println("Reverse of Linked List is: ");
		printList(ans);
	}
	
	
	// fuction to reverse the LinkedList
	static Node reverseList(Node head) {
		
		if(head == null || head.next == null)
			return head;
		
		Node newNode = head.next;
		head.next = null;
		Node rev = reverseList(newNode);
		newNode.next = head;
		
		return rev;
	}
	
	
	// function to print LinkedList elements
	static void printList(Node head) {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	

}
