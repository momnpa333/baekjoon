import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2631 {
    static int N;
    static int[] seq;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(br.readLine());
        seq=new int[N];
        dp=new int[N];
        for(int i=0;i<N;i++){
            seq[i]=Integer.parseInt(br.readLine());
        }

        for(int i=0;i<N;i++){
            int cur=1;
            for(int j=0;j<i;j++){
                if(seq[j]<seq[i]){
                    cur=Math.max(cur,dp[j]+1);
                }
            }
            dp[i]=cur;
        }
//        System.out.println(Arrays.toString(dp));

        int max=0;
        for(int i=0;i<N;i++){
            max=Math.max(max,dp[i]);
        }
        System.out.println(N-max);


    }

}
