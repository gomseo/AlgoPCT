package ant;
import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine()); //StringTokenizer인자값에 입력 문자열 넣음
		int w = Integer.parseInt(st.nextToken()); //첫번째 호출
		int h = Integer.parseInt(st.nextToken());

		StringTokenizer s = new StringTokenizer(bf.readLine());
		int x = Integer.parseInt(s.nextToken()); //첫번째 호출
		int y = Integer.parseInt(s.nextToken());
		int t = bf.read();
		
		// 변화율 : x좌표 +, - / y좌표 +, -
		int[] dt = {1,-1};
		
		int xx = 0; int xy=0;
		
		for(int i=0;i<t;i++) {
			// 위치 이동
			x+=dt[xx]; y+=dt[xy];
			 
			// 범위 안에서만 
			if(x==0||x==w||y==0||y==h) {
				// 부딪혔을 때
				if(x==w) {xx=1;}
				else if(x==0) {xx=0;}
				if(y==h) {xy=1;}
				else if(y==0) {xy=0;}
			}
			
		}
		
		System.out.printf("%d %d",x, y);
	}

}
