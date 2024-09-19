import java.util.Scanner;

public class Main {
	// greedy -> X
	// DP
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// N = a^2 + b^2 + c^2 + ...
		int a = (int) Math.floor(Math.sqrt(N));
		int b = (int) (N - Math.pow(a, 2)); 
		int cnt = 1;
		while(b>0) {
			a = (int) Math.floor(Math.sqrt(b));
			b = (int) (b - Math.pow(a, 2));
			cnt++;
		}
		
		System.out.println(cnt);
		
	}
}
