import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] hist;
    static boolean[] visited;
    static int[] seq;
    static int score;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());

        hist=new int[N][9];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<9;j++){
                hist[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        visited=new boolean[9];
        seq=new int[9];
        visited[0]=true;
        seq[3]=0;
        permutation(0);
        System.out.println(score);
    }
    static void permutation(int idx){
        if(idx==3){
            permutation(4);
            return;
        }
        if(idx==9){
            score=Math.max(score,getScore());
            return;
        }
        for(int i=0;i<9;i++) {
            if (!visited[i]) {
                seq[idx] = i;
                visited[i] = true;
                permutation(idx+1);
                visited[i] = false;
            }
        }
    }
    static int getScore(){
        int score=0;
        int cur=0;
        for(int inning=0;inning<N;inning++){
            boolean[] base=new boolean[3];
            int outCount=0;
//            System.out.println(inning+" "+outCount);
            while(outCount<3){
                int op=hist[inning][seq[cur]];
//                System.out.println(cur+" "+op);
                cur=(cur+1)%9;
                if(op==0){
                    outCount++;
                    continue;
                }
                score+=moveBase(base,op);
            }
        }
        return score;
    }
    static int moveBase(boolean[] base,int op){
        int ret=0;
        if(op==4){
            for(int i=0;i<3;i++){
                if(base[i]) ret++;
                base[i]=false;
            }
            ret++;
            return ret;
        }
        for(int i=0;i<op;i++){
            if(base[2-i]) ret++;
        }
        for(int i=0;i<3;i++){
            if(2-i+op<3)
                base[2-i+op]=base[2-i];
        }
        for(int i=0;i<op-1;i++){
            base[i]=false;
        }
        base[op-1]=true;
        return ret;
    }
}

