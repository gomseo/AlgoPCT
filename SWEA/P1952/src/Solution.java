// 수영장

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int[] price = new int[4];
			int[] plan = new int[12];
			for(int i=0;i<4;i++) {
				price[i] = sc.nextInt();
			}
			for(int i=0;i<12;i++) {
				plan[i] = sc.nextInt();
			}
			
			int[] dp = new int[12];
			dp[0] = Math.min(price[0]*plan[0], price[1]);
			dp[1] = Math.min(price[0]*plan[1], price[1]) + dp[0];
			dp[2] = Math.min(price[0]*plan[2], price[1]) + dp[1];
			dp[2] = Math.min(dp[2], price[2]);
			for(int i=3;i<12;i++) {
				dp[i] = Math.min(plan[i]*price[0], price[1]) + dp[i-1];
				dp[i] = Math.min(dp[i], price[2]+dp[i-3]);
			}
			
			if(dp[11]<price[3]) {
				System.out.println("#"+t+" "+dp[11]);
			}else {
				System.out.println("#"+t+" "+price[3]);
			}
			
		}
	}
}
