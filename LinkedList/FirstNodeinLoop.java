import java.util.Scanner;

public class FirstNodeinLoop {
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
		
		System.out.println("Enter position element to connect the Loop: ");
		int pos = obj.nextInt();
		makeLoop(head, tail, pos);
		
		boolean result = detectLoop(head);
		
		if(result) {
			System.out.println("Loop exist");
			
			Node ans = firsr_node(head);
			System.out.println(ans.data);
		}
		else
		System.out.println("No loop in Linked List");
		

	}
	
	// function to print linked list elements
	static void printList(Node head) {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	
	//function to create loop in linked list
	static void makeLoop(Node head, Node tail, int x) {
		if(x == 0)
			return;
		Node curr = head;
		for(int i = 1; i < x; i++) {
			curr = curr.next;
		}
		tail.next = curr;
	}
	
	// function to detect loop in linked list
	static boolean detectLoop(Node head) {
		if(head == null || head.next == null)
			return false;
	    
		Node fast_ptr = head;
		Node slow_ptr = head;
		
		while(fast_ptr != null && fast_ptr.next != null) {
			
			fast_ptr = fast_ptr.next.next;
			slow_ptr = slow_ptr.next;
			
			if(fast_ptr == slow_ptr)
				return true;
		}
		return false;
	}
	
	// function to find first node in loop of linked list
	static Node firsr_node(Node head){
		
		if(head == null || head.next == null)
			return null;
	    
		Node fast_ptr = head;
		Node slow_ptr = head;
		
		while(fast_ptr != null && fast_ptr.next != null) {
			
			fast_ptr = fast_ptr.next.next;
			slow_ptr = slow_ptr.next;
			
			if(fast_ptr == slow_ptr)
				break;
		}
		

        if (slow_ptr == fast_ptr) {
            slow_ptr = head;
            while (slow_ptr != fast_ptr) {
            	slow_ptr = slow_ptr.next;
            	fast_ptr = fast_ptr.next;
            	break;
            } 
        }
        return fast_ptr;
     
    }

}
