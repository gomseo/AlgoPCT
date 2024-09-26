import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Reference {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] paper = new boolean[101][101];
        
        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            for (int i = x; i < x + 10; i++) {
                for (int j = y; j < y + 10; j++) {
                    paper[i][j] = true;
                }
            }
        }
        
        int perimeter = 0;
        
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (paper[i][j]) {
                    // 각 셀의 4면을 체크하여 경계선을 계산
                    if (i == 0 || !paper[i-1][j]) perimeter++; // 위쪽
                    if (i == 100 || !paper[i+1][j]) perimeter++; // 아래쪽
                    if (j == 0 || !paper[i][j-1]) perimeter++; // 왼쪽
                    if (j == 100 || !paper[i][j+1]) perimeter++; // 오른쪽
                }
            }
        }
        
        System.out.println(perimeter);
    }
}
