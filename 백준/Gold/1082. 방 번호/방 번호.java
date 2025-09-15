import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] cost;
    static int money;
    static String[] dp;
    static String ans="";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(st.nextToken());
        cost = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        money = Integer.parseInt(br.readLine());
        dp=new String[money+1];
        Arrays.fill(dp,"");

        for(int i=0;i<=money;i++){
            for(int j=0;j<N;j++){
                if(i+cost[j]<=money){
                    if(dp[i].equals("0")){
                        continue;
                    }
                    dp[i+cost[j]]=compareS(dp[i+cost[j]],dp[i]+j);
                }
            }
        }
        if(dp[money].equals("")){
            System.out.println(0);
            return;
        }
        System.out.println(dp[money]);

    }
    static String compareS(String A,String B){
//        System.out.println(A);
//        System.out.println(B);
        if(A==null) return B;
        if(B==null) return A;
        if(A.length()>B.length()) return A;
        if(B.length()>A.length()) return B;
        if(A.compareTo(B)>0){
            return A;
        }
        else{
            return B;
        }
    }

}
