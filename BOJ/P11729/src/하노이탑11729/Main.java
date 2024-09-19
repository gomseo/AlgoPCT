package 하노이탑11729;

import java.util.*;

public class Main {
	
	static Stack<Integer> stack1 = new Stack();
	static Stack<Integer> stack2 = new Stack();
	static Stack<Integer> stack3 = new Stack();
	
	static int cnt=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		for(int i=N;i>0;i--) {
			stack1.add(i);
		}
		
		// stack1을 비우기
		// stack3을 비우고 에 N부터 담기
		for(int i=1;i<=N;i++) {
			
		}
		
	}
	static void cal() {
		
		
		
	}
	static boolean move(Stack<Integer> stack1, Stack<Integer> stack2) {
		// stack1 -> stack2
		if(stack2.isEmpty()) {
			stack2.add(stack1.pop());
			return true;
		}else if(stack2.peek()>stack1.peek()){
			stack2.add(stack1.pop());
			return true;
		}
		return false;
	}
}
