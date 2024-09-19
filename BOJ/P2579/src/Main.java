import java.util.Scanner;
// 다시 풀기
public class Main {
	// DP - top down
	// 반례 ) 답 12
//	4
//	1 10 10 1
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long[] stair = new long[N+1];
		
		for(int i=1;i<=N;i++) {
			stair[i]=sc.nextInt();
		}
		
		// 계단이 1개인 경우
		if (N == 1) {
			System.out.println(stair[1]);
			return;
		}else if(N==2) {
			System.out.println(stair[1]+stair[2]);
		}else {
			// dp 배열 초기화
			long[] dp = new long[N+1];
			dp[N] = stair[N];
			dp[N-1] = stair[N] + stair[N-1];
			dp[N-2] = Math.max(stair[N-2]+stair[N], stair[N-2]+stair[N-1]);
			// 점화식을 통해 dp 배열 채우기
			for (int i=N-3; i>=0; i--) {
				dp[i] = Math.max(dp[i+2], dp[i+3] + stair[i+1]) + stair[i];
				dp[i] = Math.max(dp[i], dp[i+1]);
			}
			
			System.out.println(dp[0]);
			
		}

	}
}


