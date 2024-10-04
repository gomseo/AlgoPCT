import java.util.Arrays;
import java.util.Scanner;
// 풀이중
public class Main {
	
	static int N, K;
	static long[] Lan;
	
	static long len;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		// N : 필요한 랜선의 개수, K : 이미 가지고 있는 랜선의 개수
		N = sc.nextInt();
		K = sc.nextInt();
		Lan = new long[N];
		for(int i=0;i<N;i++) {
			Lan[i] = sc.nextInt();
		}
		Arrays.sort(Lan);
		long maxlen = Lan[N-1];
		
		// 이진탐색
		binarysearch(0,maxlen+1);
					
		// 출력
		System.out.println(len);
				
	}
	// 이진탐색
	static void binarysearch(long left, long right) {
	    if (left > right) {
	        len = right;  // 최종적으로 'right' 값이 답이 됨
	        return;
	    }
	    long mid = (left + right) / 2;
	    int sum = 0;
	    
	    for (int i = 0; i < N; i++) {
	        sum += Lan[i] / mid;
	    }
	    
	    if (sum < K) {
	        binarysearch(left, mid-1);
	    } else {
	        binarysearch(mid + 1, right);
	    }
	}

}
