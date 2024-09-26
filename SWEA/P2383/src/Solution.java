import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
	
	static int N, p, ans;
	static int[][] map;
	static int[] pick, distance;
	
	static ArrayList<int[]> stair;
	static ArrayList<int[]> people;
	static ArrayList<Integer>[] waiting;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			N = sc.nextInt();
			map = new int[N][N];
			stair = new ArrayList<>();
			
			p=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j]=sc.nextInt();
					if(map[i][j]==1) {
						people.add(new int[] {i,j});
						p++;
					}
					if(map[i][j]>1) {
						stair.add(new int[] {i,j});
					}
				}
			}
			// index가 사람 번호
			pick = new int[p];
			distance = new int[p];
			
			ans = 0;
			dfs(0);
			
			waiting = new ArrayList[2];
			for(int i=0;i<2;i++) {
				waiting[i] = new ArrayList<Integer>();
			}
			
			
			
			
		}
	}
	static void dfs(int i) {
		// 0번, 1번 계단 중에 선택
		if(i==p) {
			cal();
		}
		dfs(i+1);
		pick[i] = 1;
		dfs(i+1);
	}
	static void cal() {
		for(int i=0;i<p;i++) {
			distance[i] = Math.abs(stair.get(pick[i])[0]-people.get(i)[0])+Math.abs(stair.get(pick[i])[1]-people.get(i)[1]);
		}
		
		while(!distance.equals(new int[p])) {
			// 시간 1초씩 흐름
			for(int i=0;i<p;i++) {
				if(distance[i]>0) distance[i]--;
				if(distance[i]==0 && waiting[pick[i]].size()<3) {
					waiting[pick[i]].add(3);
					distance[i]--;
				}
				
				for(int j=0;j<2;j++) {
					int size = waiting[j].size();
					for(int k=0;k<size;k++) {
						waiting[j].set(i, null)
					}
					
				}
				
			}
			
			
			
		}
		
	}
	static void managedeque() {
		if(waiting.get(0).size())
	}
}
