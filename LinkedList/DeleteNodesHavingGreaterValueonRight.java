// Example 1:
// Input:
// LinkedList = 12->15->10->11->5->6->2->3
// Output: 15 11 6 3
// Explanation: Since, 12, 10, 5 and 2 are
// the elements which have greater elements on the following nodes. 
// So, after deleting them, the linked list would like be 15, 11, 6, 3.


// Example 2:
// Input:
// LinkedList = 10->20->30->40->50->60
// Output: 60    

    static Node compute(Node head)
    {
        // your code here
        head = reverse(head);
        int ma = head.data;
        Node curr = head.next;
        Node prev = head;
        while(curr != null) {
            
            if(curr.data >= ma) {
                ma = curr.data;
                prev = curr;
                curr = curr.next;
            }
            else {
                prev.next = curr.next;
                curr = prev.next;
            }
        }
            
            head = reverse(head);
            return head;
            
        }
    
    static Node reverse(Node head) {
        if(head == null || head.next == null)
          return head;
        
        Node rev = reverse(head.next);
        head.next.next = head;
        head.next = null;
        
        return rev;
    }
