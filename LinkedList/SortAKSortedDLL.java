// Given a doubly linked list containing n nodes, where each node is at most k away from its target position in the list. 
// The problem is to sort the given doubly linked list. 
// For example, let us consider k is 2, a node at position 7 in the sorted doubly linked list, can be at positions 5, 6, 7, 8, 9 in the given doubly linked list.
// Input: 3 <-> 6 <-> 2 <-> 12 <-> 56 <-> 8   
// k = 2
// Output: 2 <-> 3 <-> 6 <-> 8 <-> 12 <-> 56

class compareNode implements Comparator<Node>
{
	public int compare(Node n1, Node n2){
	return n1.data-n2.data;
	}
}

Node sortAKSortedDLL( Node head, int k)
{
  Node newHead = null, curr = null;
  PriorityQueue<Node> pq = new PriorityQueue<Node>(new compareNode());
	for (int i = 0; head != null && i <= k; i++)
	{
	pq.add(head);
	head = head.next;
	}
    while(!pq.isEmpty()) {
        if(newHead == null) {
            newHead = pq.peek();
            newHead.prev = null;
            curr = newHead;
        }
        else {
            curr.next = pq.peek();
            pq.peek().prev = curr;
            curr = curr.next;
        }
        pq.poll();
        if(head != null) {
            pq.add(head);
            head = head.next;
        }
    }
    curr.next = null;
    return newHead;
}
