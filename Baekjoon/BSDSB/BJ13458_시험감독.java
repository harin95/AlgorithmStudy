package AlgorithmStudy.Baekjoon.BSDSB;

import java.io.*;
import java.util.StringTokenizer;

public class BJ13458_시험감독 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //시험장 개수

        int[] room = new int[N]; //각각의 방에서 시험보는 응시자수
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            room[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int king = Integer.parseInt(st.nextToken()); //총 감독관이 감사할 수 있는 인원
        int vice = Integer.parseInt(st.nextToken()); // 부 감독관이 감시할 수 있는 인원

        long result = 0;
        for(int i = 0 ; i < N; i++) {
            if(room[i] <= king){ //총감독관 혼자 가능한 경우
                result += 1;
            }
            else if((room[i] - king) % vice != 0) {
//                result += (room[i] - king) / vice;
//                result += 1; //방에서 총 감독관이 감시할 수있는 인원이 빠진 상태에서 부 감독관이 감시 할 수 있는 인원으로 나누었을때 나누어 떨어지지 않았다면 1명 추가
                result += (room[i] - king + vice - 1)/ vice;
                result += 1; //총감독관
            }
            else if((room[i] - king) % vice == 0){
//                result += (room[i] - king) / vice; //0으로 나누어 떨어지면 부감독관의 인원만 추가.
                result += (room[i] - king + vice - 1)/ vice;
                result += 1; //총감독관 추가.
            }
        }
        sb.append(result);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
