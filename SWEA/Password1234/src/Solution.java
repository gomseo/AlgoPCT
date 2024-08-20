import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1;t<=10;t++) {
			int N = sc.nextInt();
			String str = sc.next();
			
			Deque<Character> deque = new ArrayDeque<>();
			for(int i=0;i<str.length();i++) {
				if(deque.isEmpty()) {
					deque.offer(str.charAt(i));					
				}else {
					if(deque.peekLast()==str.charAt(i)) {
						deque.pollLast();
					}else {
						deque.offer(str.charAt(i));
					}
				}
			}
			
			// 출력
			StringBuilder sb = new StringBuilder();
			while(!deque.isEmpty()) {
				sb.append(deque.pollFirst());
			}
			System.out.println("#"+t+" "+sb);
		}
	}

}
