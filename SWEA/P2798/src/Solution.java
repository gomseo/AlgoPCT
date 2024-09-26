import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(bf.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		// 숫자 세개 고르기 삼중 for문
		// 숫자 세개의 합이 M이 넘으면 안되면서 가장 커야 함
		int max=0; int sum=0;
		for(int i=0;i<N-2;i++) {
			for(int j=i+1;j<N-1;j++) {
				for(int k=j+1;k<N;k++) {
					if(arr[i]+arr[j]+arr[k]<=M) {
						sum=arr[i]+arr[j]+arr[k];
						if(sum>max) max=sum;
					}
				}
			}
		}
		
		System.out.println(max);
		
	}
}

