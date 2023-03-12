package AlgorithmStudy.Baekjoon.BSDSB;

import java.util.Scanner;
public class BJ2828_사과담기게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //스크린이 차지하는 칸
        int M = sc.nextInt(); //바구니가 차지하는 칸.
        int J = sc.nextInt(); //사과의 개수

        int apple[] = new int[J];
        for (int i = 0; i < J; i++) {
            apple[i] = sc.nextInt(); //사과가 떨어지는 위치
        }
        int left = 1; //왼쪽 포인터의 초기 값
        int right = M; //오른쪽 포인터의 초기 값

        int ans = 0; //결과
        for (int i = 0; i < J; i++) {
            if(apple[i] >= left && apple[i] <= right){ //떨어지는 사과가 바구니의 범위 내라면 이동수가 증가하지 않는다.
                ans += 0;
            }
            else if(right < apple[i]){ //사과가 오른쪽 포인터보다 더 뒤에 있는 경우
                left += apple[i] - right; // 왼쪽 포인터를 오른쪽 포인터가 움직인 만큼 이동시켜준다,
                ans += apple[i] - right; // 몇칸 움직였는지 넣어준다.
                right += apple[i] - right; // 오른쪽 포인터가 떨어지는 사과를 받을 수 있는 거리만큼 이동시켜준다,
            }
            else if(left > apple[i]){ //사과가 왼쪽 포인터보다 더 앞에 있는 경우
                right -= left - apple[i];
                ans += left - apple[i];
                left -= left - apple[i];
            }
        }
        System.out.println(ans);
    }
}
