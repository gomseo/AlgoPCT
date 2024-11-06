import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Solution {
	static int memory;
	static int dr, dc;
	static int[] loc;
	
	public static class History{
		int num, dr, dc;
		History(int num, int dr, int dc){
			this.num=num;
			this.dr=dr;
			this.dc=dc;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			sc.nextLine();
			
			memory = 0;
			loc = new int[] {0,0};
			dr=0;dc=1;
			// 방향 + 숫자 history
			History[][] history = new History[R][C];
			
			// 명령어 입력받기
			char[][] command = new char[R][C];
			for(int r=0;r<R;r++) {
				String str = sc.nextLine();
				for(int c=0;c<C;c++) {
					command[r][c] = str.charAt(c);
				}
			}
			
			// (0,0)부터 이동
			while(command[loc[0]][loc[1]]!='@') {
				char c = command[loc[0]][loc[1]];
				if(history[loc[0]][loc[1]]!=null &&
						(history[loc[0]][loc[1]].num==memory&&
						history[loc[0]][loc[1]].dr==dr&&
						history[loc[0]][loc[1]].dc==dc) 
						|| c=='.') {
					System.out.println("NO"); break;
				}
				history[loc[0]][loc[1]]=new History(memory,dr,dc);
				checkDir(c);
				checkNum(c);
				// 위치 업데이트
				loc[0] = (loc[0]+dr)%R;
				loc[1] = (loc[1]+dc)%C;
			}
			
			if(command[loc[0]][loc[1]]=='@') System.out.println("YES");
		}
		
		
	}
	public static void checkNum(char c) {
		int num = c-'0';
		if(num>=0 && num<=9) {
			memory=num;
		}
		else if(c=='+') {
			if(memory==15) memory=0;
			else memory++;
		}
		else if(c=='-') {
			if(memory==0) memory=15;
			else memory--;
		}
	}
	public static void checkDir(char c) {
		if(c=='<') {dr=0; dc=-1;}
		else if(c=='>') {dr=0; dc=1;}
		else if(c=='^') {dr=-1; dc=0;}
		else if(c=='v') {dr=1; dc=0;}
		else if(c=='_') {
			if(memory==0) {dr=0; dc=1;}
			else {dr=0;dc=-1;}
		}
		else if(c=='|') {
			if(memory==0) {dr=1; dc=0;}
			else {dr=-1;dc=0;}
		}
		else if(c=='?') {
			Random random = new Random();
			dr = random.nextInt(2); dc = random.nextInt(2);
		}
	}
}
