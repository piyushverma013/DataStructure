// Given the head of a singly linked list, return the middle node of the linked list.

// If there are two middle nodes, return the second middle node.

//   1 ----> 2 ----> 3 ----> 4 ----> 5 ----> 6
  
// Input: head = [1,2,3,4,5,6]
// Output: 4
// Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.


// EDGE CASE: If there is a loop in the linked list, first remove the loop.



   public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode first = head;
        ListNode second = head;
        
        while(second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }
        return first;
    }
