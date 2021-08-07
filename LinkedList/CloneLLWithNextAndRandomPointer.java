// Q. https://practice.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1#



// T.C. O(n) | S.C. O(n)
Node copyList(Node head) {
        // your code here
        if(head == null)
          return head;
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node curr = head;
        
        Node nHead = new Node(-1);
        Node prev = nHead;
        while(curr != null) {
            prev.next = new Node(curr.data);
            map.put(curr, prev.next);
            prev = prev.next;
            curr = curr.next;
        }
        nHead = nHead.next;
        Node c1 = head;
        Node c2 = nHead;
        
        while(c1 != null) {
            c2.arb = ((c1.arb != null) ? map.get(c1.arb) : null);
            c1 = c1.next;
            c2 = c2.next;
        }
        
        return nHead;
    }




/////////////////////////////////////////////////////////////////////////////Efficient approach///////////////////////////////////////////////////////////////////////////



// T.C. O(n) | S.C. O(n)
 Node copyList(Node head) {
        // your code here
        Node curr = head;
        while(curr != null) {
            Node forw = curr.next;
            Node newNode = new Node(curr.data);
            curr.next = newNode;
            newNode.next = forw;
            curr = forw;
        }
        
        curr = head;
        while(curr != null) {
            Node random = curr.arb;
            if(random != null) {
                curr.next.arb = random.next;
            }
            curr = curr.next.next;
        }
        
        Node newHead = new Node(-1);
        Node prev = newHead;
        curr = head;
         while(curr != null) {
             prev.next = curr.next;
             curr.next = curr.next.next;
             prev = prev.next;
             curr = curr.next;
         }
         newHead = newHead.next;
         return newHead;
    }
