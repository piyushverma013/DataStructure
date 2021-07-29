// Given a sorted doubly linked list of distinct nodes(no two nodes have the same data) and a value x. 
// Count triplets in the list that sum up to a given value x.

// Input1:
// 1 <---> 2 <--->4 <---> 5 <---> 6 <---> 8 <---> 9
// x = 17
// Output1:
// 2
// The triplets are (2, 6, 9) and (4, 5, 8).
  
// Input2:
// 1 <---> 2 <--->4 <---> 5 <---> 6 <---> 8 <---> 9
// x =15 
// Output2:
// 5
// The triplets are (1, 6, 8), (1, 5, 9), (2, 5, 8), (2, 4, 9) and (4, 5, 6)

===========================================================================================================================================================
  
  // Brute Force: (T.C.= O(n)) and (S.C. = O(1))
    static int countTriplets(Node head, int x)
    {
            Node ptr1, ptr2, ptr3;
            int count = 0;
 
            // generate all possible triplets
            for (ptr1 = head; ptr1 != null; ptr1 = ptr1.next)
                for (ptr2 = ptr1.next; ptr2 != null; ptr2 = ptr2.next)
                    for (ptr3 = ptr2.next; ptr3 != null; ptr3 = ptr3.next)
 
                        // if elements in the current triplet sum up to 'x'
                        if ((ptr1.data + ptr2.data + ptr3.data) == x)
                             
                            // increment count
                            count++;
 
            // required count of triplets
            return count;
    }

===========================================================================================================================================================
  // Time Optimization: (T.C.= O(n^2)) and (S.C. = O(n))
  static int countTriplets(Node head, int x)
	{
	    if(head == null)
	      return 0;
	    
	    int count = 0;
	    HashMap<Integer, Node> hm = new HashMap<Integer, Node>();

	    for(Node temp = head; temp != null; temp = temp.next) {
	        hm.put(temp.data, temp);
	    }
	    
	    for(Node temp1 = head; temp1 != null; temp1 = temp1.next) {
	        for(Node temp2 = temp1.next; temp2 != null; temp2 = temp2.next) {
	            
	            int sum = temp1.data + temp2.data;
	            if(hm.containsKey(x - sum) && hm.get(x - sum) != temp1
                && hm.get(x - sum) != temp2)
	              count++;
	        }
	    }
	    return count/3;
	}


===========================================================================================================================================================
  // Space Optimization: (T.C.= O(n^2)) and (S.C. = O(1))
 static int countTriplets(Node head, int x)
	{
	    if(head == null)
	      return 0;
	    
	    int count = 0;
	    Node current, first, last;
	    last = head;
	    
	    while(last.next != null) {
	        last = last.next;
	    }
	    
	    for(current = head; current != null; current = current.next) {
	        first = current.next;
	        
	        count += countPairs(first, last, x-current.data);
	    }
	    return count;
	}
	
  // function to count pairs whose sum equal to given 'value'
	static int countPairs(Node first, Node last, int val) {
	    int count = 0;
	    while(first != last && last.next != first) {
	        
	        if(first.data + last.data == val) {
	          count++;
	          first = first.next;
	          last = last.prev;
	        }
	        
	        else if(first.data + last.data > val) {
	            last = last.prev;
	        }
	        
	        else {
	            first = first.next;
	        }
	        
	    }
	    return count;
	}
