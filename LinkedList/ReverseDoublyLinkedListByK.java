// Given a doubly linked list containing n nodes. The problem is to reverse every group of k nodes in the list.
// Input:
// 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6 <-> 7
// K = 2
// Output:
// 2 <-> 1 <-> 4 <-> 3 <-> 6 <-> 5<-> 7



  
static Node reverseByN(Node head, int k)
{
    if (head == null)
        return null;
         
    head.prev = null;
    Node temp;
    Node curr = head;
    Node newHead = null;
    int count = 0;
     
    while (curr != null && count < k)
    {
        newHead = curr;
        temp = curr.prev;
        curr.prev = curr.next;
        curr.next = temp;
        curr = curr.prev;
        count++;
    }
     
    if (count >= k)
    {
        head.next = reverseByN(curr, k);
    }
    return newHead;
}
