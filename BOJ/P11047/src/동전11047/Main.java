package 동전11047;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		int cnt=0;
		int i=N-1;
		while(K>0) {
			if(arr[i]>K) {
				i--;
				continue;
			}
			cnt+=K/arr[i];
			K=K%arr[i];
			i--;
		}
		
		System.out.println(cnt);
	}
}
