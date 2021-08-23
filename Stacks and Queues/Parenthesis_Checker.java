// Input 1:
// {([])}
// Output: true
// Explanation: 
// { ( [ ] ) }. Same colored brackets can form balaced pairs, with 0 number of unbalanced bracket.
  
// Input 2: 
// ([]
// Output: false
// Explanation: 
// ([]. Here square bracket is balanced but the small bracket is not balanced and Hence, the output will be unbalanced.
// Time Complexity: O(n) 
// Auxiliary Space: O(n) for stack. 

static boolean ispar(String x)
    {
        // add your code here
        if(x.length() == 0)
          return false;
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < x.length(); i++) {
            char ch = x.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
              stack.push(ch);
            }
            else {
                if(stack.isEmpty())
                  return false;
                char p = stack.pop();
                if(ch == ')' && p != '(')  return false;
                else if(ch == ']' && p != '[')  return false;
                else if(ch == '}' && p != '{')  return false;
            }
        }
        return stack.isEmpty();
    }
