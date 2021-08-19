class MyQueue {
  int front, rear;
	int arr[] = new int[100005];
	int n = arr.length;
	
    MyQueue()
	{
		front=-1;
		rear=-1;
	}
	
	//Function to push an element x in a queue.
	void push(int x)
	{
	    // Your code here
	    if((rear+1) % n == front) {
	      System.out.println("Queue is Full");
        return;
      }
	      
	    else if(isEmpty()) {
	        front = rear = 0;
	    }
	    else {
	        rear = (rear+1) % n;
	    }
	    arr[rear] = x;
	} 

  //Function to pop an element from queue and return that element.
	int pop()
	{
		if(isEmpty()) {
        System.out.println("Queue is Empty");
		    return -1;
		}
		else if(front == rear) {
		    int c = front;
		    front = rear = -1;
		    return arr[c];
		}
		else {
		    int c = front;
		    front = (front+1) % n;
		    return arr[c];
		}
	}
	
	//Function to check if queue is empty.
	boolean isEmpty() {
	    return (front == -1 && rear == -1);
	}
	
	//Function to get the front element.
	int front() {
	    if(isEmpty()) {
	      System.out.println("Queue is Empty");
        return -1;
      }
	    else
	      return arr[front];
	}
	
	//Function to get the rear element.
	int rear() {
	    if(isEmpty()) {
	      System.out.println("Queue is Empty");
        return -1;
      }
	    else
	      return arr[rear];
	}
}
