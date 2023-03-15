package AlgorithmStudy.Baekjoon.BSDSB;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16918_봄버맨 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] d_row = new int[]{0, 1, 0, -1}; //우 하 왼 상
    static int[] d_col = new int[]{1, 0, -1, 0}; //우 하 왼 상
    static Queue<Node> q = new ArrayDeque<>();
    static char[][] map;
    static int R,C;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); //row
        C = Integer.parseInt(st.nextToken()); //column
        int N = Integer.parseInt(st.nextToken()); //N초
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = tmp.charAt(j);
                if(map[i][j] == 'O') {
                    q.add(new Node(i, j)); // 폭탄이 있는 곳을 q에 넣어둔다.
                }
            }
        }
        int time = 1; // 초기 시간
        if(N == time); //초기 시간 그대로라면 초기 상태로 출력
        else {
            while (true) { //정해진 시간이 될 때까지 반복
                for (int j = 0; j < R; j++) {
                    Arrays.fill(map[j], 'O'); //모든 칸에 폭탄 세팅
                }
                time++; // 모든 칸에 폭탄 세팅 한 시간
                if(time == N)
                    break;
                bfs(); //폭탄 터트리러 가자.
                time++; //폭탄 터짐
                if(time == N)
                    break;
            }
        }
        answer(); //결과 저장
        bw.write(sb.toString());
        bw.close();
    }
    private static void bfs(){
        while(!q.isEmpty()){
            Node cur = q.poll();
            map[cur.row][cur.col] = '.'; //폭탄의 현재위치에서 터트림

            for (int k = 0; k < 4; k++) { //상하 좌우로 다 터트림
                Node nx = new Node(cur.row + d_row[k], cur.col + d_col[k]);
                if(!isIn(nx)) continue;
                map[nx.row][nx.col] = '.';
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == 'O')
                    q.add(new Node(i,j)); //남아있는 폭탄의 위치를 저장
            }
        }
    }
    private static boolean isIn(Node n){
        return n.row >= 0 && n.row < R && n.col >= 0 && n.col < C;
    }
    private static void answer(){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
    }
    static class Node{
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}