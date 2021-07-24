import java.util.*;
public class AddTwoLinkedLists {

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
		
		System.out.println("Enter size of Linked List1 ");
		int m = obj.nextInt();
		int arr1[] = new int[m];
		
		System.out.println("Enter Linked List elements: ");
		Node head1 = null, tail1 = null;
		for(int i = 0; i < m; i++) {
			arr1[i] = obj.nextInt();
			
			if(head1 == null) {
				head1 = new Node(arr1[i]);
				tail1 = head1;
			}
			
			else {
				tail1.next = new Node(arr1[i]);
				tail1 = tail1.next;
			}
		}
		System.out.println("Linked List1 elements are: ");
		printList(head1);
		System.out.println();
		
		System.out.println("Enter size of Linked List2 ");
		int n = obj.nextInt();
		int arr2[] = new int[n];
		
		System.out.println("Enter Linked List elements: ");
		Node head2 = null, tail2 = null;
		for(int i = 0; i < n; i++) {
			arr2[i] = obj.nextInt();
			
			if(head2 == null) {
				head2 = new Node(arr2[i]);
				tail2 = head2;
			}
			
			else {
				tail2.next = new Node(arr2[i]);
				tail2 = tail2.next;
			}
		}
		System.out.println("Linked List2 elements are: ");
		printList(head2);
		System.out.println();
		
		
		System.out.println("Sum of two LinkedList is ");
		Node ans = addTwoLists(head1, head2);
		printList(ans);
	}
	
	// Function to reverse LinkedList
	static Node reverse(Node head) {
        if(head == null || head.next == null)
          return head;
          Node curr = head, prev = null, next = null;
          while(curr != null) {
              next = curr.next;
              curr.next = prev;
              prev = curr;
              curr = next;
          }
          return prev;
    }
	
	// Function two add two LinkedLists
	public static Node addTwoLists(Node first, Node second) {
		
		Node l1 = reverse(first), l2 = reverse(second);
		int carry = 0;
		Node new_head = new Node(0);
		Node temp = new_head;
		while(l1 != null || l2 != null || carry == 1) {
			int sum = 0;
			
			if(l1 != null) {
				sum += l1.data;
				l1 = l1.next;
			}
			
			if(l2 != null) {
				sum += l2.data;
				l2 = l2.next;
			}
			
			sum += carry;
			carry = sum / 10;
			sum = sum % 10;
			
			Node new_node = new Node(sum);
			temp.next = new_node;
			temp = temp.next;
		}
		new_head = reverse(new_head.next);
		return new_head;
		
	}
	
	// Function to print the LinkedList
	public static void printList(Node head) {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}

}