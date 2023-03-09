package AlgorithmStudy.Baekjoon.harin95;

import java.nio.Buffer;
import java.util.*;
import java.io.*;

public class Main_5622_다이얼 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int sum = 0;

        for(char c : input) sum += dialNumber(c);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(sum));
        bw.close();
    }

    private static int dialNumber(char c){
        int i = (int)c;

        if(i <= (int)'C') return 3;         //A~C는 3초
        else if(i <= (int)'F') return 4;    //D~F는 4초
        else if(i <= (int)'I') return 5;
        else if(i <= (int)'L') return 6;
        else if(i <= (int)'O') return 7;
        else if(i <= (int)'S') return 8;
        else if(i <= (int)'V') return 9;
        else return 10;
    }
}
