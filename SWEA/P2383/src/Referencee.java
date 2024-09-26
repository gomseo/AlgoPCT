import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
 
public class Referencee {
    static class Person implements Comparable<Person>{
        int r, c; // 사람의 좌표
        int[] dist; // 계단까지의 거리 : 계단은 반드시 2개만 존재
        int sel; // 내가 선택한 계단
 
        public Person(int r, int c) {
            super();
            this.r = r;
            this.c = c;
            this.dist = new int[2];
        }
 
        @Override
        public int compareTo(Person o) {
            return dist[sel] - o.dist[sel];
        }
    }
 
    static class Stair {
        int r, c, time; // 좌표와 계단을 내려가는데 걸리는 시간
 
        public Stair(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
 
    static int N, ans;
    static int[][] map;
 
    // 사람의 정보를 저장하기위해서 Array / ArrayList :최대 10명인지는 아는데, 몇명인지몰라서
    static List<Person> pList;
    // 계단의 정보를 저장하기위해서 Array / ArrayList :반드시 2개인건 아니까
    static Stair[] stairs;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
 
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            map = new int[N][N];
 
            stairs = new Stair[2];
            int sidx = 0;
            pList = new ArrayList<>();
            // 입력을 받자.
            // 입력받은 값이 1인 경우 : 사람리스트에 추가
            // d입력받은 값이 1보다 크면 계단으로
            ans = 987654321;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    if (map[i][j] == 1) { // 사람 입력
                        pList.add(new Person(i, j));
                    } else if (map[i][j] > 1) {
                        stairs[sidx++] = new Stair(i, j, map[i][j]);
                    }
                }
            } // 입력 다했다.
 
            // 각 사람별 계단까지의 거리를 계산하자.
            for (int i = 0; i < pList.size(); i++) {
                for (int j = 0; j < stairs.length; j++) {
                    // 사람 리스트에서 i번째 사람을 가져와서 그사람의 j번째 계단의 거리는
                    // 계단 앞 대기
                    pList.get(i).dist[j] = Math.abs(pList.get(i).r - stairs[j].r)
                            + Math.abs(pList.get(i).c - stairs[j].c) + 1;
                }
            }
             
            powerset(0);
            System.out.println("#"+tc+" "+ans);
 
        } // tc
    }// main
 
    private static void powerset(int idx) {
        if(idx == pList.size()) {
            //모든 사람의 계단 배정을 위한 시간 테이블
            int[][] timeTable = new int[2][200];
            //각 계단별로 먼저온 사람들을 타임테이블을 고려하면 좋겠다.
            PriorityQueue<Person>[] pq = new PriorityQueue[2];
            pq[0] = new PriorityQueue<>();
            pq[1] = new PriorityQueue<>();
            //사람들을 본인의 계단 우선순위큐에 넣자.
            for(int i = 0 ; i<pList.size(); i++) {
                pq[pList.get(i).sel].add(pList.get(i));
            }
             
            int tmp = 0;
            //계단 순서대로 수행해보자.
            for(int i = 0 ; i<stairs.length; i++) {
                 
                int to = 0; //해당 사람이 타임테이블에서 끝나는 시간
                //각 계단의 큐를 비울때까지 사람들을 내려보내보자.
                while(!pq[i].isEmpty()) {
                    Person p = pq[i].poll();
                    int from = p.dist[p.sel]; //선택한 계단까지의 거리부터 계단을 내려가야한다.
                    to = from + stairs[p.sel].time; //계단 높이만큼 머문다.
                    //타임테이블에 표시 고고씽
                    for(int j = from; j <to; j++) {
                        if(timeTable[p.sel][j] == 3) {
                            //3명이 꽉찼다. 기다려
                            to++;
                            continue;
                        }
                        timeTable[p.sel][j]++; //해당 계단의 해당 시간에 내려가는 사람이 있어요~~
                    }
                }
                if(tmp < to)
                    tmp = to;
            }
            ans = Math.min(ans, tmp);
            return;
        }
         
        //재귀 호출 부분 ?????
        pList.get(idx).sel = 0; //idx번쨰 자리의 사람에게 계단 0번을 지정
        powerset(idx+1);
        pList.get(idx).sel = 1; //idx번쨰 자리의 사람에게 계단 1번을 지정
        powerset(idx+1);
    }//powerset
 
}
