import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static boolean[] num;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			String D = sc.next();
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			num = new boolean[B+1];
			num[0]=true; num[1]=true;
			
			// 에라토스테네스의 체
			// 소수를 false로 남기기
			for(int i=2;i<=Math.sqrt(B);i++) {
				for(int j=2;j<i;j++) {
					if(i%j==0) {
						num[i]=true;
						break;
					}
				}
			}
			for(int i=2;i<=Math.sqrt(B);i++) {
				if(!num[i]) { // 소수면
					int j=2;
					while(i*j<=B) { // B값까지의 소수 배수를 모두 true로
						num[i*j]=true;
						j++;
					}
				}
			}
			
			int cnt=0;
			for(int i=A;i<=B;i++) {
				if(!num[i]&&String.valueOf(i).contains(D)) {
					cnt++;
				}
			}
			
			System.out.println("#"+t+" "+cnt);
			
		}
	}
}
