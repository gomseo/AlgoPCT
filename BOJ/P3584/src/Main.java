import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int N = sc.nextInt();
			int[] parent = new int[N+1];
			boolean[] visited = new boolean[N+1];
			
			for(int i=0;i<N-1;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				// b노드의 부모가 a
				parent[b]=a;
			}
			
			// 공통조상인거 구해야 될 노드 1, 2
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			
			// 첫 번째 노드의 조상을 따라 올라가면서 방문 처리
            while (node1 != 0) { // 루트까지 올라감
                visited[node1] = true;
                node1 = parent[node1];
            }
            
            // 두 번째 노드의 조상을 따라 올라가면서 공통 조상 찾기
            int answer = 0;
            while (node2 != 0) {
                if (visited[node2]) {  // 이미 방문한 노드 발견
                    answer = node2;
                    break;
                }
                node2 = parent[node2];
            }
            
            System.out.println(answer);
		}
	}
}
