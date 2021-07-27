// Example 1:
// Input:
// N = 3
// value[] = {1,2,1}
// Output: 1
// Explanation: The given linked list is
// 1 2 1 , which is a palindrome and
// Hence, the output is 1.

// Example 2:
// Input:
// N = 4
// value[] = {1,2,3,4}
// Output: 0
// Explanation: The given linked list
// is 1 2 3 4 , which is not a palindrome
// and Hence, the output is 0.


    //Function to check whether the list is palindrome
    boolean isPalindrome(Node head) 
    {
        //Your code here
        if(head == null)
          return true;
          
        Node fast = head;
        Node slow = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        if(fast != null) {
            mid = slow.next;              //for odd nodes
        }
        
        else if(fast == null){
            mid = slow;                   //for even nodes
        }
        
        Node temp = reverse(mid);         //reversing the second half and comparing it with the first half
        
        Node temp1 = head;
        while(temp != null) {
            if(temp.data != temp1.data)
              return false;
            
            temp = temp.next;
            temp1 = temp1.next;
        }
        return true;
    }
    
    //function to reverse a linked list
    static Node reverse(Node head) {
        Node curr = head;
        Node prev = null, next = null;
        
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
