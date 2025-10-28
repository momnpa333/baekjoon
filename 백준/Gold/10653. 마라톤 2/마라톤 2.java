import java.io.*;
import java.util.*;

public class Main {
    static int N,K;
    static Item[] items;
    static int[][] dp;
    static int[][] prev;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        items=new Item[N];
        dp=new int[K+1][N];
        prev=new int[K+1][N];
        for(int i=0;i<=K;i++){
            Arrays.fill(dp[i],987654321);
        }
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            items[i]=new Item(x,y);
        }
        dp[0][0]=0;
        for(int i=1;i<N;i++){
            dp[0][i]=dp[0][i-1]+findDist(items[i-1],items[i]);
            prev[0][i]=i-1;
        }

        for(int j=1;j<=K;j++){
            for(int p=0;p<N;p++){
                dp[j][p]=dp[j-1][p];
                for(int n=j;n>=0;n--){
                    if(p-n-1<0) {
                        break;
                    }
                    dp[j][p]=Math.min(dp[j][p],dp[j-n][p-n-1]+findDist(items[p-n-1],items[p]));
                }
            }
        }

        System.out.println(dp[K][N-1]);
    }
    static int findDist(Item point1,Item point2){
        return Math.abs(point1.x-point2.x)+Math.abs(point1.y-point2.y);
    }
    static class Item{
        int x,y;
        Item(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}