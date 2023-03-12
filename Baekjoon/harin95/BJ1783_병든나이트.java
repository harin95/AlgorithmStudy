package AlgorithmStudy.Baekjoon.harin95;

import java.util.*;
import java.io.*;

public class BJ1783_병든나이트 {

    private static int n, m;
    private static int movecnt = 1;
    private static int[][] moveAmount = new int[][]{{-2, 1}, {-1, 2}, {1, 2}, {2, 1}};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        StringBuffer sb = new StringBuffer();

        int[] knight = new int[]{n-1, 0};   //시작점

        //세로3이상, 가로7이상일때 4가지 이동 방법을 모두 1번씩 쓸 수 있다.
        //4가지 방법을 한번씩 사용한 뒤 (처음 4가지 방법을 이용하면 5칸 방문)
        //1, 4 이동을 반복하면 최대 방문 (7번 행부터 m-1번행까지 한칸씩 방문 = (m-1)-7+1개 방문)
        //5 + (m-1)-7+1 = m-2

        if(n>=3 && m>=7){
            movecnt = m-2;
        }

        //조건을 만족하지 않을 경우 최대 4칸까지 방문할 수 있다 (5칸 이상이면 4가지 방법 모두 사용해야 하므로)
        //세로 길이만 만족한다면 1, 4 이동방법을 반복해야 최대 4까지 가능
        else if(n>=3 && m<7){
            while(true){
                if(!moveKnight(knight, 0) || movecnt == 4) break;
                if(!moveKnight(knight, 3) || movecnt == 4) break;
            }
        }
        //세로 길이를 만족하지 않으면 2, 3 이동방법을 반복해야 최대 4까지 가능
        else if(n<3){
            while(true){
                if(!moveKnight(knight, 1) || movecnt == 4) break;
                if(!moveKnight(knight, 2) || movecnt == 4) break;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(movecnt));
        bw.close();
    }

    //이동 메서드
    private static boolean moveKnight(int[] knight, int mode){
        int r = moveAmount[mode][0];
        int c = moveAmount[mode][1];

        if(isIn(knight[0]+r, knight[1]+c)){
            knight[0]+=r;
            knight[1]+=c;
            movecnt++;
            return true;
        }
        return false;
    }


    //범위 체크 메서드
    private static boolean isIn(int r, int c){
        if(r<0 || r>=n || c<0 || c>=m) return false;
        return true;
    }
}
