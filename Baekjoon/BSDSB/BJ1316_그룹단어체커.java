package AlgorithmStudy.Baekjoon.BSDSB;

import java.io.*;
import java.util.StringTokenizer;

public class BJ1316_그룹단어체커 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static String alph = "abcdefghijklmnopqrstuvwxyz"; //알파벳

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 단어 입력

        String[] input = new String[N]; //단어들이 입력될 배열
        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }
        int ans = 0; //연속 단어 개수 확인

        for (int i = 0; i < N; i++) {
            boolean flag = true;
            char tmp = input[i].charAt(0); //첫알파벳
            boolean[] visited = new boolean[26]; //방문한 알파벳은 방문처리하기 위한 배열
            visited[alph.indexOf(input[i].charAt(0))] = true; //방문 한 것은 방문 처리

            for (int j = 1; j < input[i].length(); j++) {
                if (tmp == input[i].charAt(j)) continue; //전과 같은 알파벳이라면 다음으로 넘어감

                if(visited[alph.indexOf(input[i].charAt(j))]) { //이미 방문했던 알파벳을 또 방문했다면 더이상 연속된 단어가 아님
                    flag = false;
                    break;
                }
                tmp = input[i].charAt(j); //전위치 알파벳 갱신
                visited[alph.indexOf(input[i].charAt(j))] = true; //방문처리
            }
            if(flag)
                ans++; //연속된 알파벳이라면 개수 증가
        }
        sb.append(ans);
        bw.write(ans);
        bw.close();
        br.close();
    }
}
