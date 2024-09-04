package 나무자르기2805;

import java.util.Arrays;
import java.util.Scanner;
// 풀이중
public class Main {
	
	static int N,M;
	static int[] tree;
	
	static int length;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		tree = new int[N];
		for(int i=0;i<N;i++) {
			tree[i] = sc.nextInt();
		}
		Arrays.sort(tree);
		find(0,tree[N-1],tree[N-1]/2);
		System.out.println(length);
	}
	// 이진 탐색
	static void find(int start, int end, int mid) {
		if(start<=end) {
			length = mid;
			int sum=0;
			for(int i=0;i<N;i++) {
				sum+=tree[i]-length;
			}
			if(sum<M) {
				find(start,mid-1,(start+mid)/2);
			}else if(sum>M){
				find(mid+1,end,(mid+end)/2);
			}else if(sum == M) {
				return;
			}
		}
	}
}
