import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// 1. 배열 생성
		// 1행부터 ~까지 각각 열의 개수가 1부터 한개씩 늘어나는 배열
		// p, q => 141 X 141 좌표평면 안에 존재,,(왜냐면 1<=(p,q)<=10000)
		// p+q => 141+141 = 283X283 좌표평면 안에 존재,,(만약 뭐 p(141,1), q(141,1)면 p+q(282,2)니까)
		// 근데 인덱스 0을 안쓸꺼라 284X284 좌표평면 만들어야 함
		
		// 배열 생성
		int[][] arr = new int[284][284]; // 충분히 크게해도 되지만 나는 밑에 cnt값도 정확히 맞춰야해서,, 인덱스는 1~283
		
		int cnt=1;int x=1;
		while(cnt<=40186){
			for(int r=1;r<=x;r++) {
				arr[r][x-(r-1)]=cnt; cnt++;
			}
			x++;
		}

		int T=Integer.parseInt(bf.readLine());
		for(int tc=1;tc<=T;tc++) {
		
			StringTokenizer st = new StringTokenizer(bf.readLine()); //StringTokenizer인자값에 입력 문자열 넣음
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
		
			int row1=0;int col1=0;
			int row2=0;int col2=0;
			for(int r=1;r<284;r++) {
				for(int c=1;c<284;c++) {
					if(arr[r][c]==N) {
						row1=r;col1=c;
					}
					if(arr[r][c]==M) {
						row2=r;col2=c;
					}
				}
			}
		
			int ans=arr[row1+row2][col1+col2];
		
			System.out.printf("#%d %d\n",tc,ans);
		}		
		
	}

}
