package ant;

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine()); //StringTokenizer인자값에 입력 문자열 넣음
		int w = Integer.parseInt(st.nextToken()); //첫번째 호출
		int h = Integer.parseInt(st.nextToken());

		StringTokenizer s = new StringTokenizer(bf.readLine());
		int p = Integer.parseInt(s.nextToken()); //첫번째 호출
		int q = Integer.parseInt(s.nextToken());
		int t = bf.read();

        int x = (p + t)%(2 * w);    // 시간에 따른 개미의 x 변위
        int y = (q + t)%(2 * h);    // 시간에 따른 개미의 y 변위
        
        if (x > w) {                // 반사될 때의 조건 반영
            x = 2*w - x;
        }
        if (y > h) {                // x 충돌과 y 충돌1은 독립적 : 별도의 if
            y = 2*h - y;
        }

        System.out.println(x + " " + y);
    }
}