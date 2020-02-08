package com.intelizest;

import java.util.Stack;

class Brackets2 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(solution("{}()[]"));
	}
	
    public static boolean solution(String input) {
       

		// Create the stack to store characters from input string
		Stack<Character> stack = new Stack<>();

		char c; // Character in the string

		/**
		 *  Iterate over the string to check for each character.
		 *  Push for opening brackets.
		 *  If its a closing bracket, 
		 *   - If stack is empty, matching closing bracket not found, return false.
		 *   - Pop if found matching bracket
		 *   - else, Matching closing bracket not found, return false
		 */
		for (int i = 0; i < input.length(); i++) {
			c = input.charAt(i);

			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.empty()) {
					return false;
				} else if (stack.peek() == '(') {
					stack.pop();
				} else {
					return false;
				}
			} else if (c == '}') {
				if (stack.empty()) {
					return false;
				} else if (stack.peek() == '{') {
					stack.pop();
				} else {
					return false;
				}
			} else if (c == ']') {
				if (stack.empty()) {
					return false;
				} else if (stack.peek() == '[') {
					stack.pop();
				} else {
					return false;
				}
			}
		}
        
        //If stack is empty, all parenthesis are balanced, return true, otherwise return false
		return stack.empty();
	
    }
}

