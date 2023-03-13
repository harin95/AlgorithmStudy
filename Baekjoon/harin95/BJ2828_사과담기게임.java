import java.util.*;
import java.io.*;

public class BJ2828_사과담기게임 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   //스크린 크기
        int m = Integer.parseInt(st.nextToken());   //바구니 크기
        int j = Integer.parseInt(br.readLine());    //사과 개수

        int[] screen = new int[n+1];

        //바구니 왼쪽, 오른쪽 위치 저장
        int left = 1;
        int right = m;
        int distance = 0;

        for(int i=0; i<j; i++){
            int position = Integer.parseInt(br.readLine());

            if(left<= position && position <= right) continue;  //바구니가 사과가 떨어지는 위치에 있는 경우

            //사과가 바구니보다 오른쪽에 떨어지는 경우
            else if(position > right){
                int move = position - right;
                right += move;
                left += move;
                distance += move;
            }

            //사과가 바구니보다 왼쪽에 떨어지는 경우
            else if(position < left){
                int move = left - position;
                left -= move;
                right -= move;
                distance += move;
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(distance));
        bw.close();
    }
}
