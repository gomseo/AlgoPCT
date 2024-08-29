import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] time = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=0;n<N;n++) {
			time[n] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time);
		
		int sum=0;
		for(int n=0;n<N;n++) {
			sum+=(N-n)*time[n];
		}
		
		System.out.println(sum);
		
	}
}
