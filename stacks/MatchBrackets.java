package stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MatchBrackets {

	public static boolean areBracketsMatching(String str){		
		Map<Character,Character>bracketMap = new HashMap<Character, Character>();
		bracketMap.put('(', ')');
		bracketMap.put('[', ']');
		bracketMap.put('{', '}');

		
		Stack<Character> myStack = new Stack<Character>();
		
		if(str.length() % 2 !=0){
			return false;
		}
		for(int i=0; i< str.length(); i++){
			
			if(bracketMap.containsKey(str.charAt(i))){
				myStack.push(str.charAt(i));
			}
			else if(!myStack.isEmpty() && str.charAt(i) == bracketMap.get(myStack.peek())){
				myStack.pop();			
			}		
			else{
				return false;
			}
		}			
		return myStack.isEmpty();
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String brackets= "(()){()}";
		System.out.println(areBracketsMatching(brackets));
		
		String brackets2 = "(({))()}";
		System.out.println(areBracketsMatching(brackets2));
		
	}

}
