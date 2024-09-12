package 위상정렬;

import java.util.*;

public class Stack {
	public static String[] Hamburger = {"빵", "토마토", "양상추", "패티"};
	static int V,E;
	static int[][] adjArr; // 인접행렬
	static int[] degree; // 진입차수를 저장할 배열
	static boolean[] visited; // 방문체크
	static Stack<Integer> ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		adjArr = new int[V+1][V+1];
		degree = new int[V+1];
		visited = new boolean[V+1];
		ans = new Stack<>();
		
		for(int i=0;i<E;i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			adjArr[A][B]=1;
			degree[B]++;
		}
		
		for(int i=1;i<V+1;i++) {
			if(degree[i]==0) {
				dfs(i);
			}
		}
		while(!ans.empty()) {
			System.out.println(Hamburger[ans.pop()]);
		}
	}
	
	private static void dfs(int curr) {
		visited[curr] = true; // 방문했다!
		for(int i=1;i<V+1;i++) {
			// 간선이 연결되어 있으면서 방문하지 않았다면
			if(adjArr[curr][i]==1&&!visited[i]) {
				dfs(i);
			}
		}
		ans.push(curr); // 연결되어있는 모든 정점을 다 방문하였어!
	}
	
}
