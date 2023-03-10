package AlgorithmStudy.Baekjoon.BSDSB;

import java.io.*;
import java.util.*;

public class BJ1966_프린터큐 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()); //테스트 케이스

        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int p_cnt = Integer.parseInt(st.nextToken()); //문서의 개수
            int question = Integer.parseInt(st.nextToken()); //궁금한 문서
            Queue<Node> q = new ArrayDeque<>(); //큐입니다.

            ArrayList<Integer> list = new ArrayList<>(); //중요도가 저장될 리스트

            st = new StringTokenizer(br.readLine ());
            for(int i = 0 ; i < p_cnt ; i++){
                int imp = Integer.parseInt(st.nextToken()); //문서의 개수 만큼 중요도 입력
                list.add(imp);
                q.add(new Node(i,imp)); //큐에 문서 번호와 해당 문서의 중요도를 같이 저장한다.
            }
            Collections.sort(list); //중요도 순으로 정렬
            int cnt = 0; //몇번째로 출력될 것인지 센다.

            int last_size = list.size() - 1; //오름차순으로 정렬했으니 가장 마지막이 제일 중요한 넘버
            while(!q.isEmpty()){ //큐가 비지 안을 때 까지
                if(list.get(last_size) == q.peek().important) { //중요도가 가장 높다면 큐에서 빼준다.
                    last_size--; //가장 중요한 문서가 출력되었으니 다음으로 중요한 문서의 중요도 체크
                    cnt++; //출력한 횟수
                    if(q.peek().num == question) // 자신이 뽑은 문서가 원하는 문서라면 스탑
                        break;
                    q.poll();// 출력한 문서는 제거
                }
                else{
                    q.add(q.poll()); //중요도가 높지 않기 때문에 다시 q에 넣어준다.
                }
            }
            sb.append(cnt).append("\n");//결과 적립
        }
        bw.write(sb.toString());//결과 출력
        bw.close();
    }
    static class Node{
        int num; //문서 번호
        int important; //중요도
        public Node(int num, int important) {
            this.num = num;
            this.important = important;
        }
    }
}