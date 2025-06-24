import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class _4889 {
    static Map<String,Integer> score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayDeque<String> dq= new ArrayDeque<>();
        score=new HashMap<>();
        score.put("{}",2); score.put("{{",1); score.put("}}",1); score.put("}{",0);

        int cnt=1;
        while(true){
            String input=br.readLine();
            if(input.contains("-")){
                break;
            }
            System.out.printf("%d. %d\n",cnt++, solve(input));
        }

    }
    static int solve(String input){
        ArrayDeque<Character> dq= new ArrayDeque<>();
        int answer=0;

        for(char c:input.toCharArray()){
            if(!dq.isEmpty()&&c=='}'&& dq.peekLast()=='{'){
                dq.pollLast();
            }
            else{
                dq.add(c);
            }
        }
//        System.out.println(dq);
        while(!dq.isEmpty()){
            String tmp="";
            tmp+=dq.pollLast();
            tmp+=dq.pollLast();
            answer+=score.get(tmp);
        }
        return answer;
    }



}
