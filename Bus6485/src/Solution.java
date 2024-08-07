import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	int T = Integer.parseInt(br.readLine());
	for(int t=1;t<=T;t++) {

		// N개의 버스에 대해 A, B 배열 생성
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];
		
		for(int n=0;n<N;n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A[n] = Integer.parseInt(st.nextToken());
			B[n] = Integer.parseInt(st.nextToken());
		}
		
//		** Map 이용 **
//		// P개의 버스 정류장 배열 C 생성		
//		int P = Integer.parseInt(br.readLine());
//		Map<Integer, Integer> C = new HashMap<Integer, Integer>( );
//		for(int c=0;c<P;c++) {
//			C.put(Integer.parseInt(br.readLine()), 0);
//		}
//		
//		// 버스개수만큼 반복, 정류장이 노선 A,B 사이값이면 value+1
//		for(int i=0;i<N;i++) {
//			for(int j : C.keySet()) {
//				if(j>=A[i] && j<=B[i]) {
//					C.replace(j, C.get(j)+1);
//				}
//			}
//			System.out.println(C);
//		}
//		
//		// 출력
//		System.out.print("#"+t);
//		for(int i : C.keySet()) {
//			System.out.print(" "+C.get(i));
//		}
//		System.out.println();
		
		int P = Integer.parseInt(br.readLine());
		int[] C = new int[P];
        for(int c=0;c<P;c++) {
			C[c]=(Integer.parseInt(br.readLine()));
		}
        int[] arr = new int[C.length];
        
     // 버스개수만큼 반복, 정류장이 노선 A,B 사이값이면 value+1
		for(int i=0;i<N;i++) {
			int idx=0;
			for(int j : C) {
				if(j>=A[i] && j<=B[i]) {
					arr[idx]++;
				}
				idx++;
			}
		}
		
		// 출력
		System.out.print("#"+t);
		for(int i=0;i<arr.length;i++) {
			System.out.print(" "+arr[i]);
		}
		System.out.println();
		
		
	}
}
}
