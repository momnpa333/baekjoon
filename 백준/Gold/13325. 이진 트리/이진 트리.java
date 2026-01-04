import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] w;
    static int[] dp;
    static int max;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        M= (int) (Math.pow(2,N+1)-2);
        w=new int[M+1];
        dp=new int[M+1];
        st=new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=M;i++){
            w[i]=Integer.parseInt(st.nextToken());
        }
        max=findMax(0);
        solve(1,max);
        solve(2,max);
//        System.out.println(Arrays.toString(w));
        for(int i=0;i<=M;i++){
            answer+=w[i];
        }
        System.out.println(answer);
    }
    static void solve(int idx,int parentW){
        if(idx>M) return;
        int curMax=dp[idx]-w[idx];
        w[idx]=parentW-curMax;
        solve(idx*2+1,parentW-w[idx]);
        solve(idx*2+2,parentW-w[idx]);

    }
    static int findMax(int idx){
        if(idx>M){
            return 0;
        }
        int ret=0;
        ret=Math.max(ret,findMax(idx*2+1)+w[idx]);
        ret=Math.max(ret,findMax(idx*2+2)+w[idx]);
        dp[idx]=ret;
        return ret;
    }

}


