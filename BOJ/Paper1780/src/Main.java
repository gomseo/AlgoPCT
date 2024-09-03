import java.util.Scanner;

public class Main {
	
	static int N;
	static int[][] paper;
	
	static int[] cnt;
	static int NN;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
//		System.out.println(Math.pow(3, 14)); // 500만
		paper = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				paper[i][j]=sc.nextInt();
			}
		}
		
		// 종이의 모서리 값을 시작값으로 세팅
		// 행/열을 돌면서 다른 값이 있다면 -> break하고 종이 자르기(한변의 길이를 N/3으로)
		// N/3 -> 1이되면 종료
		cnt = new int[3];
		NN = N;
		for(int i=0;i<N;i=i+NN) {
			for(int j=0;j<N;j=j+NN) {
				out:
				// i, j꼭짓점부터 한변길이가 NN인 사각형 check
				if(NN!=check(i,j,NN)) {
					NN = check(i,j,NN); break out;
				}else {
					cnt[paper[i][j]+1]++;
				}
			}
		}
		
		for(int i=0;i<3;i++) {
			System.out.println(cnt[i]);			
		}
		
		
	}
	static int check(int i, int j, int n) {
		if(n==1) return 1;
		int startvalue = paper[i][j];
		for(int r=i;r<i+n;r++) {
			for(int c=j;c<j+n;j++) {
				if(paper[r][c]!=startvalue) {
					n = n/3;
					return n;
				}
			}
		}
		return n;
	}
}
