package fly;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class main {
	public static void main(String[] args) throws IOException{
		
		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case=1;test_case<=T;test_case++) {
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			// 배열받기
			int[][] arr = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
//			// 파리채 배열 생성
//			int[] fly = new int[m*m];
//			int row=0; int col=0;
//			for(int i=0;i<m*m;i++) {
//				for(int j=0;j<m;j++) {
//					fly[i]= {row,col};
//					col++;
//				}
//				row++; col=0;
//			}
			
			int sum=0; int ans=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					// arr[i][j]가 시작지점
					
					for(int r=0;r<m;r++) {
						for(int c=0;c<m;c++) {
							if(i+r<n && j+c<n) {
								sum += arr[i+r][j+c];
							}
						}
					}
					if(sum>ans) ans=sum;
					sum=0;
				}
			}
			
			System.out.println("#"+test_case+" "+ans);
			
		sc.close();
			
		}
		
	}

}
