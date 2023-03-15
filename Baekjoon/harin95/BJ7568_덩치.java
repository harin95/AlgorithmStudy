import java.util.*;
import java.io.*;

public class BJ7568_덩치 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        int[][] people = new int[n][2];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            people[i] = new int[]{weight, height};
        }

        //나보다 덩치큰 사람이 몇명인지 +1 이 나의 등수
        //사람 최대 50명이므로 이중반복문으로 탐색
        for(int i=0; i<n; i++){
            int[] current = people[i];
            int cnt = 0;

            for(int j=0; j<n; j++){
                int[] cmp = people[j];
                if(cmp[0] > current[0] && cmp[1] > current[1]){
                    cnt++;
                }
            }
            sb.append(cnt+1).append(" ");
            cnt = 0;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.close();
    }
}
