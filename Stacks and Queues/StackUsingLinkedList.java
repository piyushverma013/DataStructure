public class StackUsingLinkedList {
    private Node head = null;
    private int size = 0;
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public static void main(String args[]) {
        StackUsingLinkedList theStack = new StackUsingLinkedList();
        theStack.push(5);
        theStack.push(4);
        theStack.push(3);
        theStack.push(2);
        theStack.push(1);
        
        System.out.println("Stack size is : "+ theStack.getSize());
        
        System.out.println("Popping elements: ");
        System.out.println(theStack.pop());
        System.out.println(theStack.pop());
        
        System.out.println();
        System.out.println();
        
        theStack.push(22);
        theStack.push(31);
        theStack.push(40);
        theStack.push(13);
        System.out.println("Stack size is : "+ theStack.getSize());
        
        System.out.println();
        System.out.println();
        
        System.out.println("Popping elements: ");
        while(!theStack.isEmpty()) {
            System.out.println(theStack.pop());
        }
        
        System.out.println("Stack size is : "+ theStack.getSize());
        
    }
    
    public void push(int a) {
        Node newNode = new Node(a);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        int c = head.data;
        head = head.next;
        size--;
        return c;
    }
    
    public boolean isEmpty() {
        if(head == null)
          return true;
        return false;
    }
    
    public int getSize() {
        return size;
    }
}
