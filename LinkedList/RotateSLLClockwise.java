// Example 1:
// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]

// Example 2:
// Input: head = [0,1,2], k = 4
// Output: [2,0,1]



class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)
            return head;
        
        int len = 1;
        ListNode last = head;
        while(last.next != null) {
            len++;
            last = last.next;
        }
        
        if(k == len)
          return head;
        
        k = k % len;
        if(k > 0) {
        k = len - k;
        ListNode a = head, b = null;
        while(k-- > 0) {
            b = a;
            a = a.next;
        }
        last.next = head;
        b.next = null;
        head = a;
        }
        return head;
    }
}
