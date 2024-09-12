import java.util.*;

public class Main {
	
	static int N,M,V;
	static boolean[] visited;
	static int[][] adjArr;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		adjArr = new int[N+1][N+1];
		for(int i=0;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adjArr[a][b]=adjArr[b][a]=1;
		}
		
		visited = new boolean[N+1];
		visited[V]=true;
		sb = new StringBuilder();
		sb.append(V);
		dfs(V);
		System.out.println(sb);

		visited = new boolean[N+1];
		visited[V]=true;
		sb = new StringBuilder();
		sb.append(V);
		bfs(V);
		System.out.println(sb);
	}
	static void dfs(int v) {
		for(int i=1;i<=N;i++) {
			if(adjArr[v][i]==1 && !visited[i]) {
				visited[i]=true;
				sb.append(" "+i);
				dfs(i);
			}
		}
	}
	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int i=1;i<=N;i++) {
				if(adjArr[curr][i]==1 && !visited[i]) {
					visited[i]=true;
					sb.append(" "+i);
					q.offer(i);
				}
			}
		}
	}
	
	
}
