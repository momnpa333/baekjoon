import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class _1929 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M=Integer.parseInt(st.nextToken()); int N=Integer.parseInt(st.nextToken());

        List<Integer> answerAry=new LinkedList<>();

        for(int i=M;i<N+1;i++){
            if(check(i)){
                answerAry.add(i);
            }
        }
        for(int value:answerAry){
            System.out.println(value);
        }

    }

    private static boolean check(int num){
        if (num==1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

}
