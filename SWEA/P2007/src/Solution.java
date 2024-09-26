import java.util.Scanner;

public class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		for(int t=1;t<=T;t++) {
			String str = sc.nextLine();
			char[] arr = str.toCharArray();
			
			// 문자열 길이 30, 마디의 최대 길이 10
			for(int j=1;j<=10;j++) {
				
				boolean isPattern = true;
				if(arr[j]==arr[0]) {
					for(int i=0;i<j;i++) {
						if(arr[i]!=arr[i+j]) {
							isPattern=false;
						}
					}
					if(isPattern == true) {
						System.out.println("#"+t+" "+j);
						break;
				}
				}
			}
			
			
		}
	}
}
