import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws Exception{
		File f = new File("src/sample_input.txt");
		Scanner sc = new Scanner(f);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int t=1;t<=T;t++) {
			// 배열 입력받기
			int N=sc.nextInt();
			sc.nextLine();
			char[][] arr = new char[N][];
			for(int n=0;n<N;n++) {
				arr[n]=sc.nextLine().toCharArray();
			}
			
//			System.out.println(Arrays.deepToString(arr));
			
			// 대각선, 가로, 세로 확인
			int cnt=0; boolean isTrue=false;         // 값 초기화
			// 대각선 \
			// N-4 *  N-4 배열 확인
			for(int i=0;i<=N-5;i++) {
				for(int j=0;j<=N-5;j++) {
					cnt=0;
					int k=0;
					while(k<5) {
						if(i+k<N && j+k<N) {
							if(arr[i+k][j+k]=='o') {cnt++;}
							else if(arr[i+k][j+k]!='o') {cnt=0;}	
							
							k++;
							}
					}if(cnt==5) isTrue=true;
				}if(isTrue==true) break;
			}if(isTrue==true) {System.out.println("#"+t+" YES"); continue;}
			
			// 대각선 /
			// N-4 *  N-4 배열 확인
			for(int i=0;i<=N-5;i++) {
				for(int j=4;j<N;j++) {
					cnt=0;
					int k=0;
					while(k<5) {
						if(i+k<N && j-k>=0) {
							if(arr[i+k][j-k]=='o') {cnt++;}
							else if(arr[i+k][j-k]!='o') {cnt=0;}	
							
							k++;
						}
					}if(cnt==5) {isTrue=true; break;}
				}if(isTrue==true) break;
			}if(isTrue==true) {System.out.println("#"+t+" YES"); continue;}
								
			// 가로
			for(int i=0;i<N;i++) {
				cnt=0;
				for(int j=0;j<N;j++) {
					if(arr[i][j]=='o') {cnt++;}
					else if(arr[i][j]!='o') {cnt=0;}	
					
					if(cnt>=5) isTrue=true;
				}
			}
			if(isTrue==true) {System.out.println("#"+t+" YES"); continue;}
			// 세로 
			for(int i=0;i<N;i++) {
				cnt=0;
				for(int j=0;j<N;j++) {
					if(arr[j][i]=='o') {cnt++;}
					else if(arr[j][i]!='o') {cnt=0;}	
					
					if(cnt>=5) isTrue=true;
				}
			}
			if(isTrue==true) {System.out.println("#"+t+" YES"); continue;}
			System.out.println("#"+t+" NO");
			
		}
		
	}

}
