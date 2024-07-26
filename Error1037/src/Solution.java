import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(bf.readLine());
		int[][] arr = new int[N][N];
		
		// 배열 입력받기
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		// 행, 열 별 sum값 담은 배열 생성 후,
		// 배열에 홀수가 한개씩 있으면 change bit, 다 짝수면 OK, else면 Corrupt
		int[] rowarr = new int[N];
		int[] colarr = new int[N];
		int sum1=0; int sum2=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sum1 += arr[i][j];
				sum2 += arr[j][i];
			}// 홀수면 1로 저장
			if(sum1%2!=0)
				rowarr[i]=1;
			if(sum2%2!=0)
				colarr[i]=1;
			sum1=0;sum2=0;
		}
		
//		System.out.println(Arrays.toString(rowarr));
//		System.out.println(Arrays.toString(colarr));
		
		// 배열의 원소를 다 합했을 때 값에 따라 최종 출력
		for(int i=0;i<N;i++) {
			sum1+=rowarr[i];
			sum2+=colarr[i];
		}
		
//		System.out.println(sum1);
//		System.out.println(sum2);
		
		if(sum1==0&&sum2==0) {
			System.out.println("OK");
		}
		else if(sum1==1&&sum2==1) {
			int x=0, y=0;
			for(int i=0;i<rowarr.length;i++) {
				if(rowarr[i]==1) x=i+1;
				if(colarr[i]==1) y=i+1;
			}
			System.out.printf("Change bit (%d,%d)",x,y);
		}
		else {
			System.out.println("Corrupt");
		}
				
	}

}
