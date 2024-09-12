package 암호코드2011;
// 풀이중
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] arr = sc.nextLine().split("");
		
		// 1~26까지의 숫자
		if(arr.length==1) {
			int ans = Integer.parseInt(arr[0])!=0?1:0;
			System.out.println(ans);
		}else if(arr.length==2) {
			if(Integer.parseInt(arr[1])!=0 
					&& Integer.parseInt(arr[0]+arr[1])<27  
					&& Integer.parseInt(arr[0]+arr[1])>0) {
				System.out.println(2);
			}else if(Integer.parseInt(arr[0])!=0&&Integer.parseInt(arr[1])!=0){
				System.out.println(1);
			}else if(Integer.parseInt(arr[0]+arr[1])==10 || Integer.parseInt(arr[0]+arr[1])==20){
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}else {
			long[] dp = new long[arr.length];
			dp[0] = Integer.parseInt(arr[0])!=0?1:0;
			if(Integer.parseInt(arr[0]+arr[1])<27 
					&& Integer.parseInt(arr[0]+arr[1])>0) {
				dp[1]=2;
			}else if(Integer.parseInt(arr[0])>=1&&Integer.parseInt(arr[1])>=1){
				dp[1]=1;
			}else {
				dp[1]=0;
			}
			for(int i=2;i<arr.length;i++) {
				if(Integer.parseInt(arr[i])==0&& 
						Integer.parseInt(arr[i-1]+arr[i])<27 &&
						Integer.parseInt(arr[i-1]+arr[i])>0) {
					dp[i]=dp[i-2];
				}else if(Integer.parseInt(arr[i])!=0 && 
						Integer.parseInt(arr[i-1]+arr[i])<27 &&
						Integer.parseInt(arr[i-1]+arr[i])>0) {
					dp[i]=dp[i-2]+dp[i-1];
				}else if(Integer.parseInt(arr[i])!=0){
					dp[i]=dp[i-2];
				}else {
					dp[i]=0;
				}
			}
			
			System.out.println(dp[arr.length-1]%100000);
		
		}
		
	}
}
