package AlgorithmStudy.Baekjoon.BSDSB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2606_바이러스 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static ArrayList<Integer>[] adjList;
    static boolean visited[];
    static int com,edge;
    public static void main(String[] args) throws IOException {
        com = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());

        adjList = new ArrayList[com+1];
        visited = new boolean[com+1];
        for (int i = 0; i <= com; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }
        System.out.println(bfs(1));
    }
    private static int bfs(int start) {
        Queue<Integer> q = new ArrayDeque();
        q.add(start);
        visited[start] = true;
        int ans = 0;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int v : adjList[cur]){
                if(visited[v]) continue;
                q.add(v);
                visited[v] = true;
                ans++;
            }
        }
        return ans;
    }
}
