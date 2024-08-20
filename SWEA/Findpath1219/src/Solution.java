import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.IOException;

public class Solution {
	
	static int[] arr1;
	static int[] arr2;
	static boolean answer;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("src/input.txt"));
		StringTokenizer st;
		
		for(int t=1;t<=10;t++) {
			st = new StringTokenizer(sc.nextLine());
			int T = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
						
			arr1 = new int[100];
			arr2 = new int[100];
			
			st = new StringTokenizer(sc.nextLine());
			while(st.hasMoreTokens()) {
				int i = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				if(arr1[i]==0) {
					arr1[i]=value;
				}else {
					arr2[i]=value;
				}
			}
			
//			System.out.println(Arrays.toString(arr1));
//			System.out.println(Arrays.toString(arr2));
			
			answer=false;
			check(0);
			// 0 -> 99까지 가능?
			if(answer) {
				System.out.println("#"+T+" 1");
			}else {
				System.out.println("#"+T+" 0");
			}
			
		}
	}
	
	// 재귀함수 만들때
	// 항상 답 출력부분을 맨 위에,
	// 재귀가 일어날 부분 코드를 맨 밑에,,
	static void check(int start) {
		// return 조건
		if(arr1[start]==99 || arr2[start]==99) {
			answer = true;
		}
		// 재귀 조건
		else {
			if(arr1[start]!=0) {
				check(arr1[start]);
			}
			if(arr2[start]!=0) {
				check(arr2[start]);
			}
		}
		// return 조건을 만족하면 return 결론에 도달하고 재귀 종료,
		// 만족하지 못하면 다음 재귀 이용한 다음 값 탐색
	}
	
	
}
