import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 배열 입력받기
		int[][] arr = new int[19][19];
		for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		// 방향 : →, ↘ ,↗,↓
		int[] dr = {0,1,-1,1};
		int[] dc = {1,1,1,0};
		int cnt=0;
		
		for(int r=0;r<19;r++) {
			for(int c=0;c<19;c++) {
				
				if(arr[r][c]==1) {
					for(int d=0;d<4;d++) {
						cnt=0;
						int nr=r,nc=c;
						// 5번 반복
						for(int i=0;i<5;i++) {
							nr+=dr[d];
							nc+=dc[d];
							if(nr>=0 && nr>=0 && nr<19 && nc<19 && arr[nr][nc]==1) {
								cnt++; 
							}else {break;}
						}
						int pr = r-dr[d], pc = c-dc[d];
						if(cnt==4 && (pr < 0 || pr >= 19 || pc < 0 || pc >= 19 || arr[pr][pc] != 1)) {
							System.out.printf("1\n%d %d",r+1,c+1);return;}
					}
					
				}else if(arr[r][c]==2) {
					for(int d=0;d<4;d++) {
						cnt=0;
						int nr=r,nc=c;
						for(int i=0;i<5;i++) {
							nr+=dr[d];
							nc+=dc[d];
							if(nr>=0 && nr<19 && nc<19 && arr[nr][nc]==2) {
								cnt++;
							}else {break;}
						}
						int pr = r-dr[d], pc = c-dc[d];
						if(cnt==4 && (pr < 0 || pr >= 19 || pc < 0 || pc >= 19 || arr[pr][pc] != 2)) {
							System.out.printf("2\n%d %d",r+1,c+1);return;}
					}
				}
			}
		}	
		System.out.println(0);
		
	}

}
