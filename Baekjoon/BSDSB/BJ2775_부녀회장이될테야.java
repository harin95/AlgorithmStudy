package AlgorithmStudy.Baekjoon.BSDSB;

import java.util.Scanner;

public class BJ2775_부녀회장이될테야 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 0; tc < T; tc++){
            int k = sc.nextInt(); //층
            int n = sc.nextInt(); //호

            int[][] dp = new int[k+1][n+1];
            for(int i = 1; i <= n; i++){
                dp[0][i] = i;
            }
            for(int i = 1; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    for(int o = 1; o <= j ; o++) {
                        dp[i][j] += dp[i-1][o];
                    }
                }
            }
            System.out.println(dp[k][n]);
        }
    }
}
/*
2
1
3
2
3

 */