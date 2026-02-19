import java.io.*;
import java.util.*;

public class Main {
    static String target;
    static int[] dp;
    static int N;
    static final int INF=987654321;
    static String[] words;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; //= new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        target=br.readLine();
        st=new StringTokenizer(br.readLine()," ");
        N=Integer.parseInt(st.nextToken());
        words=new String[N];
        for(int i=0;i<N;i++){
            words[i]=br.readLine();
        }

        int L=target.length();
        dp=new int[L+1];
        Arrays.fill(dp,INF);
        dp[0]=0;

        for(int i=1;i<=L;i++){
            for(int j=0;j<N;j++){
                if(i-words[j].length()<0) continue;
                if(!isPossible(target.substring(i- words[j].length(),i),words[j])) continue;
                dp[i]=Math.min(dp[i-words[j].length()]+calc(target.substring(i-words[j].length(),i),words[j]),dp[i]);
            }
        }
        if (dp[L] == INF) {
            System.out.println(-1);
            return;
        }
        System.out.println(dp[L]);
    }
    static boolean isPossible(String A,String B){
        int[] cntA=new int[26];
        int[] cntB=new int[26];
//        System.out.println(A+" "+B);

        for(int i=0;i<A.length();i++){
            cntA[A.charAt(i) -'a']++;
        }
        for(int i=0;i<B.length();i++){
            cntB[B.charAt(i) -'a']++;
        }
//        System.out.println(Arrays.toString(cntA));
//        System.out.println(Arrays.toString(cntB));
        for(int i=0;i<26;i++){
            if(cntB[i]>cntA[i]){
                return false;
            }
        }
        return true;
    }
    static int calc(String A,String B){
        int ret=0;
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)!=B.charAt(i)){
                ret++;
            }
        }
        return ret;
    }
}

