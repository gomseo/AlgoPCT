//P1197, MST

import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int V, W;
		public Node(int V, int W) {
			this.V=V;
			this.W=W;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.W, o.W);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int E = sc.nextInt();
		
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		List<Node>[] list = new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			list[i] = new ArrayList<>();
		}			
		for(int i=0;i<E;i++) {
			list[sc.nextInt()].add(new Node(sc.nextInt(),sc.nextInt()));
		}		
		
		// dijkstra - 우선순위 큐 이용		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		pq.add(new Node(1,0));
		dist[1]=0;
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			if(visited[curr.V]) continue;
			visited[curr.V]=true;
			
			for(Node node : list[curr.V]) {
				if(!visited[node.V]&&dist[node.V]>dist[curr.V]+node.W) {
					dist[node.V] = dist[curr.V]+node.W;
					pq.add(new Node(node.V, dist[node.V]));
				}
			}
		}
		
		int ans=0;
		for(int i=1;i<=N;i++) {
			ans=Math.max(ans, dist[i]);
		}
		System.out.println(ans);
		
	}
}

