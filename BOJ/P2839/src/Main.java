import java.util.Scanner;

public class Main {
	// 시간초과
	
	static int ans=Integer.MAX_VALUE;
	static boolean canMake;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		dfs(N,0);
		
		if(!canMake) {
			System.out.println(-1);
		}else {
			System.out.println(ans);			
		}
		
	}
	static void dfs(int n, int cnt) {
		if(cnt>ans||n<0) {
			return;
		}
		if(n==0) {
			canMake=true;
			ans = Math.min(ans, cnt);
			return;
		}
		dfs(n-5,cnt+1);
		dfs(n-3,cnt+1);
		
	}
}