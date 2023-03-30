package AlgorithmStudy.Baekjoon.BSDSB;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ14719_빗물 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();
    static int[] area;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken()); //높이
        int W = Integer.parseInt(st.nextToken()); //땅 길이

        area = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            area[i] = Integer.parseInt(st.nextToken());
        }
        //1. 현재 블록이 기준으로 왼쪽에서 가장 높은 블록과 오른쪽에서 가장 높은 블록을 찾는다.
        //2. 현재 블록이 좌우 블록 보다 낮은지 확인
        //3. 좌우 블록중 더 낮은 블록에서 현재 블록 높이를 빼서 빗물이 고인 높이를 구한다.
        int water = 0;
        for (int i = 0; i < W; i++) {
            int left = 0;
            int right = 0;
            int cur = area[i];
            for (int j = i+1; j < W; j++) {
                right = Math.max(area[j], right);
            }
            for (int j = i-1; j >= 0; j--) {
                left = Math.max(area[j], left);
            }
            if(right > cur && left > cur) {
                water += Math.min(right, left) - cur;
            }
        }
        System.out.println(water);
    }
}
