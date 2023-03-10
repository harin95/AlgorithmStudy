package AlgorithmStudy.Baekjoon.harin95;

import java.util.*;
import java.io.*;

public class BJ1966_프린터큐 {

    //문서를 객체로 만든다
    private static class Document{
        int number, priority;

        public Document(int number, int priority) {
            this.number = number;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        //입력

        for(int tc=1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());   //문서의 개수
            int m = Integer.parseInt(st.nextToken());   //궁금한 문서의 위치

            Queue<Document> q = new ArrayDeque<>(); //프린터 큐
            int[] pritorityArr = new int[n];    //문서의 우선순위 저장
            st = new StringTokenizer(br.readLine());

            for(int i=0; i<n; i++){
                int p = Integer.parseInt(st.nextToken());
                q.add(new Document(i, p));  //프린터 큐에 문서 생성해서 넣고
                pritorityArr[i] = p;    //우선순위는 배열에 저장해둔다
            }

            Arrays.sort(pritorityArr);  //우선순위 오름차순으로 정렬
            int idx = n-1;  //마지막 인덱스가 최대 우선순위
            int print = 0;  //프린트 된 문서의 개수 카운트

            while(true){
                Document current = q.poll();    //프린터 큐에서 문서를 뽑아서
                if(pritorityArr[idx] == current.priority){  //가장 높은 우선순위인지 확인하고
                    print++;    //맞다면 프린트
                    if(current.number == m){    //알고싶은 위치의 문서라면
                        sb.append(print).append("\n");  //순서 출력
                        break;
                    }
                    idx--;  //다음 최대 우선순위로 변경
                }
                else{
                    q.add(current);     //우선 순위가 낮으면 다시 큐로 들어간다
                }
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
}
