import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import org.w3c.dom.Node;

public class Main {
	
	static int N;
	static ArrayList<Integer>[] link;
	static int[] pop;
	
	static boolean[] visited;
	static int[] selected;
	static int stopidx;
	static int answer=Integer.MAX_VALUE;
		
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		// N개의 구역
		N = Integer.parseInt(br.readLine());
		link = new ArrayList[N+1];
		pop = new int[N+1];
		
		visited = new boolean[N+1];
		selected = new int[N+1];
		
		
		// 인구 정보 담기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			pop[i]=Integer.parseInt(st.nextToken());
		}
		
		// 인접노드 정보 담기
		for(int i=1;i<=N;i++) {
			link[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int J = Integer.parseInt(st.nextToken());
			for(int j=0;j<J;j++) {
				link[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		// 모든 노드가 인접하고 있는지 확인
		if(isConnected(1)) {
			// 메인 코드
			bfs(1,0);
			System.out.println(answer);
			
		}else {
			if(!isConnected(stopidx)) {
				System.out.println(-1);
				return;
			}else {
				// stopidx 기준으로 pop1, pop2구하기
				int pop1=0, pop2=0;
				visited = new boolean[N];
				for(int j=1;j<=N;j++) {
					if(visited[j]) {
						pop1+=pop[j];
					}else {
						pop2+=pop[j];
					}
				}
				System.out.println(Math.abs(pop2-pop1));
				return;
			}
		}
				
	}
		
	static boolean isConnected(int i) {
		Queue<Integer> q = new LinkedList<>();		
		visited[i]=true;
		q.add(i);
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int j=0;j<size;j++) {
				int p = q.poll();
				if(!link[p].isEmpty()) {
					for(int k=0;k<link[p].size();k++) {
						if(!visited[link[p].get(k)]&&selected[link[p].get(k)]==0) {
							q.add(link[p].get(k));
							visited[link[p].get(k)]=true;
						}
					}						
				}
			}	
		}
		
		for(int j=1;j<=N;j++) {
			if(!visited[j]) {
				stopidx=j;
				return false;
			}
		}
		return true;
	}
	static void bfs(int i, int cnt) {
		if(cnt==N) {
			visited = new boolean[N+1];
			for(int j=1;j<=N;j++) {
				if(selected[j]==1) {
					visited[j]=true;
				}else {
					stopidx=j;
				}
			}
			if(!isConnected(stopidx)) {
				return;
			}else {
				int pop1=0,pop2=0;
				for(int j=1;j<=N;j++) {
					if(selected[j]==1) {
						pop1+=pop[j];
					}else {
						pop2+=pop[j];
					}
				}
				answer=Math.min(answer, Math.abs(pop2-pop1));
			}
		}
	
		selected[i]=1;
		bfs(i+1,cnt+1);
		selected[i]=0;
		bfs(i+1,cnt);
	}
}