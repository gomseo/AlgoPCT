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
		
		// 배열이 다 0일때
		if(zerocnt==arr.length) {System.out.println(arr.length); return;}
		
		// 중복값 제거
		arr = Arrays.stream(arr).distinct().toArray();
		
		// 메인
		int len=1, sum=0, max=0, zeroleft=zerocnt;
		for(int i=(zerocnt==0?0:1);i<N-1;i++) {
			// i번째, i+1번째 값이 연속이면 len++

	            if (i == zeroCount || arr[i] == arr[i - 1] + 1) {
	                currentLen++;
	            } else if (arr[i] == arr[i - 1]) {
	                continue; // Skip duplicate elements
	            } else {
	                int gap = arr[i] - arr[i - 1] - 1;
	                if (gap <= remainingZeros) {
	                    currentLen += gap + 1;
	                    remainingZeros -= gap;
	                } else {
	                    maxLen = Math.max(maxLen, currentLen + remainingZeros);
	                    remainingZeros = zeroCount;
	                    currentLen = 1;
	                }
	            }
	        }
	        
	        maxLen = Math.max(maxLen, currentLen + remainingZeros);
	        
	        System.out.println(maxLen);
			System.out.println(i+"번째 len:"+len);
			System.out.println(i+"번째 sum:"+sum);
			System.out.println(i+"번째 max:"+max);
			System.out.println(i+"번째 zeroleft:"+zeroleft);
						
			// 배열 다 돌았을 때
			if(i==N-2) {
				sum+=len+zeroleft;
				if(sum>max) {
					max=sum;
						}
				}
			}
		System.out.println(max);
		}
}

			
					
	