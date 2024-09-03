import java.util.Scanner;
// 이해 필요
public class Main {
	// DP - top down
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] stair = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			stair[i]=sc.nextInt();
		}
		
		// 계단이 1개인 경우
		if (N == 1) {
			System.out.println(stair[1]);
			return;
		}

		// dp 배열 초기화
		int[] dp = new int[N+1];
		dp[1] = stair[1];
		dp[2] = stair[1] + stair[2];
		
		// 점화식을 통해 dp 배열 채우기
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3] + stair[i-1]) + stair[i];
		}
		
		System.out.println(dp[N]);
	}
}

//public class Main {
//	// DP - top down
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		int N = sc.nextInt();
//		int[] stair = new int[N+1];
//		
//		for(int i=1;i<=N;i++) {
//			stair[i]=sc.nextInt();
//		}
//		
//		int[][] dp = new int[2][N+1];
//		dp[0][N]=stair[N];
//		dp[1][N]=stair[N];
//		
//		if(N>2) {
//			dp[0][N-1] = dp[0][N]+stair[N-1];
//			dp[0][N-2] = dp[0][N]+stair[N-1];
//			dp[1][N-1] = dp[1][N]+stair[N-2];
//			dp[1][N-2] = dp[1][N]+stair[N-2];
//			int a=2, b=1;
//			for(int i=N-3;i>0;i--) {
//				dp[0][i]=dp[0][i+a]+stair[i];
//				dp[1][i]=dp[1][i+b]+stair[i];
//				// switch i+2, i+1
//				int temp = a;
//				a = b;
//				b = temp;
//			}
//			System.out.println(Math.max(dp[0][1], dp[1][1]));	
//		}else if(N==2) {
//			System.out.println(stair[1]+stair[2]);
//		}else {
//			System.out.println(stair[1]);
//		}
//			
//	}
//}
