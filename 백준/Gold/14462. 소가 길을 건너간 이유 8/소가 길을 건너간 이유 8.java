import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int N;
    static int[] left;
    static int[] right;
    static int[][] dp;
    static final int INF=987654321;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        left=new int[N+1];
        right=new int[N+1];
        left[0]=INF;
        right[0]=INF;
        dp=new int[N+1][N+1];
        visited=new boolean[N+1];
        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine());
            left[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine());
            right[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<=N;i++){
            Arrays.fill(dp[i],INF);
        }
        for(int i=0;i<=N;i++){
            findMax(1,i);
        }
        for(int i=0;i<=N;i++){
            if(dp[1][i]!=INF)
                answer=Math.max(dp[1][i],answer);
//            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(answer);
    }
    public static boolean isFriend(int leftIdx,int rightIdx){
        if(Math.abs(left[leftIdx]-right[rightIdx])<=4){
            return true;
        }
        return false;
    }
    public static int findMax(int leftIdx,int rightIdx){
        if(dp[leftIdx][rightIdx]!=INF){
            return dp[leftIdx][rightIdx];
        }
        int ret=0;
        if(leftIdx==N||rightIdx==N){
            if(isFriend(leftIdx,rightIdx))
                ret=1;
            dp[leftIdx][rightIdx]=ret;
            return ret;
        }

        for(int i=leftIdx;i<N;i++){
            ret=Math.max(ret,findMax(i+1,rightIdx+1));
        }
        for(int j=rightIdx+1;j<=N;j++){
            ret=Math.max(ret,findMax(leftIdx+1,j));
        }

        if(isFriend(leftIdx,rightIdx)) ret+=1;
        dp[leftIdx][rightIdx]=ret;
        return ret;
    }
}

