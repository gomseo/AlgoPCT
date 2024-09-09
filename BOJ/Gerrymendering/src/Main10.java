import java.util.*;

public class Main10 {
	static int N;
	static int[] pop;
	static ArrayList<Integer>[] link;
	static boolean[] team;
	static int ans=Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		pop = new int[N+1];
		for(int i=1;i<=N;i++) {
			pop[i]=sc.nextInt();
		}
		
		link = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			link[i]=new ArrayList<Integer>();
			int J = sc.nextInt();
			for(int j=0;j<J;j++) {
				link[i].add(sc.nextInt());
			}
		}
		
		// 구역 나누기
		team = new boolean[N+1];
		team(1);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
		
	}
	static void team(int idx) {
		if(idx==N+1) {
			if(check()) {
				if(connected()) {
					int sum1=0, sum2=0;
					for(int i=1;i<=N;i++) {
						if(team[i]) sum1+=pop[i];
						else sum2+=pop[i];
					}
					ans = Math.min(ans, Math.abs(sum2-sum1));
				}
			}
			return;
		}
		
		team[idx]=true;
		team(idx+1);
		team[idx]=false;
		team(idx+1);
	}
	static boolean check() {
		int cnt1=0,cnt2=0;
		for(int i=1;i<=N;i++) {
			if(team[i]) cnt1++;
			else cnt2++;
		}
		return (cnt1>0 && cnt2>0);
	}
	static boolean connected() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		int start1 = 1, start2=0;
		for (int i = 1; i <= N; i++) {
			if (team[i]!=team[1]) {
				start2 = i;
				break;
			}
		}
				
		q.offer(start1);
		visited[start1]=true;
		while (!q.isEmpty()) {
	        int curr = q.poll();
	        for (int next : link[curr]) {
	            if (!visited[next] && team[next] == team[start1]) {
	                visited[next] = true;
	                q.offer(next);
	            }
	        }
	    }
				
		q.offer(start2);
		visited[start2]=true;
		while (!q.isEmpty()) {
	        int curr = q.poll();
	        for (int next : link[curr]) {
	            if (!visited[next] && team[next] == team[start2]) {
	                visited[next] = true;
	                q.offer(next);
	            }
	        }
	    }
		
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				return false;
			}
		}
		return true;
	}
}
