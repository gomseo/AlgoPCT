import java.util.Scanner;

public class Main {
	
	static int M;
	static boolean[] chulmin, hi, bi;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M =sc.nextInt();
		
		// 3명은 11시~12시 사이에 약속장소에 도착
//		int[] timeline = new int[60+M+1];
		chulmin = new boolean[121];
		hi = new boolean[121];
		bi = new boolean[121];
		
		int cnt=0;
		for(int i=0;i<=60;i++) {
			timeline(i,chulmin);
			for(int j=0;j<=60;j++) {
				timeline(j,hi);
				for(int k=0;k<=60;k++) {
					timeline(k,bi);
					for(int time=0;time<=60;time++) {
						if(chulmin[time]&&hi[time]&&bi[time]) {
							cnt++;break;
						}
					}
					bi = new boolean[121];
				}
				hi = new boolean[121];
			}
			chulmin = new boolean[121];
		}
		System.out.println(cnt%(61*61*61));
		
	}
	static void timeline(int arrive, boolean[] arr) {
		for(int i=arrive;i<=arrive+M;i++) {
			arr[i]=true;
		}
	}
}
