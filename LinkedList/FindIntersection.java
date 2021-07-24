import java.util.*;
public class FindIntersection {

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
		
		
		System.out.println("Intersection of two LinkedList is ");
		Node ans = findIntersection(head1, head2);
		printList(ans);
	}
	
	// Function to find intersection in two LinkedList
	public static Node findIntersection(Node head1, Node head2)
    {
        // code here.
        Node l1 = head1;
        Node l2 = head2;
        Node head = null, tail = null;
        while(l1 != null && l2 != null) {
            if(l1.data < l2.data) {
                l1 = l1.next;
            }
            else if(l2.data < l1.data) {
                l2 = l2.next;
            }
            
            else {
                if(head == null) {
                  head = new Node(l2.data);
                  tail = head;
                }
                  
                else {
                    tail.next = new Node(l2.data);
                    tail = tail.next;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
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