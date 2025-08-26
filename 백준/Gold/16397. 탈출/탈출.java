import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N,T,G;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        T=Integer.parseInt(st.nextToken());
        G=Integer.parseInt(st.nextToken());

        dp=new int[100000];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[N]=0;
        ArrayDeque<int[]> pq=new ArrayDeque<>();
        pq.add(new int[]{0,N});

        if(N==G){
            System.out.println(0);
            return;
        }

        while(!pq.isEmpty()){
            int[] item=pq.poll();
//            System.out.printf("%d %d\n",item[0],item[1]);
            if(item[0]>=T){
                break;
            }
            if(item[1]+1<100000 && dp[item[1]+1]==Integer.MAX_VALUE){
                if(item[1]+1==G){
                    System.out.println(item[0]+1);
                    return;
                }
                dp[item[1]+1]=item[0]+1;
                pq.add(new int[]{item[0]+1,item[1]+1});
            }
            if(item[1]!=0 && item[1]*2<100000){
                int tmp= (int) (item[1]*2-Math.pow(10,(int)Math.log10(item[1]*2)));
//                System.out.println(tmp);
//                System.out.println(Math.pow(10,Math.log10(item[1]*2)));
                if(tmp==G){
                    System.out.println(item[0]+1);
                    return;
                }
                if(dp[tmp]==Integer.MAX_VALUE){
                    dp[tmp]=item[0]+1;
                    pq.add(new int[]{item[0]+1,tmp});
                }
            }
        }
        System.out.println("ANG");
    }
}
