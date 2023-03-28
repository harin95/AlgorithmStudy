package AlgorithmStudy.Baekjoon.BSDSB;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ17413_단어뒤집기2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static Stack<Character> stack;
    public static void main(String[] args) throws IOException {
        String str = br.readLine();

        stack = new Stack<>();

        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '<'){ //여는 괄호를 만났다면
                concat(); //여는 괄호를 만날때 까지의 문자열을 뒤집어준다.
                sb.append(str.charAt(i)); //여는 괄호를 넣어준다.
                flag = true; // 닫는 괄호가 나올때까지 문자가 스택에 들어가지 않게 해준다.
                continue;
            }
            if(flag){
                if(str.charAt(i) =='>') {
                    sb.append(str.charAt(i));
                    flag = false;
                    continue;
                }
                sb.append(str.charAt(i)); //닫는 괄호가 아니라면 그대로 버퍼에 넣어준다.
                continue;
            }
            if(str.charAt(i) == ' ') { //띄어쓰기 기준으로 문자를 뒤집어준다.
                concat();
                sb.append(str.charAt(i));
                continue;
            }
            stack.push(str.charAt(i));//아무 조건도 충족하지 않은 문자를 스택에 넣는다.
        }
        concat();//남아있는 잔여 문자를 뒤집어준다.
        bw.write(sb.toString());
        bw.close();
    }
    public static void concat(){
        int size = stack.size();
        for (int j = 0; j < size; j++) {
            sb.append(stack.pop());
        }
    }
}