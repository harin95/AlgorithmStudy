package AlgorithmStudy.Baekjoon.BSDSB;

import java.io.*;
import java.util.StringTokenizer;

public class BJ1051_숫자정사각형 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //행
        int M = Integer.parseInt(st.nextToken()); //열

        int[][] mar = new int[N][M];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                mar[i][j] = Integer.parseInt(String.valueOf(tmp.charAt(j)));
            }
        }

        int min = Math.min(N,M); //정사각형을 위한 행 열중 작은 값 선택
        //(0,0) (0,2) (2,2) (2,0)
        while(min > 1){
            int row = 0;
            for (int i = 0; i < N-min+1; i++) {
                int col = 0;
                for (int j = 0; j < M-min+1; j++) {
                    if(mar[row][col] == mar[row][col+min-1] && mar[row][col] == mar[row+min-1][col+min-1] &&
                            mar[row][col] == mar[row+min-1][col] ){
                        System.out.println(min*min);
                        return;
                    }
                    col++;
                }
                row++;
            }
            min--;
        }
        System.out.println(min*min);
    }
}
