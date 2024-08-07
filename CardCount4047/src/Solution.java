import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int t=1;t<=T;t++) {
			String str = sc.nextLine();
			char[] arr = str.toCharArray();
			
			int n = arr.length/3;
			
			// 초기화
			boolean[] cards = new boolean[53];
			int card=0;
			boolean isBreak = false;
			for(int i=0;i<n;i++) {
				switch(arr[i*3]) {
				case('S'):
					card = 0+Character.getNumericValue(arr[i*3+1])*10+Character.getNumericValue(arr[i*3+2]);
					break;
				case('D'):
					card = 13+Character.getNumericValue(arr[i*3+1])*10+Character.getNumericValue(arr[i*3+2]);
					break;
				case('H'):
					card = 26+Character.getNumericValue(arr[i*3+1])*10+Character.getNumericValue(arr[i*3+2]);
					break;
				case('C'):
					card = 39+Character.getNumericValue(arr[i*3+1])*10+Character.getNumericValue(arr[i*3+2]);
					break;
				}
				if(cards[card]!=false) {
					System.out.println("#"+t+" ERROR");
					isBreak = true;
					break;
					}
				cards[card]=true;
					
				}
			if(isBreak == true) {
				continue;
			}
			
			// 출력
			System.out.print("#"+t);
			int cnt=0;
			for(int i=0;i<4;i++) {
				for(int j=13*i+1;j<=13*i+13;j++) {
					if(cards[j]==false) {
						cnt++;
					}
				}
				System.out.print(" "+cnt);
				cnt=0;
			}
			System.out.println();
			}
		
	
	}
}
