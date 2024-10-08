import java.util.*;

public class Main {
	
	static int w,h;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			w = sc.nextInt();
			h = sc.nextInt();
			
			if(w==0&&h==0) return;
			
			map = new int[h][w];
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			// 섬의 개수 bfs로 세기
			int ans=0;
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(map[i][j]==1) {
						bfs(i,j);
						ans++;
					}
				}
			}
			
			System.out.println(ans);
			
		}
	}
	
	// 방향 -> 시계방향
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	
	static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i,j});
		map[i][j]=0;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int d=0;d<8;d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				
				if(nr<0||nr>=h||nc<0||nc>=w) continue;
				
				if(map[nr][nc]==1) {
					q.offer(new int[] {nr,nc});
					map[nr][nc]=0;
				}
			}
		}
	}
}
