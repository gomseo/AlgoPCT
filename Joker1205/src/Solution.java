import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
			}
		
		Arrays.sort(arr); // 정렬
		
		// 0 개수 세기
		int zerocnt=0;
		for(int i=0;i<N;i++) {
			if(arr[i]==0) zerocnt++;
		}
		
		System.out.println(Arrays.toString(arr));
		System.out.println(zerocnt);
		
		// 연속 배열 세기
		int len=1, sum=0, max=0;
		for(int i=0;i<N-1;i++) {
			if(arr[i]!=0) {			//0이 아닌 값들에 대해서
				
				// i번째, i+1번째 값이 같으면 len++
				if(arr[i+1]==arr[i]+1) len++;
				// 같지 않으면 sum 업데이트 해주고 len=1로 초기화
				else {
					if(arr[i+1]-arr[i]-1>zerocnt) {
						sum+=len+zerocnt;
						if(sum>max) {
							max=sum; sum=0;
						}
						len=1;
						}
					else{
						sum=len+(arr[i+1]-arr[i]-1);
						zerocnt-=(arr[i+1]-arr[i]-1);
						len=1;					
					}
				}
				
			}	
		}
		System.out.println(max);
	}
}
			
					
	