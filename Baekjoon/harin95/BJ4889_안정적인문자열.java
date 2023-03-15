import java.util.*;
import java.io.*;

public class BJ4889_안정적인문자열 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuffer sb = new StringBuffer();
        String str = "";
        int cnt = 0;
        int tc = 1;
        String open = "{";
        String close = "}";

        Stack<String> stack = new Stack<>();

        while(true){
            str = br.readLine();
            if(str.contains("-")) break;
            for(int i=0; i<str.length(); i++){
                String s = String.valueOf(str.charAt(i));

                if(s.equals(open)) {
                    stack.push(s);   //여는 괄호는 스택에 넣는다
                }

                else if(s.equals(close)) {   //닫는 괄호라면
                    if (stack.isEmpty()) {    //스택이 비어있다면 짝을 맞출 수 없으므로
                        cnt++;  //여는 괄호로 바꾸고
                        stack.push(open);   //스택에 넣는다
                    } else {   //스택이 비어있지 않다면 꺼내서 짝을 맞춘다
                        stack.pop();
                    }
                }
            }
            //문자열 끝까지 갔는데
            if(!stack.isEmpty()) {   //스택이 비어있지 않다면 여는 괄호가 남아있는 것
                cnt += stack.size() / 2;  //여는 괄호의 절반을 닫는 괄호로 바꿔서 짝을 맞춘다
                stack.clear();
            }
            sb.append(tc++).append(". ").append(cnt).append("\n");
            cnt = 0;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.close();
    }
}
