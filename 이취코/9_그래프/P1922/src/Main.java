// 크루스칼 알고리즘

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	
	static int[] p; // 대표자 배열
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 정점 개수
		int M = sc.nextInt(); // 간선 개수
		int[][] edges = new int[M][3]; // [0]:시작,[1]:도착, [2]:비용
		
		for(int i=0;i<M;i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		}
		
		// edges[i][2]를 기준으로 정렬 -> 얘를 어떻게 할건지를 **꼭 기억하자**
		// Comparator 메서드 재정의를 통해서 2차원 배열을 정렬할 수 있음
		Arrays.sort(edges,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		
		// 대표자 배열
		p = new int[N+1];
		for(int i=1;i<N+1;i++) {
			p[i]=i; // 처음은 각 노드의 대표자가 자신
		}
		
		int ans = 0; // 최소비용 저장 위한 변수
		for(int i=0;i<M;i++) {
			// 아까 정렬해놓은 edges배열을 쫙 돌면서 정점연결 시작할거임
			int x = edges[i][0]; // 시작 노드를 x
			int y = edges[i][1]; // 도착 노드를 y라고 하면
			
			// 두 노드의 대표자 노드
			int px = findSet(x);
			int py = findSet(y);
			
			if(px!=py) { // 만약 두 노드의 대표자가 다르다 -> 그러면 대표자 통합하고 비용 더해주기
				union(px,py);
				ans+=edges[i][2];
			}
		}
	
		System.out.println(ans);
	
	}
	// 입력한 노드번호의 대표노드번호를 반환하는 함수
	static int findSet(int x) {
		if(x!=p[x]) { // 만약 내 노드의 대표자가 내가 아니야
			p[x] = findSet(p[x]); // 대표자의 노드를 찾아가
		}
		return p[x];
	}
	// 노드 두개를 합치는 함수
	static void union(int x, int y) {
		// if(p[x]!=p[y]) -> 이 상황은 전제돼있음
		p[y]=x;
	}
	
}
