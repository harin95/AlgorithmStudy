import java.util.*;
import java.io.*;

public class BJ16234_인구이동 {

    static int n, L, R;
    static int[][] people, connected;
    static boolean[][] visited;
    static int[] drow = new int[]{-1, 1, 0, 0};
    static int[] dcol = new int[]{0, 0, -1, 1};
    static Map<Integer, Integer> avgmap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        //입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        people = new int[n][n];
        connected = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                people[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //입력 끝

        int moveCnt = 0;    //인구 이동 회수
        int unionNum = 0;   //반복문 탈출 조건

        while(true) {
            unionNum = checkUnion();    //연합 체크
            movePeople();   //연합별로 인구 이동
            if(unionNum == n*n) break;  //연합의 개수가 n*n과 같으면 연합이 존재하지 않음 -> 탈출
            moveCnt++;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(moveCnt));
        bw.close();
    }

    //땅 전체 연합 탐색
    private static int checkUnion(){
        int[] start = new int[]{0, 0};
        int unionNum = 0;

        while(start != null){
            findUnion(start, unionNum);
            start = findNextStart();
            unionNum++;
        }
        return unionNum;
    }

    private static void findUnion(int[] start, int unionNum){
        /*
        * BFS
        * 시작점에서 인구 차이가 L이상 R이하여서 연결된 나라를 탐색
        * 0, 0에서 출발해서 4방 탐색, 연결되어 있으면 connected 배열에 같은 숫자로 표시
        * */

        Queue<int[]> q = new ArrayDeque<>();

        //시작점 넣고 방문체크
        int sr = start[0], sc = start[1];
        q.add(new int[]{sr, sc});
        visited[sr][sc] = true;
        connected[sr][sc] = unionNum;

        double sum = people[sr][sc];    //연합 인구 총합
        int cnt = 1;    //연합 나라 개수

        while(!q.isEmpty()){
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];
            int p = people[r][c];   //현재 나라 인구 수

            for(int d=0; d<4; d++){
                int nr = r + drow[d];
                int nc = c + dcol[d];

                if(!isIn(nr, nc)) continue;

                int np = people[nr][nc];    //비교 나라 인구 수
                int sub = Math.abs(p - np);

                if(L <= sub && sub <= R && !visited[nr][nc]){   //방문하지 않았고 인구차가 범위에 포함되면 탐색 진행
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});

                    //연합지역 표시, 저장
                    connected[nr][nc] = unionNum;
                    //연합에 포함된 나라 수 카운트
                    cnt++;
                    //인구 합계 계산
                    sum += np;
                }
            }
        }
        //연합별로 평균 값 저장
        avgmap.put(unionNum, (int) (Math.floor(sum/cnt)));
    }

    private static int[] findNextStart(){
    //아직 방문하지 않은 새 시작점 찾기
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private static void movePeople(){
    //각 연합별로 인구 이동 시킴
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                people[i][j] = avgmap.get(connected[i][j]);
            }
        }
        //초기화
        avgmap.clear();
        for(boolean[] arr : visited) Arrays.fill(arr, false);
        for(int[] arr : connected) Arrays.fill(arr, 0);
    }

    private static boolean isIn(int r, int c){
        if(r<0 || c<0 || r>=n || c >=n) return false;
        return true;
    }
}
