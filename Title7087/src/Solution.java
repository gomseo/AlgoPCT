import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());		
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(sc.nextLine());
			
			// 문자열의 맨 앞글자만 set로 가져오기
			// HashSet : 중복 허용X, 순서 정렬O
			Set<Character> set = new HashSet<>();
			for(int n=0;n<N;n++) {
				set.add(sc.nextLine().charAt(0));
			}
//			System.out.println(set);
			
			// Set -> Array로 변환
			Character[] arr = set.toArray(new Character[0]);
//			System.out.println((int) arr[0]);
			if(arr[0]!='A') {
				System.out.println("#"+t+" 0");
				continue;
			}else {
				int cnt=1;
				for(int i=0;i<arr.length-1;i++) {
					if(arr[i]!=arr[i+1]-1) {
						break;
					}
					cnt++;
				}
				System.out.println("#"+t+" "+cnt);
				
			}
		}
		
		
	}

}
