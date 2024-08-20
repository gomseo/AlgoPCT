import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1;t<=T;t++) {
			
			// 도시수, 제한거리
			int city = sc.nextInt();
			int distance = sc.nextInt();
			
			// 지도 정보
			int[] map = new int[city];
			for(int c=0;c<city;c++) {
				map[c] = sc.nextInt();
			}
			
			// 몇개의 차원 관문이 필요한가?			
			int cnt=0, c=-1;
			while(c<city) {
				int d = 1;
				while (d <= distance) {
				    if (c + d < city && map[c + d] == 1) {
				        c = c + d; // c값 업데이트
				        d = 1;
				    } else {
				        d++;
				    }
				}
				if(c+distance<city) {
					c=c+distance;
					cnt++;					
				}else {
					c=c+distance;
				}
				
			}
			
			System.out.println("#"+t+" "+(cnt));
		}
		
	}

}
