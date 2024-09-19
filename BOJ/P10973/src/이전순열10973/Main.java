package 이전순열10973;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] arr, input;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=i+1;
		}
		
		input = new int[N];
		for(int i=0;i<N;i++) {
			input[i]=sc.nextInt();
		}
		
		if(Arrays.equals(arr, input)) {
			System.out.println(-1);
			return;
		}
		
		// 처음에는 맨 뒷자리 수를 앞으로 삽입정렬
		// 삽입된 idx이후부터 맨 뒷자리까지 뒤부터 버블정렬
		
		
		
		
		
		
		
	}
	static void comb(int idx) {
		if(Arrays.equals(arr, input)) {
			return;
		}else if(idx==N) {
			return;
		}
		
		for(int i=0;i<N;i++) {
			
		}
	}

}
