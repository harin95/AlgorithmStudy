package AlgorithmStudy.Baekjoon.BSDSB;

import java.io.*;
import java.util.StringTokenizer;

public class BJ1063_킹 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static char[] king, ston;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        king = st.nextToken().toCharArray(); //킹의 위치
        ston = st.nextToken().toCharArray(); //돌의 위치
        int N = Integer.parseInt(st.nextToken());

        String[] move = new String[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            move[i] = st.nextToken();
        }

        for (int i = 0; i < N; i++) {
            if (move[i].equals("R")) {
                if ((char)(king[0] + 1) == ston[0] && king[1] == ston[1]) { //내가 갈려는 방향에 돌이 있다면
                    if (ston_isIn((char) (ston[0] + 1), ston[1])) { //이동할 돌이 체스판 범위를 벗어나는지 확인
                        ston[0] = (char) (ston[0] + 1); //벗어나지 않는다면 돌을 이동.
                        king[0] = (char) (king[0] + 1); //킹도 이동
                    }
                }
                else{ //이동하려는 방향에 돌이 없다면
                    if (king_isIn((char) (king[0] + 1), king[1])) { //킹이 체스판 범위를 벗어나는지 확인
                        king[0] = (char) (king[0] + 1); //벗어나지 않는다면 킹을 이동
                    }
                }
            }

            else if (move[i].equals("L")) {
                if ((char) (king[0] - 1) == ston[0] && king[1] == ston[1]) {
                    if (ston_isIn((char) (ston[0] - 1), ston[1])) {
                        ston[0] = (char) (ston[0] - 1);
                        king[0] = (char) (king[0] - 1);
                    }

                }
                else {
                    if (king_isIn((char) (king[0] - 1), king[1])) {
                        king[0] = (char) (king[0] - 1);
                    }
                }
            }

            else if (move[i].equals("B")) {
                if (king[0] == ston[0] && (char) (king[1] - 1) == ston[1]) {
                    if (ston_isIn(ston[0], (char)(ston[1] - 1))) {
                        ston[1] = (char) (ston[1] - 1);
                        king[1] = (char) (king[1] - 1);
                    }
                }
                else{
                    if (king_isIn(king[0], (char) (king[1] - 1))) {
                        king[1] = (char) (king[1] - 1);
                    }
                }
            }

            else if (move[i].equals("T")) {
                if (king[0] == ston[0] && (char) (king[1] + 1) == ston[1]) {
                    if (ston_isIn(ston[0], (char)(ston[1] + 1))){
                        ston[1] = (char) (ston[1] + 1);
                        king[1] = (char) (king[1] + 1);
                    }
                }
                else {
                    if (king_isIn(king[0], (char) (king[1] + 1))) {
                        king[1] = (char) (king[1] + 1);
                    }
                }
            }

            else if (move[i].equals("RT")) {
                if ((char) (king[0] + 1) == ston[0] && (char) (king[1] + 1) == ston[1]) {
                    if (ston_isIn((char)(ston[0] + 1), (char) (ston[1] + 1))) {
                        ston[0] = (char) (ston[0] + 1);
                        ston[1] = (char) (ston[1] + 1);
                        king[0] = (char) (king[0] + 1);
                        king[1] = (char) (king[1] + 1);
                    }
                }
                else{
                    if (king_isIn((char) (king[0] + 1), (char) (king[1] + 1))) {
                        king[0] = (char) (king[0] + 1);
                        king[1] = (char) (king[1] + 1);
                    }
                }
            }

            else if (move[i].equals("LT")) {
                if ((char) (king[0] - 1) == ston[0] && (char) (king[1] + 1) == ston[1]) {
                    if (ston_isIn((char) (ston[0] - 1), (char) (ston[1] + 1))) {
                        ston[0] = (char) (ston[0] - 1);
                        ston[1] = (char) (ston[1] + 1);
                        king[0] = (char) (king[0] - 1);
                        king[1] = (char) (king[1] + 1);
                    }
                } else {
                    if (king_isIn((char) (king[0] - 1), (char) (king[1] + 1))) {
                        king[0] = (char) (king[0] - 1);
                        king[1] = (char) (king[1] + 1);
                    }
                }
            }

            else if (move[i].equals("RB")) {
                if ((char) (king[0] + 1) == ston[0] && (char) (king[1] - 1) == ston[1]) { //내가 갈려는 방향에 돌이 있다면
                    if (ston_isIn((char) (ston[0] + 1), (char) (ston[1] - 1))) { //돌이 범위 안인지 확인
                        ston[0] = (char) (ston[0] + 1); //돌을 이동
                        ston[1] = (char) (ston[1] - 1);
                        king[0] = (char) (king[0] + 1); //킹을 이동
                        king[1] = (char) (king[1] - 1);
                    }
                }
                else { //내가 가려는 방향에 돌이 없다면 킹만 이동
                    if (king_isIn((char) (king[0] + 1), (char) (king[1] - 1))) {
                        king[0] = (char) (king[0] + 1);
                        king[1] = (char) (king[1] - 1);
                    }
                }
            }

            else if (move[i].equals("LB")) {
                if ((char) (king[0] - 1) == ston[0] && (char) (king[1] - 1) == ston[1]) {
                    if (ston_isIn((char) (ston[0] - 1), (char) (ston[1] - 1))) {
                        ston[0] = (char) (ston[0] - 1);
                        ston[1] = (char) (ston[1] - 1);
                        king[0] = (char) (king[0] - 1);
                        king[1] = (char) (king[1] - 1);
                    }
                }
                else{
                    if (king_isIn((char) (king[0] - 1), (char) (king[1] - 1))) {
                        king[0] = (char) (king[0] - 1);
                        king[1] = (char) (king[1] - 1);
                    }
                }
            }
        }
        sb.append(king[0]).append(king[1]).append("\n");
        sb.append(ston[0]).append(ston[1]).append("\n");
        bw.write(sb.toString());
        bw.close();
    }
    public static boolean king_isIn(char k1, char k2){
        return k1 >= 'A' && k1 <= 'H' && k2 >= '1' && k2 <= '8';
    }
    public static boolean ston_isIn(char s1, char s2){
        return s1 >= 'A' && s1 <= 'H' && s2 >= '1' && s2 <= '8';
    }
}
