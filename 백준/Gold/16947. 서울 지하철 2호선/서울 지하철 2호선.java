import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    static boolean[] isCircular;
    static int[] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());

        graph=new ArrayList[N+1];
        isCircular=new boolean[N+1];
        answer=new int[N+1];

        for(int i=0;i<=N;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine()," ");
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());

            graph[s].add(e);
            graph[e].add(s);
        }

        for(int i=1;i<=N;i++){
            isCircular[i]=checkCircular(i,0,i,new boolean[N+1]);
        }
//        System.out.println(Arrays.toString(isCircular));

        for(int i=1;i<=N;i++){
            if(!isCircular[i]){
                boolean[] tmp=new boolean[N+1];
                tmp[i]=true;
                answer[i]=makeLength(i,0,tmp);
            }
        }

        for(int i=1;i<=N;i++){
            bw.write(answer[i]+" ");
        }
        bw.flush();
//        System.out.println(Arrays.toString(answer));

    }
    static int makeLength(int v,int depth,boolean visited[]){
        int ret=0;
        if(isCircular[v]){
            return depth;
        }
        for(int next:graph[v]){
            if(!visited[next]){
                visited[next]=true;
                ret=Math.max(makeLength(next,depth+1,visited),ret);
            }
        }
        return ret;
    }
    static boolean checkCircular(int first,int parent,int v,boolean visited[]){
//        System.out.println(parent+" "+v);
        if(parent!=0 && v==first) return true;
        for(int next:graph[v]){
            if(next!=parent && !visited[next]){
                visited[next]=true;
                if(checkCircular(first,v,next,visited)){
                    return true;
                }
            }
        }
        return false;

    }
}


