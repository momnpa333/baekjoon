import java.io.*;
import java.util.*;

public class Main {
    static String sentence;
    static int N;
    static String[] words;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        sentence=br.readLine();
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        N=Integer.parseInt(st.nextToken());
        words=new String[N];
        dp=new int[sentence.length()+1];
        Arrays.fill(dp,987654321);
        for(int i=0;i<N;i++){
            words[i]=br.readLine();
        }
        dp[0]=0;
//        System.out.println(Arrays.toString(words));

        for(int i=0;i<=sentence.length();i++){
            for(int j=0;j<N;j++){
                if(i+words[j].length()>sentence.length()) continue;
                if(!isPossible(sentence.substring(i,i+words[j].length()),words[j])) continue;
                dp[i+words[j].length()]=Math.min(dp[i+words[j].length()],dp[i]+score(sentence.substring(i,i+words[j].length()),words[j]));
            }
        }
        if(dp[sentence.length()]==987654321){
            System.out.println(-1);
            return;
        }
        System.out.println(dp[sentence.length()]);
    }
    static boolean isPossible(String A,String B){
        int[] cntA=new int[30];
        int[] cntB=new int[30];
        Arrays.fill(cntA,0);
        Arrays.fill(cntB,0);
        for(int i=0;i<A.length();i++){
            cntA[A.charAt(i)-'a']++;
            cntB[B.charAt(i)-'a']++;
        }
        for(int i=0;i<30;i++){
            if(cntA[i]!=cntB[i]) return false;
        }
        return true;
    }
    static int score(String A,String B){
//        System.out.println("!");
//        System.out.println(A);
//        System.out.println(B);
        int ret=0;
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)==B.charAt(i)){
                ret++;
            }
        }
//        System.out.println(A.length()-ret);
        return A.length()-ret;
    }
}
