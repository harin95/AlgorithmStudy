package AlgorithmStudy.Baekjoon.BSDSB;

import java.io.*;
import java.util.*;

public class BJ16234_인구이동 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] nation;
    static int[] d_row = new int[]{0, 1, 0, -1}; //우 하 왼 상
    static int[] d_col = new int[]{1, 0, -1, 0}; //우 하 왼 상
    static int N, L, R;
    static boolean[][] visited;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // N*N 크기
        L = Integer.parseInt(st.nextToken()); //각 국가 인구차이 최소 범위
        R = Integer.parseInt(st.nextToken()); //각 국가 인구차이 최대 범위

        nation = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                nation[i][j] = Integer.parseInt(st.nextToken()); //국가별 인구 정보 입력
            }
        }
        int ans = 0; //결과를 담을 변수

        while(true) {
            flag = false; // 인구 차이가 조건에 맞아서 인구 이동 유무를 체크
            visited = new boolean[N][N]; //방문자 배열 생성
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                        bfs(new Node(i, j)); // bfs 진입
                    }
                }
            }
            if (flag) // 인구차이가 L이상 R이하를 만족했었는지 인구이동을 했는지 확인
                ans++;
            else
                break;
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    private static void bfs(Node node){
        Queue<Node> q = new ArrayDeque<>(); //큐 생성
        q.add(node); // 처음 좌표를 넣는다.
        visited[node.row][node.col] = true;

        ArrayList<Node> list = new ArrayList<>();
        list.add(node);
        int total = nation[node.row][node.col]; //현재 좌표 인구수
        int cnt = 1; // 몇개의 국가가 국경을 열었는지
        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int k = 0; k < 4; k++) {
                Node nx = new Node(cur.row + d_row[k], cur.col + d_col[k]); //상하 좌우 탐색

                if(!isIn(nx)) continue;
                if(visited[nx.row][nx.col]) continue; //범위가 벗어나거나 이미 방문했는지

                int abs = Math.abs(nation[cur.row][cur.col] - nation[nx.row][nx.col]); // 두 국가의 인구 차
                if(abs >= L && abs <= R){ //조건에 만족한다면
                    flag = true; //인구 이동이 있었고
                    visited[nx.row][nx.col] = true; //방문 처리 하고
                    q.add(nx); //큐에 넣고
                    list.add(nx);
                    total += nation[nx.row][nx.col]; //인구 수 더해주고
                    cnt++; // 국경수 넣어주고
                }
            }
        }
        if(flag){
            for (Node n : list) {
                nation[n.row][n.col] = total/cnt;
            }
        }
    }
    private static boolean isIn(Node n){ //범위 확인
        return n.row >= 0 && n.row < N && n.col >= 0 && n.col < N;
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

