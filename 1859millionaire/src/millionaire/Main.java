package millionaire;

import java.io.FileInputStream;
import java.util.Scanner;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException{
		
		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T=sc.nextInt();
		for(int test_case=1;test_case<=T;test_case++) {
			
			///////////////////////////////////
			int n = sc.nextInt();
			
			// 배열 입력받기
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			
			// 백만장자 가보자 1 2 3 1 1 5 4
			int max=0; int index=0; int sum=0; int ans=0;
			
			for(int i=0;i<n;i++) {
				if(arr[i]>=max) max=arr[i];
				
				else if(arr[i]<max) {
					// i-1번째 인덱스가 최대값
					for(int j=index;j<=i-1;j++) {
						sum+=max-arr[j];
					}
					ans+=sum;sum=0;
					max=arr[i];index=i;
				}
				
			}
			// 마지막 남은애들 처리
			for (int j = index; j <= n-1; j++) {
				sum += max - arr[j];
				}
			ans += sum;
			System.out.println("#"+test_case+" "+ans);
			
				
			
		}
		
	}

}

