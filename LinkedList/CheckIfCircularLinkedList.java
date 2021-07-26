// Input:
// LinkedList: 1 -> 2 -> 3 -> 4 ->5
//             ^                  |
//             |_ _ _ _ _ _ _ _ _ | 
// (the first and last node is connected,
// i.e. 5 --> 1)
// Output: 1
  
// Input:
// LinkedList: 2 -> 4 -> 6 -> 7 -> 5-> 1 -> null (the first and last node is not connected)
// Output: 0


boolean isCircular(Node head) {
  if(head == null)
    return true;
  Node curr = head;
  while(curr != null) {
    curr = curr.next;
    if(curr == head)
      return true;
  }
  return false;
}
