import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileInputStream("src/input.txt"));
		
		int T = sc.nextInt();
		for(int test_case=1;test_case<=T;test_case++) {
			int N=sc.nextInt();
			int K=sc.nextInt();
			
			int[][] arr =new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
			// 흰색부분 1, 검정부분 0// 흰색부분이 연속길이 3인 나오는 곳을 찾기
			boolean isTrue=true;
			int cnt=0;
			// 행별 찾기
			for(int r=0;r<N;r++) {
				for(int c=0;c<N-K;c++) {
					for(int k=c;k<c+K;k++) {
						if(arr[r][k]!=1) isTrue=false;
						}
					if(arr[r][c+K]==0&&isTrue==true) cnt++;
					isTrue=true;
				}
			}
			// 열별 찾기
			for(int c=0;c<N;c++) {
				for(int r=0;r<N-K;r++) {
					for(int k=r;k<r+K;k++) {
						if(arr[k][c]!=1) isTrue=false;
						}
					if(arr[r+K][c]==0&&isTrue==true) cnt++;
					isTrue=true;
				}
			}
			
			System.out.printf("#%d %d",test_case,cnt);
			System.out.println();
			
		}
		
	}

}
