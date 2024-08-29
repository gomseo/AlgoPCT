import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		LinkedList<Integer> arr = new LinkedList<>();
		for(int i=0;i<N;i++) {
			arr.add(i+1);
		}
		
		int i=K-1;
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(!arr.isEmpty()) {
			sb.append(arr.get(i));
			arr.remove(i);
			if(arr.size()!=0) {
				int size = arr.size();
				// 앞에서 i번째 인덱스 값 삭제해줬기 때문에 i+K가 아닌 i+K-1,,
				i=(i+K-1)%size;	
				sb.append(", ");
			}
		}
		sb.trimToSize();
		sb.append(">");
		
		System.out.println(sb);
		
	}

}
