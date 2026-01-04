import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] words;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        words=new int[N];
        for(int i=0;i<N;i++){
            String tmp=br.readLine();
            words[i]=changeWord(tmp);
        }
//        System.out.println(Arrays.toString(words));
        brute(0,true,0);
        brute(0,false,0);
        System.out.println(ans);
    }
    static int changeWord(String word){
        int ret=0;
        for(int i=0;i<word.length();i++){
            ret=ret|(1<<word.charAt(i)-'a');
        }
//        System.out.println(ret);
        return ret;
    }
    static void brute(int cur,boolean op,int id){
//        System.out.println(id);
        if(op){
            cur=cur|words[id];
        }
        if(id==N-1) {
            if(cur==Math.pow(2,26)-1){
                ans++;
            }
            return;
        }
        brute(cur,true,id+1);
        brute(cur,false,id+1);
    }
}