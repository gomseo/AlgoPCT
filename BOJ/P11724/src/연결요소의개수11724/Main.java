package 연결요소의개수11724;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int[][] adjArr;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int M = sc.nextInt();
		
		adjArr = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i=0;i<M;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			adjArr[a][b]=adjArr[b][a]=1;
		}
		
		int cnt=0;
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				dfs(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
	static void dfs(int i) {
		visited[i]=true;
		for(int j=1;j<=N;j++) {
			if(adjArr[i][j]==1 && !visited[j]) {
				dfs(j);
			}
		}
	}
}
