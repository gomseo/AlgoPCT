import java.util.Arrays;
import java.util.Scanner;
// 풀이중
public class Main {
	
	static int N, K;
	static int[] Lan;
	
	static int cnt, len;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		Lan = new int[N];
		for(int i=0;i<N;i++) {
			Lan[i] = sc.nextInt();
		}
		Arrays.sort(Lan);
		
		cnt = K/N; // 잘리는 개수 : 최소 한 랜선 당 K/N개씩 잘려야 함
		len = Lan[N-1]/cnt; // 초기 잘린 랜선 길이
		// 잘렸을 때의 길이가 모든 랜선의 길이보다 작아야 함;
		while(true) {
			if(len<=Lan[0]) break;
			else len=Lan[N-1]/++cnt;
		}
		// 길이만큼 잘라서 나온 랜선 개수의 합이 K를 넘는지 확인
		while(true) {
			int sum=0;
			for(int i=0;i<N;i++) {
				sum+=Lan[i]/len;
			}
			if(sum>=K) break;
			else len = Lan[N-1]/++cnt;
		}
		// len 최적화 -> 이진탐색
		// 잘린 개수인 cnt랑 cnt-1개로 나눈 선 길이 사이에서 이진탐색
		int left = Lan[N-1]/cnt;
		int right = Lan[N-1]/(cnt-1);
		int mid = (left+right)/2;
		binarysearch(left, right, mid);
					
		// 출력
		System.out.println(len);
				
	}
	// 이진탐색
	static void binarysearch(int left, int right, int mid) {
		if(left>=mid || right<=mid) {
			len = mid;
			return;
		}
		int sum=0;
		for(int i=0;i<N;i++) {
			sum+=Lan[i]/mid;
		}
		if(sum<K) {
			binarysearch(left,mid,(left+mid)/2);
		}else {
			binarysearch(mid,right,(right+mid)/2);
		}		
	}
}
