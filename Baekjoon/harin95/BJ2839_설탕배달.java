package AlgorithmStudy.Baekjoon.harin95;

import java.io.*;

public class BJ2839_설탕배달 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int answer = 0;

        //최대로 가져가야하기 때문에 우선 5로 나눈다
        int qby5 = n / 5;     //몫
        int rby5 = n % 5;     //나머지

        if(rby5 % 3 == 0){  //5로 나눈 나머지가 3의 배수라면 3키로로 들고간다
            answer = qby5 + rby5 / 3;
        }
        else {  //5로 나눈 나머지가 3의 배수가 아니라면
            while(true) {
                if(--qby5 < 0){     //5kg짜리를 하나 뺀다 (음수가 되면 5와 3으로 만들 수 없는 경우)
                    answer = -1;
                    break;
                }
                rby5 += 5;  //5kg를 하나 덜어냈으므로 나머지에 5를 추가해준다
                if (rby5 % 3 == 0){     //나머지가 3의 배수라면 3키로로 들고간다
                    answer = qby5 + (rby5/3);
                    break;
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.close();
    }
}
