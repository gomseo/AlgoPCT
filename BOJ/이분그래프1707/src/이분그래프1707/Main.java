package 이분그래프1707;
// 풀이중 - 문제가 이해 안됨
import java.util.*;

public class Main {
	
	static int V;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int[] p;
	static boolean isTrue;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		for(int tc=1;tc<=K;tc++) {
			V = sc.nextInt();
			int E = sc.nextInt();
			
			list = new ArrayList[V+1];
			for(int i=1;i<=V;i++) {
				list[i]=new ArrayList<Integer>();
			}
			
			for(int e=0;e<E;e++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				list[a].add(b);
				list[b].add(a);
			}
			
			// 시작 인덱스 정해주기
			visited = new boolean[V+1];
			int startIdx=0;
			for(int i=1;i<=V;i++) {
				if(list[i].size()==2) {
					visited[i]=true;
					startIdx=i;
					break;
				}
			}
			if(startIdx==0) {
				System.out.println("NO");
				continue;
			}
			
			p = new int[V+1];
			isTrue=true;
			p[list[startIdx].get(0)]=1;
			visited[list[startIdx].get(0)]=true;
			dfs(list[startIdx].get(0),1);
			p[list[startIdx].get(1)]=2;
			visited[list[startIdx].get(1)]=true;
			dfs(list[startIdx].get(1),2);
			if(!isTrue) {
				System.out.println("NO");
				continue;
			}else{
				boolean isAnswer=true;
				for(int i=1;i<=V;i++) {
					if(!visited[i]) {
						System.out.println("NO");
						isAnswer=false;
						break;
					}
				}
				if(isAnswer) {
					System.out.println("YES");
				}
			}					
		}
	}
	static void dfs(int i, int t) {
		for(int j : list[i]) {
			if(!visited[j] && p[j]==0) {
				visited[j]=true;
				p[j]=t;
				dfs(j,t);
			}else if(p[j]!=0&&p[j]!=t) {
				isTrue=false;
				return;
			}
		}
	}
}
