package AlgorithmStudy.Baekjoon.BSDSB;

import java.util.Scanner;

public class BJ17608_막대기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int cnt = sc.nextInt();
        int[] arr = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            arr[i] = sc.nextInt();
        }
        int high = arr[cnt-1];
        int ans = 1;
        for (int i = cnt - 2; i >= 0; i--) {
            if(high < arr[i]){
                high = arr[i];
                ans++;
            }
        }
        System.out.println(ans);
    }
}
