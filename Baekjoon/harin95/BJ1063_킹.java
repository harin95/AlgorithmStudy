package AlgorithmStudy.Baekjoon.harin95;

import java.io.*;
import java.util.*;

public class BJ1063_킹 {

    private static HashMap<String, int[]> move;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        //입력좌표는 열, 행 String으로 들어온다
        //행, 열로 좌표 바꾸기
        // char '1' = int 49
        // char 'A' = int 65

        //king
        int[] king = new int[]{8 - ((int)input[0].charAt(1)-48), (int)input[0].charAt(0)-65};
        int[] stone = new int[]{8 - ((int)input[1].charAt(1)-48), (int)input[1].charAt(0)-65};
        int n = Integer.parseInt(input[2]);

        //move
        //명령어 마다 이동해야 하는 칸 저장
        move = new HashMap<>();
        move.put("R", new int[]{0, 1});
        move.put("L", new int[]{0, -1});
        move.put("B", new int[]{1, 0});
        move.put("T", new int[]{-1, 0});
        move.put("RT", new int[]{-1, 1});
        move.put("LT", new int[]{-1, -1});
        move.put("RB", new int[]{1, 1});
        move.put("LB", new int[]{1, -1});


        for(int i=0; i<n; i++){
            String command = br.readLine();
            int[] next = move.get(command);
            int r = next[0]; int c = next[1];

            if((king[0]+r == stone[0]) && king[1]+c == stone[1]){   //king이 움직였을때 돌과 같은 위치라면
                //돌을 킹의 방향과 같은 방향으로 한칸 움직인다
                //돌과 킹이 움직인 후 체스판 벗어나지 않을때만 움직인다
                if(isIn(king[0]+r, king[1]+c) && isIn(stone[0]+r, stone[1]+c)){
                    king[0] += r; king[1] += c;
                    stone[0] += r; stone[1] += c;
                }
            }
            else{
                //킹이 움직였을 때 돌과 같은 위치가 아니라면 킹만 움직인다
                if(isIn(king[0]+r, king[1]+c)){
                    king[0] += r; king[1] += c;
                }
            }
        }

        //원래 좌표로 변환
        int kingr = 8-king[0]; char kingc = (char)(king[1]+65);
        int stoner = 8-stone[0]; char stonec = (char)(stone[1]+65);

        StringBuffer sb = new StringBuffer();
        sb.append(kingc).append(kingr).append("\n").append(stonec).append(stoner).append("\n");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.close();
    }

    private static boolean isIn(int r, int c){
        if(r<0 || r>=8 || c<0 ||c>=8) return false;
        return true;
    }
}
