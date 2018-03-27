package stacks;

public class QueueUsingStacks {

	MyStackUsingArrays stack1 ;
	MyStackUsingArrays stack2;
	
	public QueueUsingStacks() {
		// TODO Auto-generated constructor stub
		stack1 = new MyStackUsingArrays(10);
		stack2 = new MyStackUsingArrays(10);
	}
	
	public void push(int x){
		if(stack2.isStackEmpty()){
			stack2.push(x);			
		}
		else{
			while(!stack2.isStackEmpty()){
				stack1.push(stack2.pop());
			}		
			stack1.push(x);
			
			while(!stack1.isStackEmpty()){
				stack2.push(stack1.pop());
			}
		}
		
	}
	
	public int pop(){
		return stack2.pop();
	}
	
	public int peek(){
		return stack2.peek();
	}
	
	public boolean isEmpty(){
		return stack2.isStackEmpty();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
