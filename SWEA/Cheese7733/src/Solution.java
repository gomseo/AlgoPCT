import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static int N, ans;
	static int[][] cheese;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			N = sc.nextInt();
			
			cheese = new int[N][N];
			int maxday=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					cheese[i][j]=sc.nextInt();
					maxday = Math.max(maxday, cheese[i][j]);
				}
			}
			
			// 1~100일
			ans = 0;
			for(int day=1;day<=maxday;day++) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(cheese[i][j]==day) cheese[i][j]=0;
					}
				}
				check();
			}
			
			System.out.println("#"+t+" "+ans);
	
		}
	}
	
	// 상하좌우
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static void check() {
		int[][] cheesecopy = new int[N][N];
		for(int i=0;i<N;i++) {
			cheesecopy[i]=cheese[i].clone();
		}
		
		Queue<int[]> q = new LinkedList<>();
		int cnt=0;
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(cheesecopy[r][c]!=0) {
					cheesecopy[r][c]=0;
					q.offer(new int[] {r,c});
					while(!q.isEmpty()) {
						int[] rc = q.poll();
						int nr = rc[0];
						int nc = rc[1];
						for(int d=0;d<4;d++) {
							if(nr+dr[d]>=N||nr+dr[d]<0||nc+dc[d]>=N||nc+dc[d]<0) {
								// 범위 초과 시 continue
								continue;
							}else {
								int nnr = nr+dr[d];
								int nnc = nc+dc[d];
								if(cheesecopy[nnr][nnc]!=0) {
									cheesecopy[nnr][nnc]=0;
									q.add(new int[] {nnr,nnc});
								}
							}
						}	
					}
					cnt++;
				}
			}
		}
		ans = Math.max(ans, cnt);
		
	}	
}
