// Input:
// Stack: 18 19 29 15 16
// Output: 15
// Explanation:
// The minimum element of the stack is 15.
class Min_Element_In_Stack{
  int min = Integer.MAX_VALUE;
	public void push(int a,Stack<Integer> s)
	{

	    if(s.isEmpty()) {
	        min = a;
	        s.push(a);
	    }
	    else {
	        int x = a;
	        if(a < min) {
	            x = 2*a-min;
	            min = a;
	        }
	        s.push(x);
	    }
	}
	
	public int pop(Stack<Integer> s)
        {
            int v = s.peek();
            if(v >= min)
              return s.pop();
            else {
                int y = 2*min-v;
                min = y;
                return s.pop();
            }
	}
	
	public int min(Stack<Integer> s)
        {
           return min;
	}
	
	public boolean isFull(Stack<Integer>s, int n)
        {
           if(s.size() == n)
             return true;
           return false;
	}
	
	public boolean isEmpty(Stack<Integer>s)
        {
           if(s.isEmpty())
             return true;
           return false;
	}
}
