import java.util.*;
public class AddOneToLinkedList {

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
		
		System.out.println("Enter size of Linked List ");
		int n = obj.nextInt();
		int arr[] = new int[n];
		
		System.out.println("Enter Linked List elements: ");
		Node head = null, tail = null;
		for(int i = 0; i < n; i++) {
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
		Node ans = addOne(head);
		printList(ans);
	}
	
    // Function to add 1 at the LinkedList
    public static Node addOne(Node head) 
    { 
        //code here.
        if(head == null)
          return head;
        
        Node prev = null, curr = head;
        
        while(curr.next != null) {
            if(curr.data != 9)
              prev = curr;
            curr = curr.next;
        }
        
        if(curr.data != 9) {
            curr.data += 1;
            return head;
        }
        if(prev == null) {
            prev = new Node(0);
            prev.next = head;
            head = prev;
        }
        
        prev.data += 1;
        prev = prev.next;
        
        while(prev != null) {
            prev.data = 0;
            prev = prev.next;
        }
        return head;
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
