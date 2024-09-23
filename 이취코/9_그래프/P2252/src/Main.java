// 위상정렬

import java.util.*;

public class Main {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		List<Integer>[] graph = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		int[] degree = new int[N+1];
		
		// 간선 정보 입력 및 진입 차수 계산
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			graph[from].add(to);
			degree[to]++;
		}
		
		// Queue~!
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			if(degree[i]==0)q.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			int curr = q.poll();
			sb.append(curr).append(" ");
			// 현재 노드와 연결된 노드들의 진입 차수 감소
			for (int next : graph[curr]) {
				degree[next]--;
				if (degree[next] == 0) {
					q.offer(next);
				}
			}
		}
		
		System.out.println(sb);
		
	}
}
