import java.util.Scanner;

public class Main2 {	
	// 그리디 -> 통과
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
				
		if(N%5==0) {
			System.out.println(N/5);
		}else {
			int m = N/5;
			if((N-m*5)%3==0) {
				System.out.println((m+(N-m*5)/3));
				return;
			}else {
				m--;
				int i=0;
				while(m>=0&&i<3) {
					if((N-m*5)%3==0) {
						System.out.println((m+(N-m*5)/3));
						return;
					}
					m--;
					i++;
				}				
			}
			if(N%3==0) {
				System.out.println(N/3);
			}else {
				System.out.println(-1);
			}
				
		}	
	}

}
