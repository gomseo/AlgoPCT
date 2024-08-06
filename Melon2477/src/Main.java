import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int dir[] = new int[6];
		int len[] = new int[6];
		
		for(int i=0;i<6;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dir[i]=Integer.parseInt(st.nextToken());
			len[i]=Integer.parseInt(st.nextToken());
		}
		
		// 배열 2배하기
		int dir2[] = new int[12];
		int len2[] = new int[12];
		for(int i=0;i<12;i++) {
			dir2[i]=dir[i%6];
			len2[i]=len[i%6];
		}
		
//		System.out.println(Arrays.toString(dir2));
//		System.out.println(Arrays.toString(len2));
		
		// 동1 서2 남3 북4
		// 232423
		int bigbox = 0;
		int smallbox = 0;
		
		for(int i=1;i<8;i++) {
			if(dir2[i]==dir2[i+2] && dir2[i+1]==dir2[i+3]) {
				smallbox = len2[i+1]*len2[i+2];
				bigbox = len2[i-1]*len2[i+4];
			}
		}
		
		System.out.println((bigbox-smallbox)*N);
		
		
		
	}

}
