package 아기상어16236;

import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	static int[][] dmap;
	static int shark=2;
	static int[] fishcnt = new int[7];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		dmap = new int[N][N];
		int r=0,c=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==9) {
					r=i; c=j;
				}else if(map[i][j]>0) {
					fishcnt[map[i][j]]++;
				}
			}
		}
		
		
		int min = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]>=1 && map[i][j]<=6) {
					dmap[i][j]=Math.abs(i-r)+Math.abs(j-c);
					min = Math.min(min, dmap[i][j]);
				}
			}
		}
		
		
		
		
		
	}
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static void find() {
		
	}
	static void move(int x, int y) {
		for(int )
	}
	
}
