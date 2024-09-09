package 미세먼지안녕17144;

import java.util.Scanner;

public class Main {
	static int R,C,T;
	static int[][] map;
	static int row1,row2;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();
		
		map = new int[R][C];
		
		row1=0;row2=0;
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				map[r][c]=sc.nextInt();
				if(map[r][c]==-1) {
					if(row1==0) row1=r;
					else row2=r;
				}
			}
		}
		
		for(int t=0;t<T;t++) {
			diff();
			clean();
		}
		
		// 출력
		int sum=0;
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				if(map[r][c]>0) {
					sum+=map[r][c];
				}
			}
		}
		System.out.println(sum);
		
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static void diff() {
		int[][] mapclone = new int[R][C];
		for(int i = 0; i < R; i++) {
		    mapclone[i] = map[i].clone();
		}
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				if(map[r][c]>0){
					int diff = map[r][c]/5;
					int cnt=0;
					for(int d=0;d<4;d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						if(nr<0||nr>=R||nc<0||nc>=C||map[nr][nc]==-1) continue;
						mapclone[nr][nc]+=diff;
						cnt++;
					}
					mapclone[r][c]-=diff*cnt;
				}
			}
		}
		map = mapclone;
	}
	
	static void clean() {
		// 공기청정기가 있는 열
		for(int r=row1-1;r>0;r--) {
			map[r][0]=map[r-1][0];
		}
		for(int r=row2+1;r<R-1;r++) {
			map[r][0]=map[r+1][0];
		}
		// <-
		for(int c=0;c<C-1;c++) {
			map[0][c]=map[0][c+1];
			map[R-1][c]=map[R-1][c+1];
		}		
		// 위, 아래
		for(int r=0;r<row1;r++) {
			map[r][C-1]=map[r+1][C-1];
		}
		for(int r=R-1;r>row2;r--) {
			map[r][C-1]=map[r-1][C-1];
		}
		// ->
		for(int c=C-1;c>1;c--) {
			map[row1][c]=map[row1][c-1];
			map[row2][c]=map[row2][c-1];
		}
		map[row1][1]=0;
		map[row2][1]=0;
	}

}
