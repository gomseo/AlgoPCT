import java.util.Scanner;

public class Solution {
	
	static int[][] distance;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			int x1=0, x2=0, y1=0, y2=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j]=sc.nextInt();
					if(arr[i][j]==1) 
					if(arr[i][j]>1) {
						if(x1==0) {
							x1=i; y1=j;
						}else {
							x2=i; y2=j;
						}
					}
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
			
		}
	}
}
