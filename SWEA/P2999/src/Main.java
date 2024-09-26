import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int r=0, c=0;
		for(int i=1;i*i<=str.length();i++) {
			if(str.length()%i==0) {
				r=i;
				c=str.length()/i;
			}
		}
		
		// r X c 배열에 메세지 담기
		int[][] arr = new int[r][c];
		int cnt=0;
		for(int j=0;j<c;j++) {
			for(int i=0;i<r;i++) {
				arr[i][j]=str.charAt(cnt++);
			}
		}
		
		// 해독
		String Answer="";
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				Answer+=Character.toString(arr[i][j]);
			}
		}
		
		System.out.println(Answer);
		
	}

}
