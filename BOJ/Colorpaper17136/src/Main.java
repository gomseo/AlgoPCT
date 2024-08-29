import java.util.Scanner;

public class Main {
	
	static int[] paper = {5,5,5,5,5};
	static int[][] map = new int[10][10];
	static int cnt=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 배열 입력받기
		for(int r=0;r<10;r++) {
			for(int c=0;c<10;c++) {
				map[r][c]=sc.nextInt();
			}
		}
		
		// 1x1 ~ 5x5 각각 5개씩
		int[] cnt12345 = new int[5];
		
		cnt12345[4] = count(5);
		cnt12345[3]=count(4);
		cnt12345[2]=count(3);
		cnt12345[1]=count(2);
		cnt12345[0]=count(1);
		
		boolean answer=false;
		int min=26;
		for(int i=0;i<5;i++) {
			if(cnt12345[i]!=-1) {
				answer=true;
				min=min<cnt12345[i]?min:cnt12345[i];
			}
		}
		if(!answer) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
		
		
	}
	static void compare(int n, int[][] map1) {
		for(int r=0;r<=10-n;r++) {
			for(int c=0;c<=10-n;c++) {
				boolean put = true;
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						if(map1[r+i][c+j]==0) {
							put = false;
							break;
						}
					}
					if(!put) {
						break;
					}
				}
				if(put) {
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							map1[r+i][c+j]=0;
						}
					}
					paper[n-1]--; cnt++;
				}
			}
		}
	}
	static int count(int n) {
		cnt=0; paper = new int[] {5,5,5,5,5};
		int[][] map1 = map.clone();
		boolean answer = true;
		for(int i=n;i>0;i--) {
			compare(i,map1);
			for(int j=0;j<n;j++) {
				if(paper[j]<0) {
					answer=false;
					break;
				}
			}
			if(!answer) {
				break;
			}
		}
		if(!answer) {	
			return -1;
		}
		return cnt;
	}
}

// 반례
//0 0 0 0 0 0 0 0 0 0
//
//0 0 1 1 1 1 1 1 0 0
//
//0 0 1 1 1 1 1 1 0 0
//
//0 0 1 1 1 1 1 1 0 0
//
//0 0 1 1 1 1 1 1 0 0
//
//0 0 1 1 1 1 1 1 0 0
//
//0 0 1 1 1 1 1 1 0 0
//
//0 0 0 0 0 0 0 0 0 0
//
//0 0 0 0 0 0 0 0 0 0
//
//0 0 0 0 0 0 0 0 0 0

