import java.io.*;
import java.util.*;

public class Main {
    static int N,M,O;
    static boolean[][][] visited;
    static int[] size;
    static int[][] dir={{0,1},{0,2},{1,0},{1,2},{2,0},{2,1}};
    static Set<Integer> ans=new TreeSet<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        O=Integer.parseInt(st.nextToken());
        size=new int[3];
        size[0]=N;
        size[1]=M;
        size[2]=O;

        visited=new boolean[N+1][M+1][O+1];

        visited[0][0][O]=true;
        ans.add(O);
        dfs(0,0,O);

        for(int i:ans){
            bw.write(i+" ");
        }
        bw.flush();
    }
    static void dfs(int n,int m,int o){
//        System.out.println(n+" "+m+" "+o);
        int[] tmp={n,m,o};
        for(int i=0;i<6;i++){
            int[] next=move(tmp,i);
//            System.out.println(Arrays.toString(next));
            if(!visited[next[0]][next[1]][next[2]]){
                visited[next[0]][next[1]][next[2]]=true;
                if(next[0]==0)
                    ans.add(next[2]);
                dfs(next[0],next[1],next[2]);
            }
        }
    }
    static int[] move(int[] bowl,int op){
        int[] ret=new int[3];
        ret[0]=bowl[0];
        ret[1]=bowl[1];
        ret[2]=bowl[2];
        int s=bowl[dir[op][0]];
        int e=bowl[dir[op][1]];

        if(e+s<=size[dir[op][1]]){
            e=e+s;
            s=0;
        }
        else{
//            System.out.println("S"+" "+Math.abs(size[dir[op][1]]-(e+s)));
//            System.out.println(size[dir[op][1]]);
//            System.out.println(e+s);
            s=Math.abs(size[dir[op][1]]-(e+s));
            e=size[dir[op][1]];
        }
//        e=Math.min(size[dir[op][1]],e+s);
        ret[dir[op][0]]=s;
        ret[dir[op][1]]=e;
        return ret;
    }
}