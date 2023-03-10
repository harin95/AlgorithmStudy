package AlgorithmStudy.Baekjoon.BSDSB;

import java.util.Scanner;

public class BJ2839_설탕배달 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int five = N/5;
        int ans = 0;
        for(int i = five ; i >= 0; i--){
            int cur = N - i * 5;

            if(cur % 3 == 0){
                ans = cur/3 + i;
                break;
            }
            else{
                ans = -1;
            }
        }
        System.out.println(ans);
    }
}
/*
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        sb.append(cal(N));
        bw.write(sb.toString());
        bw.close();
    }

    public static int cal(int n) {
        int five_store = n/5;
        for(int i = five_store ; i >= 0; i--){
            int tmp = n - 5 * i;

            if(tmp % 3 == 0){
                return i + (tmp/3);
            }
        }
        return -1;
    }
}
 */