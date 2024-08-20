import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 숫자, 배열입력받기
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int n=0;n<N;n++) {
			arr[n]=sc.nextInt();
		}
		
		// 0 개수 세기
		int zeroCnt=0;
		for(int i=0;i<N;i++) {
			if(arr[i]==0) zeroCnt++;
		}
		
		// 배열이 다 0이면
		if(zeroCnt==arr.length) {
			System.out.println(zeroCnt);
			return;
		}
		
		// 배열 정렬, 중복값 제거
		Arrays.sort(arr);
		arr = Arrays.stream(arr).distinct().toArray();
//		System.out.println(Arrays.toString(arr));
		
		// 배열에 0이 없을 때
		if(zeroCnt==0) {
			int len=1, max=0;
			// 연속 배열 세기
			for(int i=0;i<arr.length-1;i++) {
				// i번째, i+1번째 값이 연속이면 len++
				if(arr[i+1]==arr[i]+1) len++;
				// 같지 않으면 max 업데이트
				else {
					if(len>max) {
						max=len; 
						}
					len=1;
					}
				// 혹은 배열이 끝나면 max 업데이트
				if(i==arr.length-2) {
					if(len>max) {
						max=len;
						}
					}
				}
			System.out.println(max); return;
		}
		
		// 배열에 0, 양수 섞여있을 때
		
		// 연속 숫자 개수 배열, 불연속 값 차이 배열 만들기
		List<Integer> serialCnt = new ArrayList<>();
		List<Integer> serialDiff = new ArrayList<>();
		
		int len=1;
		// 배열 중 양수값에서만 다음 시행
		for(int i=1;i<arr.length-1;i++) {
			// i번째, i+1번째 값이 연속이면 len++
			if(arr[i]+1==arr[i+1]) {
				len++;
				if(i==arr.length-2) { // 배열 마지막 값에서 한번 더 업데이트
					serialCnt.add(len);
				}
			}
			// 같지 않으면 serialCnt배열에 len값 추가, serialDiff값에 두 값 차이값 추가해주고 len=1로 초기화
			else {
				serialCnt.add(len);
				len=1;
				serialDiff.add(arr[i+1]-arr[i]-1);
				if(i==arr.length-2) { // 배열 마지막 값에서 한번 더 업데이트
					serialCnt.add(len);
				}
			}
		}
		
		// 모든 배열이 연속일때
		if(serialDiff.isEmpty()) {System.out.println(N);	return;}
		
		System.out.println(zeroCnt);
		System.out.println(Arrays.toString(serialCnt.toArray()));
		System.out.println(Arrays.toString(serialDiff.toArray()));
		
		// 최대값 배열 만들기
		List<Integer> answerArr = new ArrayList<>();
		int sum=serialCnt.get(0), zeroLeft=zeroCnt;
		for(int i=0;i<serialDiff.size();i++) {
			// 만약 간격값이 0 개수보다 작거나 같으면
			if(serialDiff.get(i)<=zeroCnt) {
				// 간격값이 0개수보다 커질때까지 반복
				for(int j=i;j<serialDiff.size();j++) {
					if(serialDiff.get(j)>zeroLeft) {break;}
					sum+=serialDiff.get(j)+serialCnt.get(j+1);
					zeroLeft-=serialDiff.get(j);
				}
				sum+=zeroLeft;
				answerArr.add(sum);
				sum=serialCnt.get(i);
			}
			// 간격값이 0 개수보다 크면
			else {
				sum+=zeroCnt;
				answerArr.add(sum);
				sum=serialCnt.get(i+1);
				if(i==serialDiff.size()-1) {
					answerArr.add(serialCnt.get(i+1)+zeroCnt);
				}				
			}
		}
		System.out.println(Arrays.toString(answerArr.toArray()));
		// 최대값 찾기
		int max=answerArr.get(0);
		for(int i=1;i<answerArr.size();i++) {
			if(answerArr.get(i)>max) {
				max=answerArr.get(i);
			}
		}
		System.out.println(max);
	}
}



