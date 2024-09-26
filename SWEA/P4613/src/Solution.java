import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			sc.nextLine();
			
			char[][] flag = new char[N][M];
			for(int i=0;i<N;i++) {
				String str = sc.nextLine();
				for(int j=0;j<M;j++) {
					flag[i][j]=str.charAt(j);
				}
			}
			
			int cnt=0, ans=Integer.MAX_VALUE;
			for(int i=1;i<N-1;i++) {
				int l=0;
				while(i+l<N) {
					cnt=0;
					// i행~i+l-1행까지 blue
					for(int j=0;j<i;j++) {
						for(int k=0;k<M;k++) {
							if(flag[j][k]!='W') {
								cnt++;
							}
						}
					}
					for(int j=i;j<i+l;j++) {
						for(int k=0;k<M;k++) {
							if(flag[j][k]!='B') {
								cnt++;
							}
						}
					}
					for(int j=i+l;j<N;j++) {
						for(int k=0;k<M;k++) {
							if(flag[j][k]!='R') {
								cnt++;
							}
						}
					}
					ans=cnt<ans? cnt:ans;
					l++;	
				}
			}
			
			System.out.println("#"+t+" "+ans);
		}
		
		
	}

}
