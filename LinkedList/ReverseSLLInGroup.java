import java.util.*;
public class ReverseSLLInGroup {
	
	static class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner obj = new Scanner(System.in);
		
		System.out.println("Enter size of Linked List: ");
		int n = obj.nextInt();
		int arr[] = new int[n];
		
		Node head = null, tail = null;
		System.out.println("Enter Linked List elements: ");
		for(int i = 0; i < n; i++)
		{
			arr[i] = obj.nextInt();
			
			if(head == null)
			{
				head = new Node(arr[i]);
				tail = head;	
			}
			
			else 
			{
				tail.next = new Node(arr[i]);
				tail = tail.next;
			}
		}
		
		System.out.println("Enter group size: ");
		int k = obj.nextInt();
		
		System.out.println("Original Linked List is: ");
		printLL(head);
		Node ans = reverse(head, k);
		System.out.println("Reversed Linked List is: ");
		printLL(ans);
	}
	
	static Node reverse(Node head, int k)
	{
		
		if(head == null || head.next == null)
			return head;
		
		Node current = head;
		Node prev = null;
		Node next = null;
		int count = 1;
		while(count <= k && current != null)
		{
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
			if(next != null) {
				head.next = reverse(next, k);
			}
			
		head = prev;
		return head;
		
	}
	
	static void printLL(Node head)
	{
		Node temp = head;
		while(temp != null)
		{
			System.out.print(temp.data+ " ");
			temp = temp.next;
		}
		System.out.println();
	}

}
