import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] dp = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			int cnt=0;
			for(int j=1;j<=i;j++) {
				if(i%j==0) cnt++;
			}
			dp[i]=(cnt+1)/2;
		}
		
		int ans=0;
		for(int i=1;i<=N;i++) {
			ans+=dp[i];
		}
		
		System.out.println(ans);
	}
}
