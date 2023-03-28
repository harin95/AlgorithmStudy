package AlgorithmStudy.Baekjoon.BSDSB;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BJ2161_카드1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }
        int cnt = 1;
        while(!q.isEmpty()){
            if(cnt % 2 != 0){
                sb.append(q.poll()).append(" ");
            }
            else{
                q.add(q.poll());
            }
            cnt++;
        }
        System.out.println(sb.toString());
    }
}
