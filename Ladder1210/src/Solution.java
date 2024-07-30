import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new File("src/input.txt"));
		
		int[][] arr= new int[100][100];
		for(int t=1;t<=10;t++) {
			
			int T= sc.nextInt();
			
			// 배열 입력받기
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
//			System.out.println(Arrays.deepToString(arr));
			
			// 마지막 행에서 2인 index 찾기
			int idx=0;
			for(int i=0;i<100;i++) {
				if(arr[99][i]==2) {idx=i; break;}
			}
			
//			System.out.println(idx);
			
			// 사다리 거꾸로 타고 올라가기
			for(int i=98;i>=0;i--) {
				// 좌 우에 1값 있으면 끝까지 간 후 위로 올라가기
				if (idx - 1 >= 0 && arr[i][idx - 1] == 1) {
                    while (idx - 1 >= 0 && arr[i][idx - 1] == 1) {
                        idx--;
                    }
                } else if (idx + 1 < 100 && arr[i][idx + 1] == 1) {
                    while (idx + 1 < 100 && arr[i][idx + 1] == 1) {
                        idx++;
                    }
                }
			}
			
			System.out.println("#"+T+" "+idx);
			
		}
	}

}
