import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// 1. 배열 생성
		// 1행부터 ~까지 각각 열의 개수가 1부터 한개씩 늘어나는 배열
		// 141 X 141 좌표평면 만들기
//		int T=sc.nextInt();
		int T=bf.read();
		for(int tc=1;tc<=T;tc++) {
		
			// 배열 생성
			int[][] arr = new int[142][142];
			
			int cnt=1;int x=1;
			while(cnt<=10000){
				for(int r=1;r<=x;r++) {
					arr[r][x-(r-1)]=cnt; cnt++;
				}
				x++;
			}
		
//			int N=sc.nextInt();
//			int M=sc.nextInt();
			StringTokenizer st = new StringTokenizer(bf.readLine()); //StringTokenizer인자값에 입력 문자열 넣음
			int N = Integer.parseInt(st.nextToken()); //첫번째 호출
			int M = Integer.parseInt(st.nextToken());
		
			int row1=0;int col1=0;
			int row2=0;int col2=0;
			for(int r=1;r<142;r++) {
				for(int c=1;c<142;c++) {
					if(arr[r][c]==N) {
						row1=r;col1=c;
					}
					else if(arr[r][c]==M) {
						row2=r;col2=c;
					}
				}
			}
		
			int ans=arr[row1+row2][col1+col2];
		
			System.out.printf("#%d %d",tc,ans);
		}
		sc.close();
		
		// 실행은 되는데 runtime error 발생
	}

}
