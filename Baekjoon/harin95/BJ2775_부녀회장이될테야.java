package AlgorithmStudy.Baekjoon.harin95;

import java.util.*;
import java.io.*;

public class BJ2775_부녀회장이될테야 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){

            //배열 초기화
            int[][] apartment = new int[15][15];
            for(int i=1; i<=14; i++) apartment[0][i] = i;

            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            for(int i=1; i<=k; i++){
                int people = 0;
                for(int j=1; j<=n; j++){
                    if(j==1) apartment[i][j] = 1;   //1호는 항상 1명
                    else{
                        //1호가 아니라면 우리집 거주민은 내 앞 호수 + 아래층에 나와 같은 호수
                        apartment[i][j] = apartment[i][j-1] + apartment[i-1][j];
                    }
                }
            }
            System.out.println(apartment[k][n]);
        }
    }
}
