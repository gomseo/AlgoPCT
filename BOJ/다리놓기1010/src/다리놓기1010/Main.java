package 다리놓기1010;

import java.util.Scanner;

public class Main {
	
	static int N,M;
	static int ans;
	static boolean visited[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			// MCN
			visited =new boolean[M];
			ans=0;
			comb(0,0);
			
			System.out.println(ans);
			
		}
	}
	static void comb(int i,int n) {
		if(n==N) {
			ans++;
			return;
		}
		if(i==M||M-i<N-n) { // 남은 개수(M-i-1)가 뽑아야하는 개수(N-n)보다 작을때
			return;
		}
		
		visited[i]=true;
		comb(i+1,n+1);
		visited[i]=false;
		comb(i+1,n);
	}
}
