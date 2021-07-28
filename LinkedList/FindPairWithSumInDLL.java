// Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose sum is equal to given value x, without using any extra space? 

// Example:  

// Input : head : 1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
//         x = 7

// Output: (6, 1), (5,2)
// The expected time complexity is O(n) and auxiliary space is O(1).

static void pairSum( Node head, int x)
{
    // Set two pointers, first to the beginning of DLL and second to the end of DLL
    Node first = head;
    Node second = head;
    while (second.next != null)
        second = second.next;
 
    // To track if we find a pair or not
    boolean found = false;
 
    // The loop terminates when they become null or cross each other (second.next == first), or they become same (first == second)
    while ( first != null && second != null && first != second && second.next != first)
    {
        // pair found
        if ((first.data + second.data) == x)
        {
            found = true;
            System.out.println( "(" + first.data +
                                ", "+ second.data + ")" );
 
            // move first in forward direction
            first = first.next;
 
            // move second in backward direction
            second = second.prev;
        }
        else
        {
            if ((first.data + second.data) < x)
                first = first.next;
            else
                second = second.prev;
        }
    }
 
    // if pair is not present
    if (found == false)
        System.out.println("No pair found");
}
