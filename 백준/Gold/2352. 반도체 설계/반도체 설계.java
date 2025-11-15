import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] seq;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        seq=new int[N+1];
        dp=new int[N+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        int ans=0;
        st=new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            seq[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=N;i++){
            int id=Arrays.binarySearch(dp,seq[i]);
            dp[-1*(id+1)]=seq[i];
        }
//        System.out.println(Arrays.toString(dp));
        for(int i=1;i<=N;i++){
            if(dp[i]!=Integer.MAX_VALUE) ans=i;
        }
        System.out.println(ans);

    }
}