package Magnetic;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.io.FileInputStream;

public class main {
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1;tc<=10;tc++) {
			////1은 N극, 2는 S극
			
			int N = sc.nextInt(); // 이 값은 항상 100
			
			// 배열 입력받기
			int[][] arr = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j]=sc.nextInt();					
				}
			}
			
//			System.out.println(Arrays.deepToString(arr));
			
			boolean one=false; 
			int cnt=0;
			// 열 별로 살펴보기			
			for(int j=0;j<N;j++) {
				one=false;
				for(int i=0;i<N;i++) {					
					// 충돌하려면 무조건 1아래에 2가 있어야 함
					if(arr[i][j]==1) {
						one=true; 
					}
					else if(one==true&&arr[i][j]==2) {
						cnt++; one=false;
					}
				}
			}
			
			System.out.printf("#%d %d",tc,cnt);
			System.out.println();
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
			
				
			
		}
		
	}
