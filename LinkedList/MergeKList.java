// Given K sorted linked lists of different sizes. The task is to merge them in such a way that after merging they will be a single sorted linked list.
// Example 1:
// Input:
// K = 4
// value = {{1,2,3},{4 5},{5 6},{7,8}}
// Output: 1 2 3 4 5 5 6 7 8
// Explanation:
// The test case has 4 sorted linked 
// list of size 3, 2, 2, 2
// 1st    list     1 -> 2-> 3
// 2nd   list      4->5
// 3rd    list      5->6
// 4th    list      7->8
// The merged list will be
// 1->2->3->4->5->5->6->7->8.



class Solution
{
    //Function to merge K sorted linked list.
    Node mergeKList(Node[]arr,int K)
    {
        if(arr.length == 0)
          return null;
        return mergeKList1(arr, 0, arr.length-1);
    }
    
    Node mergeKList1(Node[]arr, int start, int end)
    {
        if(start > end)
          return null;
        if(start == end)
          return arr[start];
        int mid = (start + end) / 2;
        
        Node l1 = mergeKList1(arr, start, mid);
        Node l2 = mergeKList1(arr, mid+1, end);
        
        return mergeTwoLL(l1, l2);
    }
    
    public Node mergeTwoLL(Node head1, Node head2) {
        if(head1 == null || head2 == null)
          return (head1 != null) ? head1 : head2;
        
        Node dNode = new Node(0);
        Node prev = dNode;
        
        Node c1 = head1;
        Node c2 = head2;
        
        while(c1 != null && c2 != null) {
            if(c1.data < c2.data) {
                prev.next = c1;
                c1 = c1.next;
            }
            
            else {
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;
        }
        
        if(c1 != null)
          prev.next = c1;
        else if(c2 != null)
          prev.next = c2;
        
        return dNode.next;
    }
}
