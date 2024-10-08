import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String str = sc.next();
			for(int j=0;j<M;j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}
		
		ans=Integer.MAX_VALUE;
		visited[0][0]=true;
		bfs(0,0);
		
		System.out.println(ans);
		
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
//	static void dfs(int i, int j, int cnt) {
//		if(cnt>=ans) return;
//		if(i==N-1&&j==M-1) {
//			ans = Math.min(ans, cnt);
//			return;
//		}
//		for(int d=0;d<4;d++) {
//			int nr = i + dr[d];
//			int nc = j + dc[d];
//			
//			if(nr<0||nr>=N||nc<0||nc>=M) continue;
//			
//			if(map[nr][nc]==1&&!visited[nr][nc]) {
//				visited[nr][nc]=true;
//				dfs(nr, nc, cnt+1);
//				visited[nr][nc]=false;
//			}
//		}
//	}
	static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		int cnt=-1;
		q.offer(new int[] {i,j});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			if(curr[0]==N-1&&curr[1]==M-1) {
				ans=cnt;
			}
			for(int d=0;d<4;d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				
				if(nr<0||nr>=N||nc<0||nc>=M) continue;
				
				if(map[nr][nc]==1&&!visited[nr][nc]) {
					visited[nr][nc]=true;
					q.offer(new int[] {nr,nc});
					cnt++;
				}
			}
		}
	}
}
