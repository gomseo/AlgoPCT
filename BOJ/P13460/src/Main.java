import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char arr[][]=new char[N][M];
		
		for(int n=0;n<N;n++) {
			arr[n]=br.readLine().toCharArray();
			}
		
		System.out.println(Arrays.deepToString(arr));
		
		// . 빈칸, # 벽, o 구멍 위치, R 빨간 구슬, B 파란 구슬
		// 빨간 구슬이 빠지면 성공, 파란구슬이 빠지면 실패
		
		// 동서남북
		int[] dr = {0,0,1,-1};
		int[] dc = {1,-1,0,0};
		int cnt=0;
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				// 구슬 위치 찾기
				if(arr[r][c]=='R') {
					for(int d=0;d<4;d++) {
						if(arr[r+dr[d]][c+dc[d]]=='O') {
							cnt++;
							System.out.println(cnt);
							return;
						}
						else if(arr[r+dr[d]][c+dc[d]]=='.') {
							while(arr[r+dr[d]][c+dc[d]]!='#') {
								arr[r][c]=','; // 왔던 길은 표시
								r+=dr[d];
								c+=dc[d];
							}
						}
					}
				}
				
				
				
				
			}
		}
		
	}
	
	public static void DFS
	

}
