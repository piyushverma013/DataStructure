// Linked List 1 = 4->1->common
// Linked List 2 = 5->6->1->common
// common = 8->4->5->NULL
// Output: 8
// Explanation: 

// 4         5
// |         |
// 1         6
//  \       /
//   8  -  1 
//      |
//      4
//      |
//      5
//      |
//     NULL  


int intersectPoint(Node head1, Node head2)
	{
         // code here
         Node ptr1 = head1, ptr2 = head2;
         
         while(ptr1 != ptr2) {
             
             if(ptr1 == null)
               ptr1 = head2;
             else 
               ptr1 = ptr1.next;
             
             if(ptr2 == null)
               ptr2 = head1;
             else
               ptr2 = ptr2.next;
         }
        if(ptr1 == ptr2)
          return ptr1.data;
        else
        return -1;
	}
