import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<Integer>[] seqQ;
    static String S,T;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        seqQ=new PriorityQueue[26];

        for(int i=0;i<26;i++){
            seqQ[i]=new PriorityQueue<>();
        }

        S=br.readLine();
        T=br.readLine();

        for(int i=0;i<S.length();i++){
            seqQ[S.charAt(i)-'a'].add(i);
        }

        while(solve()){
//            System.out.println(ans);
            ans++;
        }
        System.out.println(ans);

    }
    static boolean solve(){
        int prevIdx=-1;
        for(int i=0;i<T.length();i++){
            int k=T.charAt(i)-'a';
            if(seqQ[k].isEmpty()) return false;
            int idx=seqQ[k].poll();
            while(idx<prevIdx && !seqQ[k].isEmpty()){
                idx=seqQ[k].poll();
            }
            if(idx<prevIdx) return false;
            prevIdx=idx;
        }
        return true;
    }

}
