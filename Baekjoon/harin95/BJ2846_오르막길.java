import java.util.*;
import java.io.*;

public class BJ2846_오르막길 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] road = new int[n+1];  //마지막 오르막길도 계산하기 위해 크기를 1 크게 잡고 0으로 둔다
        for(int i=0; i<n; i++){
            road[i] = Integer.parseInt(st.nextToken());
        }   //입력

        int start = road[0];    //부분수열의 시작점
        int prev = start;   //현재와 비교할 이전 숫자
        int height = 0;     //오르막길의 높이

        for(int i=1; i<=n; i++){
            int num = road[i];
            if(prev < num){     //현재가 이전 숫자보다 크다면
                prev = num;
                continue;    //증가 수열이므로 다음 숫자로 넘어간다
            }
            else if(prev >= num){    //현재가 이전 숫자보다 작다면 증가 수열 끝남
                height = Math.max(height, prev-start);  //높은 높이로 갱신
                start = num;    //시작점 바꾸기
                prev = num;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(height));
        bw.close();
    }
}
