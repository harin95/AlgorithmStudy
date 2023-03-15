package AlgorithmStudy.Baekjoon.BSDSB;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BJ7568_덩치 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        int[][] input = new int[N][2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                input[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N; j++) {
                if(input[i][0] < input[j][0] && input[i][1] < input[j][1])
                    cnt++;
            }
            sb.append(cnt).append(" ");
        }
        bw.write(sb.toString());
        bw.close();
    }
}

