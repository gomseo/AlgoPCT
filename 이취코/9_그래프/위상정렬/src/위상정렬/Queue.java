package 위상정렬;

import java.util.*;

public class Queue {
	public static String[] Hamburger = {"빵", "토마토", "양상추", "패티"};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt(); // vertex, 정점의 개수
		int E = sc.nextInt(); // edge, 간선의 개수
		
		int[][] adjArr = new int[V+1][V+1]; // 가중치 배열
		int[] degree = new int[V+1]; // 진입 차수를 저장할 배열
		
		for(int i=0;i<E;i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			adjArr[A][B] = 1; //가중치는 따로 없으니까 1로 표기
			degree[B]++; // 진입 차수를 증가!
		}
		
		// 위상정렬 큐 1장 : 진입차수가 0인 친구들을 몽땅 넣어라
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1;i<V+1;i++) {
			if(degree[i]==0) {
				queue.add(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		// 위상정렬 큐 2장 : 큐가 공백상태가 될때까지 간선을 제거하고,
		// 진입차수가 0이되면 새롭게 큐에 넣는다.
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			sb.append(Hamburger[curr]).append("/n");
			
			for(int i=1;i<V+1;i++) {
				// 방향X -> 인덱스의 순서가 중요치 않은데
				// 방향O -> 인덱스의 순서가 중요하다
				if(adjArr[curr][i]==1) {
					degree[i]--; // 진입차수 하나 깎아.
					adjArr[curr][i]=0;
					// 만약 이번에 i 정점의 진입차수가 0이 되었다면
					if(degree[i]==0) {
						queue.add(i);
					}
				}
			}
		}
		
		System.out.println(sb);

	}

}
