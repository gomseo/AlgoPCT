import java.util.*;

public class Main11 {
    static int N;
    static int[] pop;
    static ArrayList<Integer>[] link;
    static boolean[] team;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        pop = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            pop[i] = sc.nextInt();
        }

        link = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            link[i] = new ArrayList<Integer>();
            int J = sc.nextInt();
            for (int j = 0; j < J; j++) {
                link[i].add(sc.nextInt());
            }
        }

        // 구역 나누기
        team = new boolean[N + 1];
        team(1);  // 첫 번째 구역부터 시작
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);  // 답이 갱신되지 않으면 -1 출력
    }

    // 팀을 나누는 재귀 함수
    static void team(int idx) {
        if (idx == N + 1) {
            if (check() && connected()) {
                int sum1 = 0, sum2 = 0;
                for (int i = 1; i <= N; i++) {
                    if (team[i]) sum1 += pop[i];
                    else sum2 += pop[i];
                }
                ans = Math.min(ans, Math.abs(sum1 - sum2));
            }
            return;
        }

        // 현재 idx 구역을 첫 번째 팀에 배정
        team[idx] = true;
        team(idx + 1);

        // 현재 idx 구역을 두 번째 팀에 배정
        team[idx] = false;
        team(idx + 1);
    }

    // 두 팀으로 나눠졌는지 체크
    static boolean check() {
        int cnt1 = 0, cnt2 = 0;
        for (int i = 1; i <= N; i++) {
            if (team[i]) cnt1++;
            else cnt2++;
        }
        return cnt1 > 0 && cnt2 > 0;  // 두 팀이 모두 한 명 이상 포함된 경우 true
    }

    // 두 팀이 각각 연결되어 있는지 확인
    static boolean connected() {
        return bfs(true) && bfs(false);  // 첫 번째 팀과 두 번째 팀 각각 연결성 확인
    }

    // 해당 팀이 연결되어 있는지 확인하는 BFS 함수
    static boolean bfs(boolean teamType) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        // 해당 팀에 속한 첫 번째 구역을 찾아서 큐에 넣음
        int start = -1;
        for (int i = 1; i <= N; i++) {
            if (team[i] == teamType) {
                start = i;
                break;
            }
        }

        if (start == -1) return false;  // 해당 팀에 속한 구역이 없는 경우

        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : link[curr]) {
                if (!visited[next] && team[next] == teamType) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }

        // 해당 팀에 속한 모든 구역이 방문되었는지 확인
        for (int i = 1; i <= N; i++) {
            if (team[i] == teamType && !visited[i]) {
                return false;
            }
        }

        return true;
    }
}
