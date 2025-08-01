import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1011 {
    static int T;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dp=new long[100001];
        for(int i=1;i<100000;i++){
            dp[i]=dp[i-1]+i/2+i%2;
        }
        T=Integer.parseInt(st.nextToken());
        while(T-->0){
            st=new StringTokenizer(br.readLine()," ");
            int x=Integer.parseInt(st.nextToken()); int y=Integer.parseInt(st.nextToken());
            for(int i=1;i<100000;i++){
                if((y-x)<=dp[i]){
                    System.out.println(i);
                    break;
                }
            }
        }


    }
}
