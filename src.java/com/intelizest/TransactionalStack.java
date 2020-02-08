package com.intelizest;

import java.util.Stack;

public class TransactionalStack {

	private Stack<Integer> elements;
	private Stack<TransactionalStack> transactions;

	public TransactionalStack() {
		this(false);
	}

	private TransactionalStack(boolean internal) {
		elements = new Stack<Integer>();
		if (!internal) {
			transactions = new Stack<TransactionalStack>();
			transactions.push(this);
		}
	}

	public void push(int value) {
		transactions.peek().elements.push(value);
	}

	public int top() {
		Stack<Integer> contents = transactions.peek().elements;
		return contents.empty() ? 0 : contents.peek();
	}

	public void pop() {
		Stack<Integer> contents = transactions.peek().elements;
		if (!contents.empty()) {
			contents.pop();
		}
	}

	public void begin() {
		TransactionalStack newTransaction = new TransactionalStack();
		newTransaction.elements = (Stack<Integer>) elements.clone();
		transactions.add(newTransaction);
	}

	public boolean rollback() {
		TransactionalStack lastTransaction = transactions.peek();
		if (lastTransaction != this) {
			transactions.pop();
			return true;
		}
		return false;
	}

	public boolean commit() {
		TransactionalStack lastTransaction = transactions.peek();
		if (lastTransaction != this) {
			lastTransaction = transactions.pop();
			transactions.peek().elements = lastTransaction.elements;
			return true;
		}
		return false;
	}

	public static void main(String[] as) {
		TransactionalStack sol = new TransactionalStack();
		sol.push(4);
		sol.begin(); // start transaction 1
		sol.push(7); // stack: [4,7]
		sol.begin(); // start transaction 2
		sol.push(2); // stack: [4,7,2]
		System.out.println(sol.rollback());// == true; // rollback transaction 2
		System.out.println(sol.top());// == 7; // stack: [4,7]
		sol.begin(); // start transaction 3
		sol.push(10); // stack: [4,7,10]
		System.out.println(sol.commit());// == true; // transaction 3 is committed
		System.out.println(sol.top()); // == 10;
		System.out.println(sol.rollback());// == true; // rollback transaction 1
		System.out.println(sol.top());// == 4; // stack: [4]
		System.out.println(sol.commit());// == false; // there is no open transaction
	}
}