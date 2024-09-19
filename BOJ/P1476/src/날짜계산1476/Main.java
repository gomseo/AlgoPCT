package 날짜계산1476;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		
		// 15*x+E = 28*y+S = 19*z+M
		int y=0;
		boolean isBreak=false;
		while(true) {
			int Y = 28*y+S;
			for(int z=0;19*z+M<=Y;z++) {
				for(int x=0;15*x+E<=Y;x++) {
					if(Y == 19*z+M && Y == 15*x+E) {
						isBreak=true;
						break;
					}
				}
				if(isBreak) break;
			}
			if(isBreak) break;
			y++;
		}
		
		System.out.println(28*y+S);
	}
}
