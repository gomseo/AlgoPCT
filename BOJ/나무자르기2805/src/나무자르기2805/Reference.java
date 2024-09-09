package 나무자르기2805;

import java.util.Arrays;
import java.util.Scanner;

public class Reference {

    static int N, M;
    static long[] tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        tree = new long[N];
        for (int i = 0; i < N; i++) {
            tree[i] = sc.nextInt();
        }
        Arrays.sort(tree);
        System.out.println(find(0, tree[N - 1])); // 최대 길이를 출력
    }

    // 이진 탐색
    static long find(long start, long end) {
        long result = 0;  // 최대 높이를 저장할 변수
        
        while (start <= end) {
            long mid = start + (end - start) / 2;  // 중간값 계산
            long sum = 0;

            // mid 높이로 나무를 잘랐을 때 얻을 수 있는 나무 길이 계산
            for (int i = 0; i < N; i++) {
                if (tree[i] > mid) {
                    sum += tree[i] - mid;
                }
            }

            // 얻은 나무의 합이 M보다 크거나 같으면, 더 큰 높이로 시도해본다.
            if (sum >= M) {
                result = mid;  // 가능한 높이를 기록
                start = mid + 1;  // 더 큰 높이 시도
            } else {
                end = mid - 1;  // 더 낮은 높이 시도
            }
        }

        return result;  // 최대 높이 반환
    }
}
