package 나무자르기2805;

import java.util.Arrays;
import java.util.Scanner;
// 풀이중
public class Main {
	
	static int N,M;
	static long[] tree;
	
	static long length;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		tree = new long[N];
		for(int i=0;i<N;i++) {
			tree[i] = sc.nextInt();
		}
		Arrays.sort(tree);
		find(0,tree[(N-1)]);
		System.out.println(length);
	}
	// 이진 탐색
	static void find(long start, long end) {
		if(start<=end) {
			length = (start+end)/2;
			long sum=0;
			for(int i=0;i<N;i++) {
				if(tree[i]-length>0) {
					sum+=tree[i]-length;					
				}
			}
			if(sum == M) {
				return;
			}else if(sum<M) {
				find(start,length-1);
			}else if(sum>M){
				find(length+1,end);
			}
		}
	}
}
