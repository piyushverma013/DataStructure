import java.util.*;

public class RemoveDuplicateinSortedLL {
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
		
		System.out.println();
		Node ans = removeDuplicate(head);
		
		System.out.println("Linked List after removing duplicate: ");
		printList(head);	
	}
	
	// function to remove duplicate in sorted Linked List
	static Node removeDuplicate(Node head) {
		
		if(head == null || head.next == null)
			return head;
		
		Node first = head, second = head;
		
		while(second != null && second.next != null) {
			
			while(first != null && first.data == second.data) {
				first = first.next;
			}
			second.next = first;
			second = second.next;
		}
		return head;
		
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
