package AlgorithmStudy.Baekjoon.BSDSB;

import java.io.*;
import java.util.*;

public class BJ14235_크리스마스선물 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a == 0){ //a가 0일 때는 아이에게 선물을 줘야한다.
                if(pq.isEmpty()){ //pq가 비어있다면 선물을 줄 수 없으니 -1 출력
                    sb.append(-1).append("\n");
                }
                else { //pq가 비어있지 않다면 가치가 가장 높은 선물을 주면 된다.
                    sb.append(pq.poll()).append("\n");
                }
            }
            else{ //0이 아닌경우 거점에 들린거다.
                while(a-- != 0) {
                    pq.add(Integer.parseInt(st.nextToken())); //거점에서 a의 개수만큼 선물을 충전한다.
                }
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
}
