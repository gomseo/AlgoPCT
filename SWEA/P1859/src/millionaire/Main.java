package millionaire;

import java.io.FileInputStream;
import java.util.Scanner;
import java.io.IOException;
import java.util.Scanner;

public class Main{
public static void main(String[] args) throws IOException{
		
		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n=sc.nextInt();
			long diff=0;
			int max_value=0;
			int[] arr=new int[n];
			for (int j = 0; j < n; j++) {
				arr[j]=sc.nextInt();
			}
			for (int j = n-1; j >=0; j--) {				
				if(arr[j]>max_value)max_value=arr[j];
				diff+=max_value-arr[j];
			}
			System.out.printf("#%d %d\n",i+1,diff);
		}
		sc.close();
}}





//public class Main {
//	public static void main(String[] args) throws IOException{
//		
//		System.setIn(new FileInputStream("src/input.txt"));
//		Scanner sc = new Scanner(System.in);
//		
//		int T=sc.nextInt();
//		for(int test_case=1;test_case<=T;test_case++) {
//			
//			///////////////////////////////////
//			int n = sc.nextInt();
//			
//			// 배열 입력받기
//			int[] arr = new int[n];
//			for(int i=0;i<n;i++) {
//				arr[i]=sc.nextInt();
//			}
//			
//			// 백만장자 가보자 
//			// ex) 1 2 (3) 1 1 (2) 1 7 -> 2+1+1+1+6 = 11
//			// ex) 1 2 3 1 1 2 1 (7) -> 6+5+4+6+6+5+6 = !!
//			long max=0; int startindex=0; int maxindex=-1; long sum=0;
//			while (true) {
//			for(int i=n-1;i>maxindex;i--) {
//				if(arr[i]>max) {
//					max=arr[i]; maxindex=i;
//				}
//			}
//			for(int i=startindex;i<=maxindex;i++) {
//				sum+=max-arr[i]; 
//			}
//			startindex=maxindex+1; 
//			max=0;
//			if(maxindex==n-1) break;
//			}
//			
//			System.out.println("#"+test_case+" "+sum);
//			
//			
//		}
//		
//	}
//	
//}
			
			
				
//			import java.io.FileInputStream;
//			import java.util.Scanner;
//			import java.io.IOException;
//
//			public class Solution {
//				public static void main(String[] args) throws IOException{
//					
//					//System.setIn(new FileInputStream(&quot;src/input.txt&quot;));
//					Scanner sc = new Scanner(System.in);
//					
//					int T=sc.nextInt();
//					for(int test_case=1;test_case<=T;test_case++) {
//						
//						///////////////////////////////////
//						int n = sc.nextInt();
//						int[] arr = new int[n+1];
//			            for(int i=0;i<n;i++) {
//							arr[i]=sc.nextInt();
//						}
//						
//						long max=0; int index=0; long sum=0; int ans=0;
//						// main
//						for(int i=0;i<n+1;i++) {
//							if(arr[i]>=max) max=arr[i];
//							else if(arr[i]<max) {
//								for(int j=index;j<=i-1;j++) {
//									sum+=max-arr[j];
//								}
//								ans+=sum;sum=0;
//			                    max=arr[i];index=i;
//							}
//			            }
//			            //for (int j = index; j <= n-1; j++) {
//			            //        sum += max - arr[j];
//			            //}
//			            //ans += sum;
//						System.out.println("#"+test_case+" "+ans);
//						}
//					}
//			}
			
				

