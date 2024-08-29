import java.util.*;

public class Solution {
	
	static int[][] maze;
	static boolean answer;
	
	// 4방 탐색
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1;t<=10;t++) {
			int T = Integer.parseInt(sc.nextLine());
			maze = new int[16][16];
			
			for(int r=0;r<16;r++) {
				String str = sc.nextLine();
				for(int c=0;c<16;c++) {
					maze[r][c]=str.charAt(c)-'0';
				}
			}
			answer = false;
			
			dfs(1,1);
			if(answer) {
				System.out.println("#"+T+" 1");
			}else {
				System.out.println("#"+T+" 0");
			}
			
			
		
		}
	}
	
	static void dfs(int r, int c) {
		if(maze[r][c]==3) {
			answer=true;
			return;
		}else {
			maze[r][c]=-1; // 갔음 체크
		}
		Queue<Integer> dir = bfs(r,c); // 현재위치에서 갈 방향 탐색
		if(dir.isEmpty()) { // 막다른 길이면 그냥 return
			return;				
		}else { // 갈 방향이 있으면 그 방향으로 탐색
			int nr=r, nc=c;
			while(!dir.isEmpty()) {
				int i = dir.poll();
				nr+=dr[i]; nc+=dc[i];
				dfs(nr,nc);
				nr-=dr[i]; nc-=dc[i]; //백트래킹
			}
			
		}
	}
	static Queue<Integer> bfs(int r, int c) {
		Queue<Integer> cnt = new LinkedList<>();
		for(int i=0;i<4;i++) {
			if(maze[r+dr[i]][c+dc[i]]==0||maze[r+dr[i]][c+dc[i]]==3) {
				cnt.add(i);
			}
		}
		return cnt;
		
	}
}
