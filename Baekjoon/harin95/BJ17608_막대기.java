
import java.io.*;

public class BJ17608_막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int h = arr[n-1];
        int cnt = 1;    //마지막 막대기는 일단 보이니까 1로 시작

        for(int i=n-1; i>=0; i--){
            if(arr[i] > h) {    //마지막 막대기보다 높으면 보인다
                h = arr[i];     //높이 기준 갱신
                cnt++;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(cnt));
        bw.close();
    }
}