import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.w3c.dom.Node;

public class Main {
	
	static int N;
	static boolean[] visited;
		
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		// N개의 구역
		int N = Integer.parseInt(br.readLine());
		int[][] link = new int[N][];
		int[] pop = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			pop[i]=Integer.parseInt(st.nextToken());
		}
		
		// 인접노드 정보 담기
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<Integer.parseInt(st.nextToken());j++) {
				link[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		// 인접노드
		
	}
		
	static void visited(int[][] node,int i) {
		visited = new boolean[N];
		
		visited[i]=true;
		
		for(int n : node[i]) {
			if(!visited[i]) {
				visited(node, i);
			}else {
				return;
			}
		}
		
	}

}