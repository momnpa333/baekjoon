import java.io.*;
import java.util.*;

public class Main {
    static Set<String> KOISet;
    static String dna;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dna=st.nextToken();
        dp=new int[dna.length()+1][dna.length()+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(dna.length()-makeKOI(1,dna.length()));
//        for(int i=0;i<dp.length;i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }
    }
    static int makeKOI(int s,int e){
//        System.out.println(dna.substring(s-1,e));
        if(dp[s][e]!=-1) return dp[s][e];
//        System.out.println(s+" "+e);
//        System.out.println(dp[s][e]);
//        if(s==e){
//            dp[s][e]=1;
//            return dp[s][e];
//        }
        if(dna.substring(s-1,e).equals("at")||dna.substring(s-1,e).equals("gc")){
            dp[s][e]=0;
            return dp[s][e];
        }
        int ret=5000;
        if(dna.charAt(s-1)=='a' && dna.charAt(e-1)=='t'){
            ret=Math.min(makeKOI(s+1,e-1),ret);
        }
        if(dna.charAt(s-1)=='g' && dna.charAt(e-1)=='c'){
            ret=Math.min(makeKOI(s+1,e-1),ret);
        }

        if(s==e){
            dp[s][e]=1;
            return dp[s][e];
        }

        for(int i=s;i<=e-1;i++){
            ret=Math.min(ret,makeKOI(s,i)+makeKOI(i+1,e));
        }
        dp[s][e]=ret;
        return dp[s][e];
    }
}