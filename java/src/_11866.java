import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class _11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N=Integer.parseInt(st.nextToken()); int M=Integer.parseInt(st.nextToken());

        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i=1;i<=N;i++){
            linkedList.add(i);
        }
        int cur=0;
        List<Integer> answerList=new ArrayList<>();

        while (!linkedList.isEmpty()){
            for(int i=0;i<M-1;i++){
                cur=(cur+1)% linkedList.size();
            }
            answerList.add(linkedList.remove(cur));
        }

        StringBuilder answer= new StringBuilder("<");

        for (Integer value:answerList){
            answer.append(value);
            answer.append(", ");
        }
        answer.delete(answer.length()-2,answer.length());
        answer.append(">");
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
