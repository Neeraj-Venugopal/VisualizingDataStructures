package stacks;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;


/*
 * Implement a stack class with the following functionalities:
 * 1. Push
 * 2. Pop
 * 3. IsEmpty
 * 4. IsFull
 * 5. MinElement
 * 
 * every implementation has to be of constant time - O(1)
 */
public class MyStackUsingArrays {
	
	private int maxSize;
	private int[] myStack;
	private int top;
	private List<Integer>list;
	private int min;
	
	public MyStackUsingArrays(int maxSize){
		this.maxSize = maxSize;
		this.myStack= new int[maxSize];
		this.top = -1;
		list = new LinkedList<Integer>();
		min = Integer.MAX_VALUE;
	}
	
	public void push(int x){
		if(!isStackFull()){
			top++;
			myStack[top] = x;
			if(x < min){
				min = x;
				list.add(x);
			}
			else{
				list.add(min);
			}
		}
		else{
			System.out.println("Stack is full");
		}
	}
	
	public int pop(){
	if(!isStackEmpty()){
		list.remove(top);
		return myStack[top--];
	}	
	else{
		throw new EmptyStackException();//System.out.println("Stack is Empty, no element to pop.");
	}
	}
	
	public int peek(){
		return myStack[top];
	}
	
	public int getMin(){
		if(list != null && !isStackEmpty()){
			return list.get(top);
		}
		else{
			throw new NullPointerException();
		}
	}
	public boolean isStackEmpty(){
	 if(top == -1)
		 return true;
	 else
		 return false;
	}
	
	
	public boolean isStackFull(){
		if(top != maxSize -1)
			return false;
		else
			return true;
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStackUsingArrays stack = new MyStackUsingArrays(10);
		
		stack.push(100);
		stack.push(45);
		stack.push(25);
		stack.push(3);
		stack.push(15);
		stack.push(50);
		stack.push(10);
		
		
		System.out.println("Get pop() value: "+stack.pop());
		System.out.println("Get Min value: "+stack.getMin());
		System.out.println("Peek value: "+stack.peek());
		
		System.out.println("Get pop() value: "+stack.pop());
		System.out.println("Get Min value: "+stack.getMin());
		System.out.println("Peek value: "+stack.peek());
		
		System.out.println("Get pop() value: "+stack.pop());
		System.out.println("Get Min value: "+stack.getMin());
		System.out.println("Peek value: "+stack.peek());
		
		System.out.println("Get pop() value: "+stack.pop());
		System.out.println("Get Min value: "+stack.getMin());
		System.out.println("Peek value: "+stack.peek());
		
	}

}
