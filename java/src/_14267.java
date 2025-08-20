import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _14267 {
    static int N,M;
    static int[] child;
    static int[] score;
    static ArrayList<Integer>[] graph;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken()); M=Integer.parseInt(st.nextToken());

        graph=new ArrayList[N+1];
        score=new int[N+1];
        answer=new int[N+1];
        for(int i=0;i<=N;i++){
            graph[i]=new ArrayList<>();
        }
        st=new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            int boss=Integer.parseInt(st.nextToken());
            if(boss==-1){
                continue;
            }
            graph[boss].add(i);
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine()," ");
            int tar=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            score[tar]+=v;
        }

        ArrayDeque<int[]> dq=new ArrayDeque<>();
        dq.add(new int[]{1,0});

        while(!dq.isEmpty()){
            int[] item=dq.poll();
            for(int child:graph[item[0]]){
                answer[child]+=item[1];
                dq.add(new int[]{child,item[1]+score[child]});
            }
        }
        for(int i=1;i<=N;i++){
            answer[i]+=score[i];
        }

        for(int i=1;i<=N;i++){
            bw.write(answer[i]+" ");
        }
        bw.flush();


    }

}
