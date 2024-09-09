package 리모컨1107;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static boolean[] num;
	static String[][] arr;
	static String N;
	static int min=Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextLine();
		int M = sc.nextInt();
		num = new boolean[10];
		Arrays.fill(num, true);
		for(int i=0;i<M;i++) {
			num[sc.nextInt()] = false;
		}
		
		arr = new String[N.length()][2];
		for(int i=0;i<N.length();i++) {
			if(num[N.charAt(i)-'0']) {
				arr[i][0] = String.valueOf(N.charAt(i));
			}else {
				find(N.charAt(i)-'0',i);
			}
		}
		
		dfs("",0);
		if(N.length()<=3) {
			System.out.println(Math.min(Math.abs(Integer.parseInt(N)-100), min));
		}else {
			System.out.println(min);			
		}
		
	}
	static void find(int i, int idx) {
		int j = 1;
		boolean isTrue = false;
		while(i-j>=0||i+j<=9) {
			if(i-j>=0 && num[i-j]) {
				arr[idx][0] = String.valueOf(i-j);
				isTrue = true;
			}
			if(i+j<=9 && num[i+j]) {
				arr[idx][1] = String.valueOf(i+j);
				isTrue = true;
			}
			if(isTrue) break;
			j++;
		}
	}
	static void dfs(String str,int i) {
		if(i==N.length()) {
			if(str.length()!=N.length()) return;
			System.out.println(str);
			int diff = Math.abs(Integer.parseInt(str)-Integer.parseInt(N));
			min = Math.min(min, N.length()+diff);
			return;
		}
		
		dfs(str+arr[i][0],i+1);
		dfs(str+arr[i][1],i+1);
	}
}
