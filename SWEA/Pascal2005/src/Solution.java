import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int N = sc.nextInt();
			
			System.out.println("#"+t);
			// N 크기의 파스칼 삼각형
			List<Integer> tri = new ArrayList<Integer>();
			for(int n=1;n<=N;n++) {
				if(n==1 || n==2) {
					tri.add(1);
				}
				else {
					List<Integer> newtri = new ArrayList<Integer>();
					newtri.add(1);
					for(int i=0;i<n-2;i++) {
						newtri.add(tri.get(i)+tri.get(i+1));
					}
					newtri.add(1);
					tri = newtri;
				}
				for(int num:tri) {
					System.out.print(num+" ");
				}
				System.out.println();
			}
		}
		sc.close();
	}

}
