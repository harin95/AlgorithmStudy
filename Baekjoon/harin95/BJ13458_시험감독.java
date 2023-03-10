package AlgorithmStudy.Baekjoon.harin95;

import java.io.*;
import java.util.StringTokenizer;

public class BJ13458_시험감독 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] room = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) room[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int main = Integer.parseInt(st.nextToken());
		int sub = Integer.parseInt(st.nextToken());

		//문제 조건에서 최대로 나올 수 있는 감독관의 수가 int의 크기를 초과하기 때문에 long을 사용해야 한다
		long sum = 0L;
		
		sum += n;
		
		for(int student : room) {
			student -= main;

			//주감독관의 감시 외 인원이 있으면
			if(student > 0) {
				//부감독관을 할당
				sum += Long.valueOf(student%sub == 0 ? student/sub : student/sub + 1);
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(sum));
		bw.close();
	}
}
