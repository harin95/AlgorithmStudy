package AlgorithmStudy.Baekjoon.harin95;

import java.util.*;
import java.io.*;

public class Main_1541_잃어버린괄호 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        //더하기 연산을 먼저 한 후 빼기 연산을 했을 때 결과값이 최소가 된다
        String input = br.readLine();

        //더하기 연산만 있을 경우
        if(!input.contains("-")){
            String[] exp = input.split("\\+");  //더하기 연산을 기준으로 숫자를 나눈다
            int sum = 0;
            for(String num : exp){
                sum += add(num);    //더하기 연산 수행
            }
            sb.append(sum);
        }
        //빼기 연산이 포함된 경우
        else {
            String[] exp = input.split("-");    //빼기 연산을 기준으로 식을 나눈다
            int sum = 0;
            for(int i=0; i<exp.length; i++){
                int num = 0;
                if(exp[i].contains("+")){   //더하기 연산이 있다면 먼저 수행 후
                    num = add(exp[i]);
                }
                else num = Integer.parseInt(exp[i]);

                sum -= (i == 0) ? num*(-1) : num;   //빼준다 (첫번째 원소는 빼면 안되므로 -1 곱함
            }
            sb.append(sum);
        }
        bw.write(sb.toString());
        bw.close();
    }

    private static int add(String input){
        String[] exp = input.split("\\+");  //더하기 연산을 기준으로 숫자를 나눈다
        int sum = 0;
        for(String num : exp){
            sum += Integer.valueOf(num);
        }
        return sum;
    }
}
