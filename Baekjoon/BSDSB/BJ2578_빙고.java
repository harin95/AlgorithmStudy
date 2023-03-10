package AlgorithmStudy.Baekjoon.BSDSB;

import java.io.*;
import java.util.StringTokenizer;

public class BJ2578_빙고 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] matrix;
    public static void main(String[] args) throws IOException {
        matrix = new int[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] call = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                call[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        boolean flag = false;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (matrix[k][l] == call[i][j]) {
                            matrix[k][l] = -1;
                            ans++;
                            break;
                        }
                    }
                }
                if(bingo() >= 3) {
                    flag = true;
                    break;
                }
            }
            if(flag)
                break;
        }
        System.out.println(ans);
    }
    private static int bingo() {
        int bingo_cnt = 0;
        int cnt_dia = 0;
        int cnt_redia = 0;
        for (int i = 0; i < 5; i++) {
            int cnt_row = 0;
            int cnt_col = 0;
            for (int j = 0; j < 5; j++) {
                 if (matrix[i][j] == -1) //행
                    cnt_row++;

                if (matrix[j][i] == -1) //열
                    cnt_col++;

                if(i == j)
                    if (matrix[i][i] == -1) //대각
                        cnt_dia++;
                if(i == 4 - j){
                    if (matrix[i][j] == -1) //역대각
                        cnt_redia++;
                }
            }
            if(cnt_row == 5)
                bingo_cnt++;
            if(cnt_col == 5)
                bingo_cnt++;
        }
        if(cnt_dia == 5)
            bingo_cnt++;
        if(cnt_redia == 5)
            bingo_cnt++;

        return bingo_cnt;
    }
}
