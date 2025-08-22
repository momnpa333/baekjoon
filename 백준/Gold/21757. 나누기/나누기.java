import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] seq;
    static long[] preSum;
    static long[][] dp;
    static double tar;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        preSum=new long[N+1];
        seq=new int[N];
        dp=new long[5][N+1];

        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            seq[i]=Integer.parseInt(st.nextToken());
            preSum[i+1]=preSum[i]+seq[i];
        }
        tar= (double) preSum[N] /4;

//        System.out.println(Arrays.toString(preSum));
        System.out.println(solve(1,N,4));
    }
    static long solve(int start,int end,int num){
        if(start>end){
            return 0;
        }
//        System.out.printf("%d %d %d\n",start,end,num);
        if(dp[num][start]!=0){
            return dp[num][start];
        }
        if(num==1){
            dp[num][start]=1;
            return 1;
        }
        long ret=0;
        for(int i=start;i<=end;i++){
            if(preSum[i]-preSum[start-1]==tar){
                ret+=solve(start,i,1)*solve(i+1,end,num-1);
            }
        }
        dp[num][start]=ret;
        return ret;
    }

}
