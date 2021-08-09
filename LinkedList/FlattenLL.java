// Input:
// 5 -> 10 -> 19 -> 28
// |     |     |     | 
// 7     20    22   35
// |           |     | 
// 8          50    40
// |                 | 
// 30               45

// Output:  5-> 7-> 8- > 10 -> 19-> 20-> 22-> 28-> 30-> 35-> 40-> 45-> 50.

// Explanation:
// The resultant linked lists has every node in a single level.
// (Note: | represents the bottom pointer.)

class FlattenLL
{
    Node flatten(Node root)
    {
	    if(root == null || root.next == null)
	      return root;
	    
	    root.next = flatten(root.next);
	    
	    root = mergeTwoLL(root, root.next);
	    return root;
    }
    
    Node mergeTwoLL(Node head1, Node head2) {
        if(head1 == null || head2 == null)
          return (head1 != null) ? head1 : head2;
        
        Node dNode = new Node(-1);
        Node temp = dNode;
        
        Node c1 = head1;
        Node c2 = head2;
        
        while(c1 != null && c2 != null) {
            if(c1.data < c2.data) {
                temp.bottom = c1;
                c1 = c1.bottom;
            }
            else {
                temp.bottom = c2;
                c2 = c2.bottom;
            }
            temp = temp.bottom;
        }
        
        if(c1 != null)
          temp.bottom = c1;
        
        else if(c2 != null)
          temp.bottom = c2;
        
        return dNode.bottom;
    }
}
