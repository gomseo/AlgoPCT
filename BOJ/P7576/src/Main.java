import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[][] box = new int[N][M];
		boolean[][] ripe = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				box[i][j]=sc.nextInt();
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		// 1.box를 돌면서 1위치를 다 찾아서 queue에 넣고,
		// 1위치는 다 true로 바꾸기
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(box[i][j]==1) {
					q.offer(new int[] {i,j});
					ripe[i][j]=true;
				}else if(box[i][j]==-1) {
					ripe[i][j]=true;
				}else if(box[i][j]==0) {
					cnt++;
				}
			}
		}
		// 이때 익은 토마토밖에 없다 -> 0출력
		if(cnt==0 && !q.isEmpty()) {
			System.out.println(0);
			return;
		}
		
		// 2. q에서 다 꺼내서 상하좌우 확인 후 토마토가 있고 ripe->false면 q에 넣고 방문처리
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};

		int ans=-1;
		while(!q.isEmpty()) {
			int size = q.size();
			ans++;
			for(int i=0;i<size;i++) {
				int[] curr = q.poll();
				int r = curr[0];
				int c = curr[1];
				for(int d=0;d<4;d++) {
					int nr = r+dr[d];
					int nc = c+dc[d];
					if(nr<0||nr>=N||nc<0||nc>=M) continue;
					if(box[nr][nc]==0&&!ripe[nr][nc]) {
						q.offer(new int[] {nr,nc});
						ripe[nr][nc]=true;
					}
				}				
			}
		}
		
		// 3. 다 끝나고 나서 모든 상자가 true인지 확인
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!ripe[i][j]) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(ans);
		
	}
}
