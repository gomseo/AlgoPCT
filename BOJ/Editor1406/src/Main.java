import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 시간 초과, 노드로 구현해야 할 것 같다
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		List<Character> arr = new LinkedList<>();
		for(int i=0;i<str.length();i++) {
			arr.add(str.charAt(i));
		}
		
		// 커서 초기값 설정
		int cursor = str.length();
		
		int M = Integer.parseInt(br.readLine());
		for(int m=0;m<M;m++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			if(c=='L') {
				if(cursor!=0) {
					cursor--;
				}
			}else if(c=='D') {
				if(cursor!=arr.size()) {
					cursor++;
				}
			}else if(c=='B') {
				if(cursor!=0) {
					arr.remove(--cursor);
				}
			}else if(c=='P') {
				arr.add(cursor++,st.nextToken().charAt(0));
			}	
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<arr.size();i++) {
			sb.append(arr.get(i).toString());			
		}
		System.out.println(sb);
		
	}
}
