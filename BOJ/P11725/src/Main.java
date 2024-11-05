import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		ArrayList<Integer>[] adjList = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			adjList[i]=new ArrayList<Integer>();
		}
		// 인접 행렬-> 메모리 초과, 인접 리스트, 간선 배열
		for(int i=1;i<N;i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			adjList[node1].add(node2);
			adjList[node2].add(node1);
		}
		
		int[] answer = new int[N+1];
		// 1부터 출발
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		q.offer(1); visited[1]=true;

		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int i : adjList[curr]) {
				if(!visited[i]) {
					answer[i]=curr;
					q.offer(i);
					visited[i]=true;
				}
			}
		}
		
		for(int i=2;i<=N;i++) {
			System.out.println(answer[i]);
		}
		
	}
}
