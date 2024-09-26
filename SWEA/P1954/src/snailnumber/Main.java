package snailnumber;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc=1;tc<=T;tc++) {
			////main
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			int[] dr = new int[] {0,1,0,-1};
			int[] dc = new int[] {1,0,-1,0};
			// 우0, 하1, 좌2, 상3
			int x=0;
			int row=0; int col=0;
			for(int i=1;i<=N*N;i++) {
				// dt
				arr[row][col]=i;
				// 방향전환
				if(row+dr[x]>=N || row+dr[x]<0 || col+dc[x]>=N || col+dc[x]<0 || arr[row+dr[x]][col+dc[x]]!=0)
					x=(x+1)%4;
				
				row+=dr[x];col+=dc[x];
			}
			
			System.out.println("#"+tc);

			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					System.out.printf("%d ",arr[i][j]);					
				}
				System.out.println();
			}		
		}
	}
}
