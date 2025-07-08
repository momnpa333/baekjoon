import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class _1918 {
    static char[] exp;
    static String answer="";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayDeque<Character> stack=new ArrayDeque<>();
        exp=st.nextToken().toCharArray();


        for(char item :exp){
//            System.out.println("!"+item);
            if(Character.isAlphabetic(item)){
                answer+=Character.toString(item);
            }
            else{
                if(item==')'){
                    while(true){
                        char ex=stack.pollLast();
                        if(ex=='('){
                            break;
                        }
                        answer+=Character.toString(ex);
                    }
                }
                else if(item=='+' || item=='-'){
                    while(!stack.isEmpty()){
                        char ex=stack.pollLast();
                        if(ex=='('){
                            stack.add(ex);
                            break;
                        }
                        answer+=Character.toString(ex);
                    }
                    stack.add(item);
                }
                else if(item=='*' || item=='/'){
                    while(!stack.isEmpty()){
                        char ex=stack.pollLast();
                        if(ex=='('){
                            stack.add(ex);
                            break;
                        }
                        if(ex=='+' || ex=='-'){
                            stack.add(ex);
                            break;
                        }
                        answer+=Character.toString(ex);
                    }
                    stack.add(item);
                }
                else {
                    stack.add(item);
                }
            }
        }

        while(!stack.isEmpty()){
            char ex=stack.pollLast();
            answer+=Character.toString(ex);
        }

        System.out.println(answer);
    }


}
