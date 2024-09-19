package 이전순열10973;

import java.util.*;

public class Reference {

    static int[][] check = new int[30][30];
    
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 0 || b == 0) System.out.println(0);
            else System.out.println(combination(b, a));
        }
    }

    static int combination(int a, int b){
        if (a == b || b == 0) return 1;
        if (check[a][b] != 0) return check[a][b];
        else return check[a][b] = combination(a - 1, b - 1) + combination(a - 1, b);
    }
}

// 천...천재다..!