// Delete a node from circular LinkedList

// Input : 2->5->7->8->10->(head node)
//         data = 5
// Output : 2->7->8->10->(head node)

public static Node deleteNode(Node head, int key) {
    if(head == null)
      return null;
      
  Node curr = head, prev = null;
  while(curr.data != key) {
      if(curr.next == head) {
          System.out.println("Key not found in Linked List");
          break;
      }
      prev = curr;
      curr = curr.next;
  }
  
  //Case1: Check it is the only node and head node
  if(curr == head && curr.next == head) {
      head = null;
      return head;
  }
  
  //Case2: Check if it is the first node
  if(curr == head) {
      while(curr.next != head) {
          curr = curr.next;
      }
      head = head.next;
      curr.next = head;
  }
  
  //Case3 : Check if it is the last node
  else if(curr.next == head) {
      prev.next = head;
  }
  
  //Case4 : If the node is anywhere between the linkedlist
  else {
      prev.next = curr.next;
  }
  return head;
}
