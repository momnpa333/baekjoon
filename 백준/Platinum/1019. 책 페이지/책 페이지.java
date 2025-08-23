import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static long[][] dp;
    static long N;
    static long[] answer;
    static long[] sub;
    static String n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n=br.readLine();
        N=Long.parseLong(n);

        answer=new long[10];
        sub=new long[11];
        sub[1]=1;
        dp=new long[11][10];

        dp[1]= new long[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        for(int i=2;i<=10;i++){
            makeDp(i);
        }

        long tmp=N;
        for(int i=n.length();i>0;i--){
            solve(i, (int) (tmp/Math.pow(10,i-1)));
            tmp%= (long) Math.pow(10,i-1);
        }
        answer[0]-=sub[n.length()-1];
        if(n.length()==1){
            answer[0]=0;
        }

        for(int i=0;i<10;i++){
            bw.write(answer[i]+" ");
        }
//
//        for(int i=0;i<10;i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }
//        System.out.println(Arrays.toString(sub));
        bw.flush();

    }
    static void solve(int idx,int num){
        if(idx>1){
            if(idx!=n.length()){
                for(int i=0;i<num;i++){
                    answer[i]+=(long)Math.pow(10,idx-1);
                }
            }
            else{
                for(int i=1;i<num;i++){
                    answer[i]+=(long)Math.pow(10,idx-1);
                }
            }
            answer[num]+=N%(long)Math.pow(10,idx-1);
            for(int i=0;i<10;i++){
                answer[i]+=dp[idx-1][i]*num;
            }
//            answer[0]-=sub[idx-1];
            answer[num]+=1;
        }
        else{
            for(int i=0;i<=num;i++){
                answer[i]+=1;
            }
        }
    }

    static void makeDp(int n){
        for(int i=1;i<10;i++){
            dp[n][i]=dp[n-1][i]*10+(long)Math.pow(10,n-1);
        }
        long s=0;
        long f=9*(long)Math.pow(10,n-2);
        for(long i=1;i<=n;i++){
            s+=f*i;
            f=Math.max(1,f/10);
        }
        sub[n]=s;
        dp[n][0]=dp[n][1];
    }
}
