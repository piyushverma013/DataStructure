//Merge Sort for Linked List
//Time Complexity: O(N*Log(N))
//Auxiliary Space: O(N)

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        if(head == null || head.next == null)
          return head;
          
        Node mid = midNode(head);
        Node nHead = mid.next;
        mid.next = null;
        
        Node L1 = mergeSort(head);
        Node L2 = mergeSort(nHead);
        
        return mergeTwoLL(L1,L2);
    }
    
    //Function to find middle element in Linked List
    static Node midNode(Node head) {
        if(head == null || head.next == null)
          return head;
          
        Node fast = head;
        Node slow = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
  //Function to merge two sorted Linked List
    static Node mergeTwoLL(Node head1, Node head2) {
        if(head1 == null || head2 == null)
          return (head1 != null) ? head1 : head2;
          
        Node dummyNode = new Node(0);
        Node prev = dummyNode;
        
        Node c1 = head1;
        Node c2 = head2;
        
        while(c1 != null && c2 != null) {
            if(c1.data < c2.data) {
                prev.next = c1;
                c1 = c1.next;
                prev = prev.next;
            }
            else {
                prev.next = c2;
                c2 = c2.next;
                prev = prev.next;
            }
        }
        
        if(c1 == null)
          prev.next = c2;
        else if(c2 == null)
          prev.next = c1;
        
        return dummyNode.next;
    }
}
