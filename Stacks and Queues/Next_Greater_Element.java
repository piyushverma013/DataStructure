// Input: 
// N = 5
// arr[] [6 8 0 1 3]

// Output:
// 8 -1 1 3 -1
// Explanation:
// In the array, the next larger element to 6 is 8, for 8 there is no larger elements 
// hence it is -1, for 0 it is 1 , for 1 it is 3 and then for 3 there is no larger element on right and hence -1.

class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        long ans[] = new long[n];
        Stack<Long> stack = new Stack<Long>();
        
        for(int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            
            if(stack.isEmpty())
              ans[i] = -1;
            else
              ans[i] = stack.peek();
            
            stack.push(arr[i]);
        }
        return ans;
    } 
}
