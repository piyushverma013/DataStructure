// Given a link list of size N, modify the list such that all the even numbers appear before all the odd numbers in the modified list. 
// The order of appearance of numbers within each segregation should be same as that in the original list.
  
// Example 1:
// Input: 
// N = 7
// Link List = 
// 17 -> 15 -> 8 -> 9 -> 2 -> 4 -> 6 -> NULL
// Output: 8 2 4 6 17 15 9
// Explaination: 17,15,8,9 are odd so they appear 
// first and 2,4,6 are the even numbers that appear later.

// Example 2:
// Input:
// N = 4
// Link List = 1 -> 3 -> 5 -> 7
// Output: 1 3 5 7
// Explaination: There is no even number. 
// So ne need for modification.


    Node segregate(Node head){
        // code here
        if(head == null || head.next == null)
          return head;
        Node oddH = new Node(0);
        Node evenH = new Node(0);
        
        Node odd = oddH, even = evenH;
        Node curr = head;
        
        while(curr != null) {
            if(curr.data % 2 == 0) {
                even.next = curr;
                even = even.next;
            }
            else {
                odd.next = curr;
                odd = odd.next;
            }
            curr = curr.next;
        }
        
        even.next = oddH.next;
        odd.next = null;
        head = evenH.next;
        
        return head;
    }
