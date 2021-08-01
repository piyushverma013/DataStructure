// Input:
// N = 8
// value[] = {1,2,2,1,2,0,2,2}
// Output: 0 1 1 2 2 2 2 2
// Explanation: All the 0s are segregated
// to the left end of the linked list,
// 2s to the right end of the list, and
// 1s in between.    


static Node segregate(Node head)
    {
        // add your code here
        if(head == null || head.next == null)
          return head;
        Node zeroD = new Node(0);
        Node oneD = new Node(0);
        Node twoD = new Node(0);
        
        Node zero = zeroD, one = oneD, two = twoD;
        Node curr = head;
        
        while(curr != null){
            if(curr.data == 0) {
                zero.next = curr;
                zero = zero.next;
                curr = curr.next;
            }
            else if(curr.data == 1) {
                one.next = curr;
                one = one.next;
                curr = curr.next;
            }
            else {
                two.next = curr;
                two = two.next;
                curr = curr.next;
            }
        }
        if(oneD.next == null) {
            zero.next = twoD.next; 
        }
        else {
            zero.next = oneD.next;
        }
        one.next = twoD.next;
        two.next = null;
        head = zeroD.next;
        
        return head;
        
    }
