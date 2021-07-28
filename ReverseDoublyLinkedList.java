// Given a doubly linked list of n elements. The task is to reverse the doubly linked list.
// Example 1:
// Input:
// LinkedList: 3 <--> 4 <--> 5
// Output: 5 <--> 4 <--> 3

// Example 2:
// Input:
// LinkedList: 75 <--> 122 <--> 59 <--> 196
// Output: 196 <--> 59 <--> 122 <--> 75





public static Node reverseDLL(Node  head)
{
    //Your code here
    if(head == null || head.next == null)
      return head;
      
    Node curr = head;
    Node temp = null;
    
    while(curr != null) {
        temp = curr.prev;
        curr.prev = curr.next;
        curr.next = temp;
        curr = curr.prev;
    }
    
    if(temp != null)
      temp = temp.prev;
      
    head = temp;
    return head;
}
