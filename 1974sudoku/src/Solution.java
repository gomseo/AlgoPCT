import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new FileReader("src/input.txt"));
		StringTokenizer st = new StringTokenizer(bf.readLine());
	
		int T = Integer.parseInt(st.nextToken());
		int[][] arr = new int[9][9];
	for(int test_case=1;test_case<=T;test_case++) {
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<9;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
	
		boolean isTrue=true;
	
		// 행별로 확인
		int sum=0;
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				sum+=arr[i][j];
			}
			if(sum!=45) {isTrue=false; break;}
			sum=0;
		}
	
		// 열별로 확인
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				sum+=arr[j][i];
			}
			if(sum!=45) {isTrue=false; break;}
			sum=0;
		}
	
		// 3X3 배열별로 확인
		for(int row=0;row<9;row+=3) {// 0,3,6
			for(int col=0;col<9;col+=3) {
				for(int i=row;i<row+3;i++) {
					sum+=arr[i][col]+arr[i][col+1]+arr[i][col+2];
				}
				if(sum!=45){isTrue=false; break;}
				sum=0;
			}
		}
	
		if(isTrue==true) {
			System.out.printf("#%d 1",test_case);
		}
		else {System.out.printf("#%d 0",test_case);}
		System.out.println();
	}
	}
}
