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
			int cnt=0;          // 값 초기화
			for(int i=0;i<N;i++) {
				// 대각선 \
				if(arr[i][i]=='o') {cnt++;}
				else if(arr[i][i]!='o') {cnt=0;}	
			}
			if(cnt>=5) {System.out.println("#"+t+" YES"); continue;}
			
			cnt=0;
			for(int i=0;i<N;i++) {
				// 대각선 /
				if(arr[i][(N-1)-i]=='o')  {cnt++;}
				else if(arr[i][(N-1)-i]!='o') {cnt=0;}		
			}
			if(cnt>=5) {System.out.println("#"+t+" YES"); continue;}
		
			// 가로
			boolean isBreak=false; 
			for(int i=0;i<N;i++) {
				cnt=0;
				for(int j=0;j<N;j++) {
					if(arr[i][j]=='o') {cnt++;}
					else if(arr[i][j]!='o') {cnt=0;}	
					
					if(cnt>=5) {System.out.println("#"+t+" YES"); isBreak=true; break;}
				}
				if(isBreak==true) break;
			}
			if(isBreak==true) continue;
			// 세로 
			for(int i=0;i<N;i++) {
				cnt=0;
				for(int j=0;j<N;j++) {
					if(arr[j][i]=='o') {cnt++;}
					else if(arr[j][i]!='o') {cnt=0;}	
					
					if(cnt>=5) {System.out.println("#"+t+" YES"); isBreak=true; break;}
				}
				if(isBreak==true) break;
			}
			if(isBreak==true) continue;
			System.out.println("#"+t+" NO");
			
		}
		
	}

}
