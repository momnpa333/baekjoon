import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _30802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());

        int[] sizeAry= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        st= new StringTokenizer(br.readLine()," ");
        int T = Integer.parseInt(st.nextToken()); int P=Integer.parseInt(st.nextToken());

        int answerT=0; int answerP=0; int answerR=0;

        for (int size:sizeAry){
            if(size%T!=0){
                answerT+=size/T+1;
            }
            else{
                answerT+=size/T;
            }
        }
        answerP=N/P; answerR=N%P;

        System.out.println(answerT);
        System.out.printf("%d %d",answerP,answerR);

    }

}
