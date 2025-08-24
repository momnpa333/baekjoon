import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dp;
    static int[] num;
    static int[] seq;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        dp=new int[N];
        num=new int[N+1];

        seq=new int[N];
        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            seq[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            dp[i]=num[seq[i]-1]+1;
            num[seq[i]]=num[seq[i]-1]+1;
            ans=Math.max(dp[i],ans);
        }

        System.out.println(N-ans);

        

    }
}
