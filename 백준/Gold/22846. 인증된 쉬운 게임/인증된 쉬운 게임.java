import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    static int K;
    static int monitor=1;
    static boolean dp[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        K=Integer.parseInt(st.nextToken());
        dp=new boolean[K+1];

        for(int i=K-1;i>=1;i--){
            dp[i]=isWin(i);
        }
        if (dp[1])
            System.out.println("Kali");
        else {
            System.out.println("Ringo");
        }
    }
    static boolean isWin(int num){
        if(dp[num]) return true;
        for(int i=1;i<=Math.sqrt(num);i++){
            if(num%i==0 && num+i<=K && !dp[num + i]){
                dp[num]=true;
                return true;
            }//!dp[num + num / i]
            else if(num%i==0 && num+num/i<=K && !dp[num + num/i]) {
                dp[num] = true;
                return true;
            }
        }
        return false;
    }
}