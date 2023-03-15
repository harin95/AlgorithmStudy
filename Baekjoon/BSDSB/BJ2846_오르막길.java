package AlgorithmStudy.Baekjoon.BSDSB;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2846_오르막길 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] road = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if(min > road[i]) {
                min = road[i];
            }
            if(road[i] >= road[i+1]) {
                ans = Math.max(road[i] - min, ans);
                min = Integer.MAX_VALUE;
            }
        }
        System.out.println(ans);
    }
}

