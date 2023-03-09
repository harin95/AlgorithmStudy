package AlgorithmStudy.Baekjoon.BSDSB;

import java.util.Scanner;

public class _5622_다이얼 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String alpa = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String input = sc.next();
        int time = 0;

        for(int i = 0; i < input.length(); i++) {
            int tmp = alpa.indexOf(input.charAt(i));
            if(tmp >= 0 && tmp < 3){ //2
                time += 3;
            }
            else if(tmp >= 3 && tmp < 6){ //3
                time += 4;
            }
            else if(tmp >= 6 && tmp < 9){//4
                time += 5;
            }
            else if(tmp >= 9 && tmp < 12){//5
                time += 6;
            }
            else if(tmp >= 12 && tmp < 15){//6
                time += 7;
            }
            else if(tmp >= 15 && tmp < 19){//7
                time += 8;
            }
            else if(tmp >= 19 && tmp < 22){//8
                time += 9;
            }
            else if(tmp >= 22 && tmp < 26){//9
                time += 10;
            }
        }
        System.out.println(time);
    }
}
/*
Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int sum = 0;
        int i = 0;
        while (i < str.length()) {
            int cnt = 0;
            int num = 2;
            for (int j = 0; j < 8; j++) {
                if (j == 5 || j == 7) {
                    cnt += 4;
                } else {
                    cnt += 3;
                }
                num++;
                if (str.charAt(i) - 65 < cnt) {
                    sum += num;
                    break;
                }
            }
            i++;
        }
        System.out.print(sum);
 */
