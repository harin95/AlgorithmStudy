package AlgorithmStudy.Baekjoon.BSDSB;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BJ10974_모든순열 {
    static int N, numbers[];
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        numbers = new int[N];
        visited = new boolean[N+1];
        dfs(0);
        bw.write(sb.toString());
        bw.close();
    }
    private static void dfs(int cnt){
        if(N == cnt){
            for(int i = 0 ; i < N ; i++){
                sb.append(numbers[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1 ; i <= N ;i++){
            if(visited[i]) continue;
            visited[i] = true;
            numbers[cnt] = i;
            dfs(cnt + 1);
            visited[i] = false;

        }
    }
}
