import java.util.Scanner;
// 풀이중
public class Solution {
	
	static int N, M;
	static int[][] map;
	static boolean[][] mapbool;
	static boolean[][] processer;
	
	static int cnt, L;
	static int lastcnt, ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1;t<=T;t++) {
			N = sc.nextInt();
			map = new int[N][N];
			mapbool = new boolean[N][N];
			processer = new boolean[N][N];
			
			M=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j]==1) {
						mapbool[i][j]=true;
						if(i!=0||i!=N-1||j!=0||j!=N-1) M++;
					}
				}
			}
			cnt=0;
			L=0;
			lastcnt=0;
			ans=Integer.MAX_VALUE;
			dfs(0);
			
			System.out.println(ans);
			
		}
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static void dfs(int m) {
		if(m==M) {
			if(cnt>=lastcnt) {
				lastcnt=cnt;
				ans = Math.min(ans, L);
			}
			return;
		}
		
		for(int r=1;r<N-1;r++) {
			for(int c=1;c<N-1;c++) {
				if(map[r][c]==1 && !processer[r][c]) {
					processer[r][c]=true;
					m++;
					for(int d=0;d<4;d++) {
						if(check(r,c,d)) {
							cnt++;
							L+=length(r,c,d);
							dfs(m);
							while(r+dr[d]>=0&&r+dr[d]<N&&c+dc[d]>=0&&c+dc[d]<N) {
								mapbool[r+dr[d]][c+dc[d]]=false;
								r+=dr[d]; c+=dc[d];
							}
							cnt--;
							L-=length(r,c,d);
						}
					}
					m--;
					processer[r][c]=false;
				}
			}
		}
		
	}
	
	static int length(int i, int j, int d) {
		if(d==0) return j;
		else if(d==1) return N-1-j;
		else if(d==2) return i;
		return N-1-i;
	}
	
	static boolean check(int i, int j, int d) {
		while(i+dr[d]>=0&&i+dr[d]<N&&j+dc[d]>=0&&j+dc[d]<N) {
			if (mapbool[i+dr[d]][j+dc[d]]) return false;
			i+=dr[d]; j+=dc[d];
		}
		while(i+dr[d]>=0&&i+dr[d]<N&&j+dc[d]>=0&&j+dc[d]<N) {
			mapbool[i+dr[d]][j+dc[d]]=true;
			i+=dr[d]; j+=dc[d];
		}
		
		return true;
	}
}
