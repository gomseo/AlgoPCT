import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
 
public class Reference {
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] dr = {-1, 1, 0, 0, -1, 1, -1, 1};
        int[] dc = {0, 0, -1, 1, 1, -1, -1, 1};
        OUT:
        for (int i = 0; i < T; i++) {
             
            int N = Integer.parseInt(br.readLine());
            char[][] badukBoard = new char[N][N];
             
            for (int j = 0; j < badukBoard.length; j++) {
                String temp = br.readLine();
                for (int k = 0; k < badukBoard.length; k++) {
                    badukBoard[j][k] = temp.charAt(k);
                }
            }
 
            for (int j = 0; j < badukBoard.length; j++) {
                for (int k = 0; k < badukBoard.length; k++) {
                    if(badukBoard[j][k] == 'o') {
                        for (int k2 = 0; k2 < 8; k2+=2) {
                            int check = 0;
                            int nr = j;
                            int nc = k;
                            for (int l = 0; l < 2; l++) {
                                nr += dr[k2];
                                nc += dc[k2];
                                if(nr >= 0 && nr < N && nc >= 0 && nc < N && badukBoard[nr][nc] == 'o') {
                                    check++;
                                }
                            }
                            nr = j;
                            nc = k;
                            for (int l = 0; l < 2; l++) {
                                nr += dr[k2+1];
                                nc += dc[k2+1];
                                if(nr >= 0 && nr < N && nc >= 0 && nc < N && badukBoard[nr][nc] == 'o') {
                                    check++;
                                }
                            }
                            if(check == 4) {
                                bw.write("#"+(i+1)+" "+"YES\n");
                                continue OUT;
                            }
                        }
                    }
                }
            }
            bw.write("#"+(i+1)+" "+"NO\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}