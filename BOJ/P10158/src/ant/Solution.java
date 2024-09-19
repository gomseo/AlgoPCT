package ant;
import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine()); //StringTokenizer인자값에 입력 문자열 넣음
		int w = Integer.parseInt(st.nextToken()); 
		int h = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(bf.readLine());
		// 0<x<w, 0<y<h
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int t = bf.read();
		
		// 변화율 : x좌표 +, - / y좌표 +, -
		int[] dt = {1,-1};
		
		int dx = 0; int dy=0;
		
		for(int i=0;i<t;i++) {
			// 위치 이동
			x+=dt[dx]; y+=dt[dy];
			 
			// 범위 안에서만 
			if(x==0||x==w||y==0||y==h) {
				// 부딪혔을 때
				if(x==w) {dx=1;}
				else if(x==0) {dx=0;}
				if(y==h) {dy=1;}
				else if(y==0) {dy=0;}
			}
			
		}
		
		System.out.printf("%d %d",x, y);
	}

}
