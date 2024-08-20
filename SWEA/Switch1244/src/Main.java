import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
				
		// 스위치 배열 입력
		st = new StringTokenizer(br.readLine());
		for(int n=0;n<N;n++) {
			arr[n]=Integer.parseInt(st.nextToken());
		}
		
		// 학생 수 입력
		int M = Integer.parseInt(br.readLine());
		
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
			// 남학생
			if(gender==1) {
				// n의 배수 자리 스위치 상태를 바꿈
				for(int i=0;i<N;i++) {
					if((i+1)%num==0) {
						arr[i]=(arr[i]+1)%2;
					}
				}
				
			}
			// 여학생
			else if(gender==2) {
				num--; //num -> index로 변환
				// num을 기준으로 좌우로 일정거리만큼 떨어진 값이 다를때까지의 스위치 상태 바꿈
				int i=1;
				while(num+i<=N-1 && num-i>=0) {
					if(arr[num-i]!=arr[num+i]) break;
					i++;
				}	
				for(int j=num-(i-1);j<=num+(i-1);j++) {
					arr[j]=(arr[j]+1)%2;
					}
				}
//				System.out.println(Arrays.toString(arr));
			}
		// 출력
		for(int i=0;i<N;i++) {
			System.out.print(arr[i]+" ");
			if((i+1)%20==0) System.out.println();
		}
				
	}

}
