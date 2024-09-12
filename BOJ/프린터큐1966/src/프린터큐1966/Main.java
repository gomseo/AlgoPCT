package 프린터큐1966;

import java.util.*;

public class Main {
	
	static int[] count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int N = sc.nextInt();
			int M = sc.nextInt(); // idx
			
			count = new int[10];
			Queue<Integer> q = new LinkedList<>();
			HashMap<Integer,Integer> map = new HashMap<>();
			for(int i=0;i<N;i++) {
				int tmp = sc.nextInt();
				count[tmp]++;
				map.put(i, tmp);
				q.offer(i); 
			}

			int sumcount=0;
			while(!q.isEmpty()) {
				int p = map.get(q.peek()); // p = 중요도
				if(check(p)&&q.peek()==M) {
					// 나보다 중요도가 나중인게 없으면 뽑고 sumcount++
					sumcount++;break;
				}else if(check(p)){
					sumcount++;
					count[p]--;
					q.poll(); 
				}else {
					// 나보다 중요도가 나중인게 있다 -> 큐에 다시 넣기
					q.offer(q.poll());
				}
			}
			
			System.out.println(sumcount);
			
		}
	}
	static boolean check(int p) {
		for(int i=p+1;i<10;i++) {
			if(count[i]>0) return false;
		}
		return true;
	}
}
