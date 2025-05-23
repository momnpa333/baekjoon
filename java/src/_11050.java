import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");

        int N=Integer.parseInt(st.nextToken()); int K=Integer.parseInt(st.nextToken());

        int up=1; int down=1;
        for (int i=N;i>N-K;i--){
            up*=i;
        }
        for (int i=1;i<=K;i++){
            down*=i;
        }

//        System.out.printf("%d",up/down);
        bw.write(Integer.toString(up/down));
        bw.flush();
        bw.close();



    }
}
