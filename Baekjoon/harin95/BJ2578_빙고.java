import java.util.*;
import java.io.*;

public class BJ2578_빙고 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        HashMap<Integer, int[]> bingo = new HashMap<>();
        int[] game = new int[25];
        int[] row = new int[5];
        int[] col = new int[5];
        int diagonal1 = 0;
        int diagonal2 = 0;
        int cnt = 0;

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingo.put(Integer.parseInt(st.nextToken()), new int[]{i, j});
            }
        }

        int idx = 0;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                game[idx++] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<game.length; i++){
            int[] p = bingo.get(game[i]);
            int r = p[0], c = p[1];

            if(++row[r] == 5) cnt++;
            if(++col[c] == 5) cnt++;
            if(r+c==4 && diagonal1<5){
                if(++diagonal1 == 5) cnt++;
            }
            if(r==c && diagonal2<5){
                if(++diagonal2 == 5) cnt++;
            }
            if(cnt >= 3) {
                System.out.println(i+1);
                return;
            }
        }
    }
}