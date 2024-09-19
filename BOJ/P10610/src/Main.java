import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] arr = sc.nextLine().toCharArray();
		boolean isZero = false;
		for(int i=0;i<arr.length;i++) {
			if (arr[i]-'0'==0) {
				isZero = true;
				break;
			}
		}
		if(!isZero) {
			System.out.println(-1);
			return;
		}
		
		// 3의 배수 판정법 -> 각 자리수의 합이 3의 배수,,
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i]-'0';
		}
		if(sum%3!=0) {
			System.out.println(-1);
			return;
		}else {
			// 가장 큰 수부터 정렬 -> sort?
			Arrays.sort(arr);
			StringBuilder sb = new StringBuilder();
			for(int i=arr.length-1;i>=0;i--) {
				sb.append(String.valueOf(arr[i]));
			}
			System.out.println(sb);
		}
		
	}
}
