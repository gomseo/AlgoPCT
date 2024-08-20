import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileInputStream("src/input.txt"));
		
		int T = sc.nextInt();
		for(int test_case=1;test_case<=T;test_case++) {
			int N=sc.nextInt();
			int K=sc.nextInt();
			
			int[][] arr =new int[N+2][N+2];
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
			// 흰색부분 1, 검정부분 0// 흰색부분이 연속길이 K인 곳을 찾기
			// => 연속 1인 구간 세기 -> K랑 구간 개수가 같으면 정답개수++
			// index 1~N에서 세기
			boolean isTrue=true;
			int cnt=0; 
			// 행별 찾기
			for(int r=1;r<=N;r++) {
				for(int c=1;c<=N-(K-1);c++) {
					for(int i=0;i<K;i++) {
						if(arr[r][c+i]==0) isTrue=false;
					}
					if(arr[r][c-1]==0 && arr[r][c+K]==0 && isTrue==true) cnt++;
					isTrue=true;
				}
			}
			// 열별 찾기
			for(int c=1;c<=N;c++) {
				for(int r=1;r<=N-(K-1);r++) {			
					for(int i=0;i<K;i++) {
						if(arr[r+i][c]==0) isTrue=false;
					}
					if(arr[r-1][c]==0 && arr[r+K][c]==0 && isTrue==true) cnt++;
					isTrue=true;
				}
			}
			
			System.out.printf("#%d %d",test_case,cnt);
			System.out.println();
			
		}
		
	}

}
