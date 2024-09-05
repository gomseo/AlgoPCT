import java.util.Scanner;

public class Main {
	
	static int N;
	static int[][] paper;
	static boolean[][] paperbool;
	
	static int[] cnt = new int[3];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		paper = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				paper[i][j]=sc.nextInt();
			}
		}
		
		// 종이의 모서리 값을 시작값으로 세팅
		// 행/열을 돌면서 다른 값이 있다면 -> break하고 종이 자르기(한변의 길이를 N/3으로)
		// N/3 -> 1이되면 종료
		paperbool = new boolean[N][N];
		check(0,0,N,N,N);
		
		for(int i=0;i<3;i++) {
			System.out.println(cnt[i]);			
		}
		
		
	}
	static void check(int starti, int startj, int lengthi, int lengthj, int L) {
		////재귀시작
		for(int i=0;i<lengthi;i=i+L) {
			for(int j=0;j<lengthj;j=j+L) {
				// 시작점이 i, j, 길이가 L
				if(paperbool[i][j]) continue;
				boolean isTrue = true;
				for(int r=i;r<i+L;r++) {
					for(int c=j;c<j+L;c++) {
						// 다 돌면서 true 확인
						if(paper[r][c]!=paper[i][j]) isTrue = false;
					}
				}
				
				// true면 cnt값 업데이트 하고 true로 표시
				if(isTrue) {
					cnt[paper[i][j]+1]++;
					for(int r=i;r<i+L;r++) {
						for(int c=j;c<j+L;c++) {
							paperbool[r][c]=true;
						}
						
					}
				}else {
					// false면 L/3으로 재귀
					check(i,j,i+L,j+L,L/3);
				}
			}
		}
			////재귀끝
	}
}

//9
//0 1 -1 0 1 -1 0 1 -1
//0 -1 1 0 1 -1 0 1 -1
//0 1 -1 1 0 -1 0 1 -1
//0 0 0 1 1 1 -1 -1 -1
//0 0 0 1 1 1 -1 -1 -1
//0 0 0 1 1 1 -1 -1 -1
//1 1 1 0 0 0 0 0 0
//1 1 1 0 0 0 0 0 0
//1 1 1 0 0 0 0 0 0
