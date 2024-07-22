package snailnumber;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc=1;tc<=T;tc++) {
			////main
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			
			int[] dr = new int[] {0,1,0,-1};
			int[] dc = new int[] {1,0,-1,0};
			// 우0, 하1, 좌2, 상3
			int dir=0;
			int row=0; int col=0;
			for(int i=1;i<=n*n;i++) {
				// dt
				arr[row][col]=i;
				// 방향전환
				dir=(i-1)/4;
				row+=dr[dir];col+=dc[dir];
				
			}
			int row=0; int col=0;
			while(cnt<=n*n) {
				arr[row][col]=cnt;
				if(col)
				
			}
			
				static int[] dr = { 0, 1, 0, -1 }; // 우하좌상 순서
				static int[] dc = { 1, 0, -1, 0 };

				public static void main(String[] args) {
					Scanner sc = new Scanner(System.in);
					int T = sc.nextInt(); // 테스트 케이스 개수
					for (int t = 1; t <= T; t++) {
						int N = sc.nextInt(); // n 입력 받고
						int[][] nums = new int[N][N]; // n*n 배열 생성

						int dir = 0; // 현재 방향 인덱스
						int r = 0, c = 0; // 시작 좌표
						for (int i = 1; i <= N * N; i++) { // 1부터 N*N까지 숫자를 배열에 넣기
							nums[r][c] = i;
							if (r + dr[dir] >= N || r + dr[dir] < 0 || c + dc[dir] >= N || c + dc[dir] < 0
									|| nums[r + dr[dir]][c + dc[dir]] != 0) {
								// 배열을 벗어나는지 //그 자리에 숫자가 입려되있는지 확인
								dir = (dir + 1) % 4; // 방향전환
							}
							r += dr[dir];
							c += dc[dir];
						}
						System.out.println("#" + t);
						for (int i = 0; i < N; i++) {
							for (int n : nums[i])
								System.out.print(n + " ");
							System.out.println();
						}
					}

				}
			}
			
			
		}
	}

}
