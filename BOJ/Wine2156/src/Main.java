import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] glass = new int[N];
		
		for(int i=0;i<N;i++) {
			glass[i] = sc.nextInt();
		}
		
		long[][] dp = new long[N][3];
		dp[0][0] = glass[0];
		if(N==1) {
			System.out.println(glass[0]);
		}else if(N==2) {
			System.out.println(glass[0]+glass[1]);
		}else {
			dp[1] = glass[1]; dp[2] = glass[2];
			for(int i=3;i<N;i++) {
				dp[0][i] = dp[0][i-3]+dp[0][i-2] +
			}
			System.out.println(dp[N-1]);
		}
	}
}
