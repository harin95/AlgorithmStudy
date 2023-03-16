package AlgorithmStudy.Baekjoon.BSDSB;

import java.io.*;
import java.util.StringTokenizer;

public class BJ2167_2차원배열의합 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //행
        int M = Integer.parseInt(st.nextToken()); //열

        int[][] matrix = new int[N+1][M+1]; //행렬
        int[][] accum = new int[N+1][M+1]; //구간합이 관리되는 행렬

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0; //구간합을 구하기 위한 변수, 행마다 구간합을 구하기 위해 초기화
            for (int j = 1; j <= M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                sum += matrix[i][j]; //구간합
                accum[i][j] = sum;
            }
        }
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); //K개

        for (int g = 0; g < K; g++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int ans = 0;
            for (int o = i; o <= x; o++) {
                ans += accum[o][y] - accum[o][j-1]; // i행부터 x행까지. j좌표부터 y좌표까지 사각형 구간을 더해준다.
            }
            sb.append(ans).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}

