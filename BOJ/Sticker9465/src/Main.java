import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int N = sc.nextInt();
			
			int[][] sticker = new int[2][N];
			for(int i=0;i<N;i++) {
				sticker[0][i] = sc.nextInt();
			}
			for(int i=0;i<N;i++) {
				sticker[1][i] = sc.nextInt();
			}
			
			int[][] dp = new int[2][N];
			
			
			
			
		}
	}

}
