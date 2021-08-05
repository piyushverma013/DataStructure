// Example 1:
// Input:
// N = 5
// value[] = {2, 4, 7, 8, 9}
// k = 3
// Output: 8 9 2 4 7
// Explanation:
// Rotate 1: 4 -> 7 -> 8 -> 9 -> 2
// Rotate 2: 7 -> 8 -> 9 -> 2 -> 4
// Rotate 3: 8 -> 9 -> 2 -> 4 -> 7

// Example 2:
// Input:
// N = 8
// value[] = {1, 2, 3, 4, 5, 6, 7, 8}
// k = 4
// Output: 5 6 7 8 1 2 3 4
// T.C. O(n) | S.C. O(1)

public Node rotate(Node head, int k) {
        // add code here
        if(head == null || head.next == null || k == 0)
          return head;
          
          Node curr = head;
          int count = 1;
          
          while(count++ < k && curr != null) {
              curr = curr.next;
          }
          
          if(curr == null)  //means k is greater than or equal to count of nodes in LL
            return head;
          
          Node kthNode = curr;
          while(curr.next != null) {
              curr= curr.next;
          }
          
          curr.next = head;
          head = kthNode.next;
          kthNode.next = null;
          
          return head;
    }

///////////////////////////////////////////////////////// Alternate Solution//////////////////////////////////////////////////////////

public Node rotate(Node head, int k) {
        // add code here
        if(head == null || head.next == null || k == 0)
          return head;
          
        Node last = head;
        int len = 1;
        while(last.next != null) {
            len++;
            last = last.next;
        }
        
        if(k >= len)
          return head;
        
        k = k % len;
        Node b = head, a = null;
        
        while(k-- > 0) {
            a = b;
            b = b.next;
        }
        last.next = head;
        a.next = null;
        
        head = b;
        return head;
    }
